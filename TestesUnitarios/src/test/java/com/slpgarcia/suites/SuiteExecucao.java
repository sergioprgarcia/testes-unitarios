package com.slpgarcia.suites;

import org.junit.runners.Suite.SuiteClasses;

import com.slpgarcia.servicos.CalculadoraTest;
import com.slpgarcia.servicos.CalculoValorLocacaoTest;
import com.slpgarcia.servicos.LocacaoServiceTest;

//@RunWith(Suite.class)
@SuiteClasses({
	CalculadoraTest.class,
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class
})
public class SuiteExecucao {
	//executar todos os testes por uma classe.
}
