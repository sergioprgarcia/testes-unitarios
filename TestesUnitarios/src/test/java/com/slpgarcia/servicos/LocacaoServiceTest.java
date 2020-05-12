package com.slpgarcia.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.slpgarcia.entidades.Filme;
import com.slpgarcia.entidades.Locacao;
import com.slpgarcia.entidades.Usuario;
import com.slpgarcia.entidades.exceptions.FilmeSemEstoqueException;
import com.slpgarcia.entidades.exceptions.LocadoraException;
import com.slpgarcia.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Rule
	public ExpectedException expection = ExpectedException.none();

	@Test
	public void testeLocacao() throws Exception {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1" , 2, 5.0);
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		
		//boa prática fazer um asserth por método
		
		//Assert.assertEquals(5.0, locacao.getValor(), 0.01);
		//Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		//Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		//usando o assertThat 
		
		assertThat(locacao.getValor(), is(5.0));
		assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
	
	//Formas de tratar exceção
	
	//Modelo 1 
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void testFilmeSemEstoque() throws Exception {
		//cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1" , 0, 5.0);
		
		//acao
		service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void testUsuarioVazio() throws FilmeSemEstoqueException {
		//cenario
		LocacaoService service = new LocacaoService();
		Filme filme = new Filme("Filme 2", 1, 5.0);
		
		//ação
		try {
			service.alugarFilme(null, filme);
			
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuário vázio"));
		}
	
	}
	
}