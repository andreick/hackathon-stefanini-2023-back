package com.stefanini.service;

import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.JogadorNotFoundException;
import com.stefanini.exceptions.NicknameConflictException;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {

    @Inject
    private JogadorRepository jogadorRepository;

    @Inject
    private CriptografiaService criptografiaService;

    public void salvar(Jogador novoJogador) {
        jogadorRepository.findByNickname(novoJogador.getNickname()).ifPresent((jogador) -> {
            throw new NicknameConflictException(jogador.getNickname());
        });
        var senhaCriptografada = criptografiaService.criptografar(novoJogador.getSenha());
        novoJogador.setSenha(senhaCriptografada);
        System.out.println(senhaCriptografada);
        jogadorRepository.save(novoJogador);
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if (Objects.isNull(jogador)) {
            throw new JogadorNotFoundException(id);
        }
        return jogador;
    }

    public Jogador alterar(Long id, Jogador jogadorAtualizado) {
        var jogador = pegarPorId(id);
        jogador.setSaldo(jogadorAtualizado.getSaldo());
        return jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.listAll();
    }
}
