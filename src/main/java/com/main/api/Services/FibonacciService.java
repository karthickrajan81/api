package com.main.api.services;

import java.util.Collection;
import java.util.HashMap;

import com.main.api.exceptionhandler.BadRequestException;

import java.lang.Exception;

public class FibonacciService implements IFibonacciService {
    private HashMap<Integer, Long> _cache = new HashMap<Integer, Long>();
    private int _inputNumber;

    public FibonacciService(int inputNumber) throws Exception {
        // Constraints:
        // No Negative numbers allowed
        // Fibonacci value should be less or equal to Long.MaxValue
        if (inputNumber < 0 || inputNumber > 92) {
            throw new BadRequestException("Invalid Input");
        }
        _inputNumber = inputNumber;
        processFibSeriesRecursively(inputNumber);
    }

    private Long processFibSeriesRecursively(int inputNumber) {
        if (!_cache.containsKey(inputNumber)) {
            if (inputNumber > 1) {
                var n1 = inputNumber - 1;
                if (!_cache.containsKey(n1)) {
                    _cache.put(n1, processFibSeriesRecursively(n1));
                }
                var n2 = inputNumber - 2;
                if (!_cache.containsKey(n2)) {
                    _cache.put(n2, processFibSeriesRecursively(n2));
                }
                _cache.put(inputNumber, _cache.get(n1) + _cache.get(n2));
            } else {
                if (!_cache.containsKey(inputNumber)) {
                    Long val = Long.valueOf(inputNumber);
                    _cache.put(inputNumber, val);
                }
            }
        }
        return _cache.get(inputNumber);
    }

    public Collection<Long> GetFibonacciSeries() {
        return _cache.values();
    }

    public Long GetSumOfFibonacciSeries() {
        return _cache.get(_inputNumber);
    }
}
