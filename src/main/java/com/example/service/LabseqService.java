package com.example.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




@ApplicationScoped
public class LabseqService {

    private final Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();

    public LabseqService() {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

    public BigInteger getLabseqValue(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        BigInteger result = getLabseqValue(n - 4).add(getLabseqValue(n - 3));
        cache.put(n, result);

        return result;
    }
}