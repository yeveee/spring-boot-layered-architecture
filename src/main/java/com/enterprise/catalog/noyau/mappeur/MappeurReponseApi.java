package com.enterprise.catalog.noyau.mappeur;

import com.enterprise.catalog.noyau.modele.ModeleApi;
import com.enterprise.catalog.noyau.modele.ModeleInterne;

public interface MappeurReponseApi<I extends ModeleInterne, A extends ModeleApi> 
        extends Mappeur<I, A> {
}