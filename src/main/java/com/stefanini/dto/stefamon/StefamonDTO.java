package com.stefanini.dto.stefamon;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    @JsonInclude(Include.NON_NULL)
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
        this.preco = BigDecimal.ZERO.compareTo(preco) < 0 ? preco.setScale(2, RoundingMode.HALF_UP) : null;
    }

    public StefamonDTO(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia, Integer poder, Integer velocidade, String urlFoto) {
        this(id, nome, vida, ataque, defesa, inteligencia, poder, velocidade, urlFoto, BigDecimal.ZERO);
    }

    public StefamonDTO(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia, Integer poder, Integer velocidade, String urlFoto, Double preco) {
        this(id, nome, vida, ataque, defesa, inteligencia, poder, velocidade, urlFoto, BigDecimal.valueOf(preco));
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
