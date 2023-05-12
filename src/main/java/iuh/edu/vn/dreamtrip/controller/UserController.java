package iuh.edu.vn.dreamtrip.controller;

import iuh.edu.vn.dreamtrip.entity.NguoiDung;
import iuh.edu.vn.dreamtrip.entity.TaiKhoan;
import iuh.edu.vn.dreamtrip.security.PasswordEncoder;
import iuh.edu.vn.dreamtrip.service.NguoiDungServiceImp;
import iuh.edu.vn.dreamtrip.service.TaiKhoanServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    NguoiDungServiceImp nguoiDungService;

    @Autowired
    TaiKhoanServiceImp taiKhoanService;


    @GetMapping("/login")
    public NguoiDung login(@RequestParam String username, @RequestParam String password) throws InterruptedException, ExecutionException {
        TaiKhoan tk = taiKhoanService.getTK(username);
        String hashedPassword = PasswordEncoder.encode(password);
        if (tk != null && hashedPassword.equals(tk.getPassword())) {
            return nguoiDungService.getNguoiDungByEmail(tk.getUserName());
        }
        return null;
    }

    @GetMapping("/loginEmail")
    public NguoiDung loginByEmail(@RequestParam String email, @RequestParam String name, @RequestParam String avatar) throws InterruptedException, ExecutionException {
        if (nguoiDungService.getNguoiDungByEmail(email) == null) {
            taiKhoanService.insertTK(new TaiKhoan(email, "0000", false, false));
            nguoiDungService.insert(new NguoiDung(name, "", email, "", avatar));
        }
        return nguoiDungService.getNguoiDungByEmail(email);
    }

    @GetMapping("/get")
    public NguoiDung getById(@RequestParam String email) throws InterruptedException, ExecutionException {
        return nguoiDungService.getNguoiDungByEmail(email);
    }
}
