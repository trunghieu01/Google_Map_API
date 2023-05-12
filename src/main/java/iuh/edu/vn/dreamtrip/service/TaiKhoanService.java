package iuh.edu.vn.dreamtrip.service;

import iuh.edu.vn.dreamtrip.entity.TaiKhoan;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface TaiKhoanService {

	public String insertTK(TaiKhoan taiKhoan) throws InterruptedException, ExecutionException;

	public TaiKhoan getTK(String userName) throws InterruptedException, ExecutionException;

	public String updateTK(TaiKhoan taiKhoan) throws InterruptedException, ExecutionException;

	public String deleteTK(String userName);
	public List<TaiKhoan> findAll() throws ExecutionException, InterruptedException;
}
