package com.stefanini.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, length = 16)
    private String senha;

    @Column(nullable = false)
    private BigDecimal saldo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_jogador_stefamon",
            joinColumns = {@JoinColumn(name = "idJogador")},
            inverseJoinColumns = {@JoinColumn(name = "idStefamon")})
    private List<Stefamon> stefamons = new ArrayList<>();

    public Jogador() {
    }

    public Jogador(Long id, String nickname, String senha) {
        this(id, nickname, senha, null);
    }

    public Jogador(Long id, String nickname, String senha, BigDecimal saldo) {
        this.id = id;
        this.nickname = nickname;
        this.senha = senha;
        this.saldo = Objects.requireNonNullElse(saldo, BigDecimal.ZERO);
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Stefamon> getStefamons() {
        return stefamons;
    }

    public void adicionarStefamon(Stefamon stefamon) {
        stefamons.add(stefamon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(nickname, jogador.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nickname = " + nickname + ", " +
                "senha = " + senha + ", " +
                "saldo = " + saldo + ")";
    }
}
