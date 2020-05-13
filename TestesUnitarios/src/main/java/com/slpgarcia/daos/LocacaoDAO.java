package com.slpgarcia.daos;

import java.util.List;

import com.slpgarcia.entidades.Locacao;

public interface LocacaoDAO {

	public void salvar(Locacao locacao);

	public List<Locacao> obterLocacoesPendentes();
}

