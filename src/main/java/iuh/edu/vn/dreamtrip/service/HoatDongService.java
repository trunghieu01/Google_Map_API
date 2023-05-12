package iuh.edu.vn.dreamtrip.service;

import iuh.edu.vn.dreamtrip.entity.HoatDong;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface HoatDongService {
	public String createHoatDong(HoatDong new_hoat_dong) throws InterruptedException, ExecutionException;
	public List<HoatDong> getHoatDong(String document_id) throws InterruptedException, ExecutionException;
	public String updateHoatDong(HoatDong hd) throws InterruptedException, ExecutionException;
	public String deleteHoatDong(String document_id);
	public List<HoatDong> findAllsByTourId(String tourId) throws InterruptedException, ExecutionException;
	List<HoatDong> findAlls() throws InterruptedException, ExecutionException;
	HoatDong findById(String id) throws InterruptedException, ExecutionException;
}
