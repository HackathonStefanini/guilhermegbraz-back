package com.stefanini.configurations;

import com.stefanini.core.casosDeUso.criarJogador.CriarJogador;
import com.stefanini.core.casosDeUso.criarJogador.validacoes.*;
import com.stefanini.core.casosDeUso.criptografarSenha.Criptografador;
import com.stefanini.core.casosDeUso.criptografarSenha.CriptografarSenhaBase64;
import com.stefanini.core.repositorios.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;

public class ConfiguracaoCasosDeUso {

    @Produces
    @ApplicationScoped
    public CriarJogador criarJogador(JogadorRepository jogadorRepository, List<ValidacoesCriacao> validacoes,
                                     Criptografador criptografador) {
        return new CriarJogador(jogadorRepository, validacoes, criptografador);
    }

    @Produces
    @ApplicationScoped
    public Criptografador criptografador() {
        return new CriptografarSenhaBase64();
    }

    @Produces
    @ApplicationScoped
    public List<ValidacoesCriacao> validacoesCriacao(JogadorRepository jogadorRepository) {
        return List.of(new ValidadorNicknameObrigatorio(), new ValidadorNicknameUnico(jogadorRepository),
                new ValidadorSenhaObrigatoria(), new ValidadorTamanhoSenha());
    }


}