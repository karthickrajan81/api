package com.main.api.services;

import java.util.Collection;

public interface IFibonacciService {

    public Collection<Long> GetFibonacciSeries();

    public Long GetSumOfFibonacciSeries();

}
