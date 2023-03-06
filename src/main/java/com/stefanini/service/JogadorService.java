package com.stefanini.service;

import com.stefanini.dto.jogador.JogadorLoginDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.exceptions.jogador.JogadorNotFoundException;
import com.stefanini.exceptions.jogador.JogadorUnauthorizedException;
import com.stefanini.exceptions.jogador.NicknameConflictException;
import com.stefanini.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {

    public static final BigDecimal SALDO_INICIAL = new BigDecimal(3000);

    @Inject
    private JogadorRepository jogadorRepository;

    @Inject
    private CriptografiaService criptografiaService;

    @Inject
    private StefamonService stefamonService;

    public void salvar(Jogador novoJogador, Long idStefamon) {
        verificarNickname(novoJogador);
        criptografarSenha(novoJogador);
        novoJogador.setSaldo(SALDO_INICIAL);
        adicionarStefamon(novoJogador, idStefamon);
        jogadorRepository.save(novoJogador);
    }

    private void verificarNickname(Jogador jogador) {
        jogadorRepository.findByNickname(jogador.getNickname()).ifPresent((j) -> {
            throw new NicknameConflictException(j.getNickname());
        });
    }

    private void criptografarSenha(Jogador jogador) {
        String senhaCriptografada = criptografiaService.criptografar(jogador.getSenha());
        jogador.setSenha(senhaCriptografada);
    }

    private void adicionarStefamon(Jogador jogador, Long idStefamon) {
        if (!Objects.isNull(idStefamon)) {
            var stefamon = stefamonService.pegarPorId(idStefamon);
            jogador.adicionarStefamon(stefamon);
        }
    }

    public Jogador pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if (Objects.isNull(jogador)) {
            throw new JogadorNotFoundException(id);
        }
        return jogador;
    }

    public Jogador pegarPorIdComStefamons(Long id) {
        return jogadorRepository.findByIdFetchStefamons(id).orElseThrow(() -> new JogadorNotFoundException(id));
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

    public Jogador autenticar(JogadorLoginDTO dto) {
        var jogador = jogadorRepository.findByNickname(dto.getNickname()).orElseThrow(JogadorUnauthorizedException::new);
        String senha = criptografiaService.descriptografar(jogador.getSenha());
        if (!Objects.equals(senha, dto.getSenha())) {
            throw new JogadorUnauthorizedException();
        }
        return jogador;
    }
}
