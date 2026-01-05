package com.enterprise.catalog.noyau.mappeur;

public interface Mappeur<S, T> {
    T map(S source);
}
