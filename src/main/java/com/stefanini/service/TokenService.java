package com.stefanini.service;

import com.stefanini.entity.Jogador;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenService {

    public String generateToken(Jogador jogador) {
        return jogador.getId().toString();
    }
}
