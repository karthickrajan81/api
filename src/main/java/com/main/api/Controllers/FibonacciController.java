package com.main.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import com.main.api.Services.FibonacciService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class FibonacciController {

    @GetMapping("/fib")
    public Collection<Long> getFibonacciSeries(@RequestParam(value = "input") int input) throws Exception {
        var fibService = new FibonacciService(input);
        return fibService.GetFibonacciSeries();
    }

    @GetMapping("/fibsum")
    public Long getFibonacciSum(@RequestParam(value = "input") int input) throws Exception {
        var fibService = new FibonacciService(input);
        return fibService.GetSumOfFibonacciSeries();
    }

}
