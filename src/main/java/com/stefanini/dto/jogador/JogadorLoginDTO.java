package com.stefanini.dto.jogador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JogadorLoginDTO {

    @NotBlank
    private final String nickname;

    @NotBlank
    @Size(min = 4, max = 10)
    private final String senha;

    public JogadorLoginDTO(String nickname, String senha) {
        this.nickname = nickname;
        this.senha = senha;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }
}
