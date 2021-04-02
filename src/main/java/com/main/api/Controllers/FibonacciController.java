package com.main.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import com.main.api.services.FibonacciService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FibonacciController {

    private static final Logger logger = LoggerFactory.getLogger(FibonacciController.class);

    @GetMapping("/fib")
    public Collection<Long> getFibonacciSeries(@RequestParam(value = "input") int input) throws Exception {
        try {
            var fibService = new FibonacciService(input);
            return fibService.GetFibonacciSeries();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

    @GetMapping("/fibsum")
    public Long getFibonacciSum(@RequestParam(value = "input") int input) throws Exception {
        try {
            var fibService = new FibonacciService(input);
            return fibService.GetSumOfFibonacciSeries();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex.fillInStackTrace());
            throw ex;
        }
    }

}
