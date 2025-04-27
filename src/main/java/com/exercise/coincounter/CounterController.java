package com.exercise.coincounter;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CounterController {

    @CrossOrigin
    @PostMapping("/count")
    public List<CounterResult> count(@RequestParam("priceInCents") @Min(0) Integer priceInCents) {
        return Counter.count(priceInCents);
    }
}
