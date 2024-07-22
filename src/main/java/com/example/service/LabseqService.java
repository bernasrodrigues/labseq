package com.example.service;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




/** Service class for computing and caching Labseq sequence values.
* Provides a method to retrieve the Labseq value at a specific index,*/
@ApplicationScoped
public class LabseqService {

    // Cache to store previously computed Labseq values
    private final Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();



    // Initialize base values
    public LabseqService() {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }



    /** Computes and retrieves the Labseq value at a specific index.
     * Uses memoization to optimize performance by caching results.
     *
     * @param n The index of the Labseq sequence.
     * @return The Labseq value at index n.*/
    public BigInteger getLabseqValue(int n) {
        // Check if the value is already in the cache
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Compute the value using the recursive formula
        BigInteger result = getLabseqValue(n - 4).add(getLabseqValue(n - 3));

        // Store the result in the cache
        cache.put(n, result);

        return result;
    }
}