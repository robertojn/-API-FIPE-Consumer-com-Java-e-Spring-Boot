package br.com.roberto.TabelaFipe.services;

import java.util.List;

public interface IConverteDados {
    public <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
