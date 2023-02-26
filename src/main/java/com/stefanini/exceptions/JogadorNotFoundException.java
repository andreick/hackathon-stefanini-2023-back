package com.stefanini.exceptions;

import javax.ws.rs.core.Response;

public class JogadorNotFoundException extends RegraDeNegocioException {

    public JogadorNotFoundException(Long id) {
        super("Jogador com id " + id + " não encontrado", Response.Status.NOT_FOUND);
    }
}
