package iuh.edu.vn.dreamtrip.controller;

import iuh.edu.vn.dreamtrip.dto.TaiKhoanAdminUserDTO;
import iuh.edu.vn.dreamtrip.entity.NguoiDung;
import iuh.edu.vn.dreamtrip.service.NguoiDungServiceImp;
import iuh.edu.vn.dreamtrip.service.TaiKhoanServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/admin")
public class AdminController {
	static Logger logger = Logger.getLogger(AdminController.class.getName());
	@Autowired
	private NguoiDungServiceImp nguoiDungService;
	@Autowired
	private TaiKhoanServiceImp tkDB;
	public AdminController(NguoiDungServiceImp nguoiDungService) {
		this.nguoiDungService = nguoiDungService;
	}
	// Đk tài khoản đầu vào là một lớp dto chứa 2 object là tk và thông tin tài khoản
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/create")
	public boolean insertNguoiDung(@RequestBody TaiKhoanAdminUserDTO tk_user_dto) throws InterruptedException, ExecutionException {
		if(tkDB.getTK(tk_user_dto.getTk().getUserName()) != null)
		{
			logger.log(Level.SEVERE, "Erro tao tai khoan: tên tài khoản đã tồn tại!");
			return false;
		}
		try {
			tkDB.insertTK(tk_user_dto.getTk());
			nguoiDungService.insertNguoiDung(tk_user_dto);
			return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro tao tai khoan:"+e);
			logger.log(Level.SEVERE, "tai khoan:"+tk_user_dto);
			return false;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/get")
	public NguoiDung getNguoiDung(@RequestParam String document_id) throws InterruptedException, ExecutionException {
		NguoiDung nd =  nguoiDungService.getNguoiDung(document_id);
		if (nd != null) {
			return nd;
		}
		logger.log(Level.WARNING, "Không tìm thấy người dùng có id: "+document_id);
		return null;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/findByEmail")
	public NguoiDung findNguoiDungByEmail(@RequestParam String email) throws InterruptedException, ExecutionException {
		NguoiDung nd =  nguoiDungService.getNguoiDungByEmail(email);
		return nd;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/update")
	public boolean updateNguoiDung(@RequestBody NguoiDung nguoiDung) throws InterruptedException, ExecutionException {
		String res =  nguoiDungService.updateNguoiDung(nguoiDung);
		if (res != null) {
			return true;
		}
		logger.log(Level.WARNING, "ERRO: Lỗi cập nhật thông tin : "+ nguoiDung);
		return false;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/delete")
	public boolean deleteNguoiDung(@RequestParam String document_id) throws InterruptedException, ExecutionException {
		if(nguoiDungService.getNguoiDung(document_id) == null)
		{
			logger.log(Level.SEVERE, "Erro xóa tai khoan: tài khoản không tồn tại!");
			return false;
		}
		try {
			 nguoiDungService.deleteNguoiDung(document_id);
			 return true;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Erro xóa người dùng:"+e);
			 return false;
		}
	}
}
