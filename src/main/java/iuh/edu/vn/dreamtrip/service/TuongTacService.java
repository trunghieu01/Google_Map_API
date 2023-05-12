package iuh.edu.vn.dreamtrip.service;

import iuh.edu.vn.dreamtrip.entity.TuongTac;

import java.util.List;
import java.util.concurrent.ExecutionException;
public interface TuongTacService {
    String insert(TuongTac tuongTac) throws ExecutionException, InterruptedException;
    String update(TuongTac tuongTac) throws ExecutionException, InterruptedException;
    List<String> getTourIdPlaned(String userId) throws ExecutionException, InterruptedException;
    List<String> getTourIdLiked(String userId) throws ExecutionException, InterruptedException;
    List<String> getTourIdBooked(String userId) throws ExecutionException, InterruptedException;

    String like(String tourId, String userId) throws ExecutionException, InterruptedException;
    String unLike(String tourId, String userId) throws ExecutionException, InterruptedException;
    String book(String tourId, String userId) throws ExecutionException, InterruptedException;
    String plan(String tourId, String userId) throws ExecutionException, InterruptedException;
    String dropOutPlan(String tourId, String userId) throws ExecutionException, InterruptedException;

    boolean checkLike(String tourId, String userId) throws ExecutionException, InterruptedException;
}
