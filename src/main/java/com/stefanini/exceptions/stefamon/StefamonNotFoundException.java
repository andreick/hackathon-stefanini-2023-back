package com.stefanini.exceptions.stefamon;

import com.stefanini.exceptions.RegraDeNegocioException;

import javax.ws.rs.core.Response;

public class StefamonNotFoundException extends RegraDeNegocioException {

    public StefamonNotFoundException(Long id) {
        super("Stefamon com id " + id + " não encontrado", Response.Status.NOT_FOUND);
    }
}
