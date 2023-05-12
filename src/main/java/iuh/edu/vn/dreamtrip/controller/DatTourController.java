package iuh.edu.vn.dreamtrip.controller;

import iuh.edu.vn.dreamtrip.entity.KhachHangTour;
import iuh.edu.vn.dreamtrip.service.DatTourServiceImp;
import iuh.edu.vn.dreamtrip.service.TuongTacServiceImp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin()
@RestController
@RequestMapping("/datTour")
@NoArgsConstructor
public class DatTourController {

    @Autowired
    DatTourServiceImp datTourService;

    @Autowired
    TuongTacServiceImp tuongTacService;

    @PostMapping("/insert")
    @CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.2:8081"}, allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    public KhachHangTour insert(@RequestBody KhachHangTour k) throws ExecutionException, InterruptedException {
        datTourService.insert(k);
        tuongTacService.book(k.getTourId(), k.getNguoiDungId());
        return k;
    }

    @GetMapping("/getAll")
    public List<KhachHangTour> getAll() throws ExecutionException, InterruptedException {
        return datTourService.getAll();
    }

    @GetMapping("/getChecked")
    public List<KhachHangTour> getChecked() throws ExecutionException, InterruptedException {
        return datTourService.getChecked();
    }

    @GetMapping("/getNotChecked")
    public List<KhachHangTour> getNotChecked() throws ExecutionException, InterruptedException {
        return datTourService.getNotCheck();
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String tourId, @RequestParam String userId) throws ExecutionException, InterruptedException {
        return datTourService.check(tourId, userId);
    }
}
