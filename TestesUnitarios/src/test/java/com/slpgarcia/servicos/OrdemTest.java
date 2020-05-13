package com.slpgarcia.servicos;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //ordem de execução de testes por ordem alfabética
public class OrdemTest {

	public static int contador = 0;
	
	@Test
	public void inicia() {
		contador = 1;
	}
	
	@Test
	public void veririca() {
		Assert.assertEquals(1, contador);
	}
}
