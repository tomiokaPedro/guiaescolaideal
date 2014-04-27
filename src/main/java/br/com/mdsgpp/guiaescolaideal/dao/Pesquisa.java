package br.com.mdsgpp.guiaescolaideal.dao;

import java.util.List;

import br.com.mdsgpp.guiaescolaideal.model.Escola;

public interface Pesquisa<V> {
	public List<V> pesquisarPorEscola(Escola escola);
}
