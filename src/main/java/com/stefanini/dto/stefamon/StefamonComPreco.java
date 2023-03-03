package com.stefanini.dto.stefamon;

import com.stefanini.entity.Stefamon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StefamonComPreco {

    private final Stefamon stefamon;
    private final BigDecimal preco;

    public StefamonComPreco(Stefamon stefamon, BigDecimal preco) {
        this.stefamon = stefamon;
        this.preco = preco.setScale(2, RoundingMode.HALF_UP);
    }

    public StefamonComPreco(Stefamon stefamon, double preco) {
        this(stefamon, BigDecimal.valueOf(preco));
    }

    public Stefamon getStefamon() {
        return stefamon;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
