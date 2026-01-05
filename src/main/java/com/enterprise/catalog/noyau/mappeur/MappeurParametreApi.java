package com.enterprise.catalog.noyau.mappeur;

import com.enterprise.catalog.noyau.modele.ModeleApi;
import com.enterprise.catalog.noyau.modele.ModeleInterne;

public interface MappeurParametreApi<A extends ModeleApi, I extends ModeleInterne> 
        extends Mappeur<A, I> {
}