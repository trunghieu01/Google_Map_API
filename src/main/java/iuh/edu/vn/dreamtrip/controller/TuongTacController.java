package iuh.edu.vn.dreamtrip.controller;

import iuh.edu.vn.dreamtrip.entity.TuongTac;
import iuh.edu.vn.dreamtrip.service.TuongTacServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin()
@RestController
@RequestMapping("/tuongtac")
public class TuongTacController {
    @Autowired
    TuongTacServiceImp tuongTacServiceImp;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/insert")
    public String insertTour(@RequestBody TuongTac tuongTac) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.insert(tuongTac);
    }

    @PutMapping("/update")
    public String update(@RequestBody TuongTac tuongTac) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.insert(tuongTac);
    }

    @PutMapping("/like")
    public String like(@RequestParam String tourId,@RequestParam String userId) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.like(tourId,userId);
    }

    @PutMapping("/unlike")
    public String unlike(@RequestParam String tourId,@RequestParam String userId) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.unLike(tourId,userId);
    }

    @PutMapping("/plan")
    public String plan(@RequestParam String tourId,@RequestParam String userId) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.plan(tourId,userId);
    }

    @PutMapping("/dropOurPlan")
    public String dropPlan(@RequestParam String tourId,@RequestParam String userId) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.dropOutPlan(tourId,userId);
    }

    @PutMapping("/book")
    public String book(@RequestParam String tourId,@RequestParam String userId) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.book(tourId,userId);
    }

    @GetMapping("/check")
    public boolean checkLiked(@RequestParam String tourId,@RequestParam String userId) throws InterruptedException, ExecutionException {
        return tuongTacServiceImp.checkLike(tourId,userId);
    }

}
