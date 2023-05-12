package iuh.edu.vn.dreamtrip.service;

import iuh.edu.vn.dreamtrip.entity.OTP;

import java.util.concurrent.ExecutionException;

public interface OTPService {
    public String create(String email) throws ExecutionException, InterruptedException;
    public OTP getOTP(String email) throws ExecutionException, InterruptedException;
}
