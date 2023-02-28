package com.stefanini.exceptions.jogador;

import com.stefanini.exceptions.RegraDeNegocioException;

import javax.ws.rs.core.Response;

public class JogadorUnauthorizedException extends RegraDeNegocioException {

    public JogadorUnauthorizedException() {
        super("Jogador não autenticado", Response.Status.UNAUTHORIZED);
    }
}
