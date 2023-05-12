package iuh.edu.vn.dreamtrip.controller;

import iuh.edu.vn.dreamtrip.dto.TaiKhoanAdminUserDTO;
import iuh.edu.vn.dreamtrip.entity.TaiKhoan;
import iuh.edu.vn.dreamtrip.security.PasswordEncoder;
import iuh.edu.vn.dreamtrip.service.NguoiDungServiceImp;
import iuh.edu.vn.dreamtrip.service.OTPServiceImp;
import iuh.edu.vn.dreamtrip.service.TaiKhoanServiceImp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@NoArgsConstructor
@RequestMapping("/taikhoan")
public class TaiKhoanController {
	static Logger logger = Logger.getLogger(AdminController.class.getName());

	@Autowired
	TaiKhoanServiceImp taikKhoanServiceImp;
	@Autowired
	private NguoiDungServiceImp nguoiDungService;
    @Autowired
    OTPServiceImp otpService;
	// Đk tài khoản đầu vào là một lớp dto chứa 2 object là tk và thông tin tài
	// khoản
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/register")
	public boolean dangKyTaiKhoan(@RequestBody TaiKhoanAdminUserDTO tk_user_dto)
			throws InterruptedException, ExecutionException {
		if (taikKhoanServiceImp.getTK(tk_user_dto.getTk().getUserName()) != null) {
			logger.log(Level.SEVERE, "Erro tao tai khoan: tên tài khoản đã tồn tại!");
			return false;
		}
		try {
//			tk_user_dto.getTk().setPassword(new BCryptPasswordEncoder().encode(tk_user_dto.getTk().getPassword()));
			taikKhoanServiceImp.insertTK(tk_user_dto.getTk());
			nguoiDungService.insertNguoiDung(tk_user_dto);
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro tao tai khoan:" + e);
			logger.log(Level.SEVERE, "tai khoan:" + tk_user_dto);
			return false;
		}
	}

    //	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping("/get")
//	public TaiKhoan getTK(@RequestParam String username) throws InterruptedException, ExecutionException {
//		TaiKhoan tk = taikKhoanServiceImp.getTK(username);
//		if (tk != null) {
//			return tk;
//		}
//		logger.log(Level.WARNING, "Không tìm thấy tài khoản với username :" + username);
//		return null;
//	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/loggin")
	public TaiKhoan getTK(@RequestParam String username) throws InterruptedException, ExecutionException {
		TaiKhoan tk = taikKhoanServiceImp.getTK(username);
		if (tk != null) {
			return tk;
		}
		logger.log(Level.WARNING, "Không tìm thấy tài khoản với username :" + username);
		return null;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/logginUser")
	public TaiKhoan logginUser(@RequestParam String userName, @RequestParam String password) throws InterruptedException, ExecutionException {
		TaiKhoan tk = taikKhoanServiceImp.getTK(userName);
		String hashedPassword = PasswordEncoder.encode(password);
		if (tk != null && hashedPassword.equals(tk.getPassword())) {
			return tk;
		}
		logger.log(Level.WARNING, "Không tìm thấy tài khoản với username :" + userName);
		return null;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update")
	public boolean updateTK(@RequestBody TaiKhoan taiKhoan) throws InterruptedException, ExecutionException {
		String res = taikKhoanServiceImp.updateTK(taiKhoan);
		if (res != null) {
			return true;
		}
		logger.log(Level.WARNING, "Không thể cập nhật tài khoản :" + taiKhoan);
		return false;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/updateMK")
	public boolean updateMatKhau(@RequestBody TaiKhoan taiKhoan) throws InterruptedException, ExecutionException {
		String hashedPassword = PasswordEncoder.encode(taiKhoan.getPassword());
		taiKhoan.setPassword(hashedPassword);
		String res = taikKhoanServiceImp.updateTK(taiKhoan);
		if (res != null) {
			return true;
		}
		logger.log(Level.WARNING, "Không thể cập nhật tài khoản :" + taiKhoan);
		return false;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete")
	public boolean deleteTK(@RequestParam String username) throws InterruptedException, ExecutionException {
		String res = taikKhoanServiceImp.deleteTK(username);
		if (res != null) {
			return true;
		}
		logger.log(Level.WARNING, "Không thể xóa tài khoản :" + username);
		return false;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/findAll")
	public List<TaiKhoan> findAll() throws InterruptedException, ExecutionException {
		return  taikKhoanServiceImp.findAll();
	}

}
