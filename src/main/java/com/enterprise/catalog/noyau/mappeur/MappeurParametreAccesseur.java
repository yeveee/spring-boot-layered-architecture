package com.enterprise.catalog.noyau.mappeur;

import com.enterprise.catalog.noyau.modele.ModeleAccesseur;
import com.enterprise.catalog.noyau.modele.ModeleInterne;

public interface MappeurParametreAccesseur<I extends ModeleInterne, A extends ModeleAccesseur> 
        extends Mappeur<I, A> {
}