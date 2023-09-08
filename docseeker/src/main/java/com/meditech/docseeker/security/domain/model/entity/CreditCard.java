package com.meditech.docseeker.security.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {

    private int id;
    private float Saldo;


    public CreditCard(int id, float saldo) {
        this.id = id;
        Saldo = saldo;
    }
}
