package com.enterprise.catalog.noyau.mappeur;

import com.enterprise.catalog.noyau.modele.ModeleAccesseur;
import com.enterprise.catalog.noyau.modele.ModeleInterne;

public interface MappeurReponseAccesseur<A extends ModeleAccesseur, I extends ModeleInterne> 
        extends Mappeur<A, I> {
}