package com.stefanini.dto.stefamon;

import java.math.BigDecimal;

public class StefamonDTO {

    private final Long id;
    private final String nome;
    private final Integer vida;
    private final Integer ataque;
    private final Integer defesa;
    private final Integer inteligencia;
    private final Integer poder;
    private final Integer velocidade;
    private final String urlFoto;
    private final BigDecimal preco;

    public StefamonDTO(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia, Integer poder, Integer velocidade, String urlFoto, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.poder = poder;
        this.velocidade = velocidade;
        this.urlFoto = urlFoto;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public Integer getPoder() {
        return poder;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
