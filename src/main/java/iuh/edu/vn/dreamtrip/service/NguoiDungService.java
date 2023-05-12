package iuh.edu.vn.dreamtrip.service;

import iuh.edu.vn.dreamtrip.dto.TaiKhoanAdminUserDTO;
import iuh.edu.vn.dreamtrip.entity.NguoiDung;

import java.util.concurrent.ExecutionException;

public interface NguoiDungService {

	public String insertNguoiDung(TaiKhoanAdminUserDTO tk_user_dto) throws InterruptedException, ExecutionException;

	public String insert(NguoiDung tk_user_dto) throws InterruptedException, ExecutionException;

	public NguoiDung getNguoiDung(String document_id) throws InterruptedException, ExecutionException;
	public NguoiDung getNguoiDungByEmail(String email) throws InterruptedException, ExecutionException;

	public String updateNguoiDung(NguoiDung adminUser) throws InterruptedException, ExecutionException;

	public String deleteNguoiDung(String document_id);
}
