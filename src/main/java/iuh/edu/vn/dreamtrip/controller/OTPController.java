package iuh.edu.vn.dreamtrip.controller;

import iuh.edu.vn.dreamtrip.entity.OTP;
import iuh.edu.vn.dreamtrip.service.OTPServiceImp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@NoArgsConstructor
@RequestMapping("/otp")
public class OTPController {

    @Autowired
    OTPServiceImp otpService;

    @PostMapping("/create")
    public String createOTP(@RequestParam String email) throws InterruptedException, ExecutionException {
        return otpService.create(email);
    }

    @GetMapping("/get")
    public OTP getOTP(@RequestParam String email) throws InterruptedException, ExecutionException {
        return otpService.getOTP(email);
    }
}
