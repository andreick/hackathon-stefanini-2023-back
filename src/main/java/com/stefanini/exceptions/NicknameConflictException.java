package com.stefanini.exceptions;

import javax.ws.rs.core.Response;

public class NicknameConflictException extends RegraDeNegocioException {

    public NicknameConflictException(String nickname) {
        super("O nickname " + nickname + " já está em uso", Response.Status.CONFLICT);
    }
}
