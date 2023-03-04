package com.stefanini.dto.jogador;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class JogadorCadastroDTO {

    @NotBlank
    private final String nickname;

    @NotBlank
    @Size(min = 4, max = 10)
    private final String senha;

    @Positive
    private final Long idStefamonInicial;

    public JogadorCadastroDTO(String nickname, String senha, Long idStefamonInicial) {
        this.nickname = nickname;
        this.senha = senha;
        this.idStefamonInicial = idStefamonInicial;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public Long getIdStefamonInicial() {
        return idStefamonInicial;
    }
}
