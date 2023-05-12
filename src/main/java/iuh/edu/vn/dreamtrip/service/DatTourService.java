package iuh.edu.vn.dreamtrip.service;

import iuh.edu.vn.dreamtrip.entity.KhachHangTour;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface DatTourService {
    KhachHangTour insert(KhachHangTour k) throws ExecutionException, InterruptedException;
    boolean update(KhachHangTour k);
    List<KhachHangTour> getAll() throws ExecutionException, InterruptedException;
    List<KhachHangTour> getNotCheck() throws ExecutionException, InterruptedException;
    List<KhachHangTour> getChecked() throws ExecutionException, InterruptedException;

    boolean check(String tourId, String userId) throws ExecutionException, InterruptedException;
}
