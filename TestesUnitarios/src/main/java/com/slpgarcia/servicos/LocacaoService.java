package com.slpgarcia.servicos;

import static com.slpgarcia.utils.DataUtils.adicionarDias;

import java.util.Date;

import com.slpgarcia.entidades.Filme;
import com.slpgarcia.entidades.Locacao;
import com.slpgarcia.entidades.Usuario;
import com.slpgarcia.entidades.exceptions.FilmeSemEstoqueException;
import com.slpgarcia.entidades.exceptions.LocadoraException;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws FilmeSemEstoqueException, LocadoraException {
		if(filme.getEstoque() == 0 ) {
			throw new FilmeSemEstoqueException();
		}
		
		if(usuario == null) {
			throw new LocadoraException("Usuário vázio");
		}
		
		if (filme == null) {
			throw new LocadoraException("Filme vázio");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		return locacao;
	}
	
}