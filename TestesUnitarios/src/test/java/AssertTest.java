

import org.junit.Assert;
import org.junit.Test;

import com.slpgarcia.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void test() {
		
		//Verifica se a expressão é verdadeira
		Assert.assertTrue(true);
		
		//Verifica se a expressão é falsa
		Assert.assertFalse(false);
		
		//Verifica se os valores são iguais
		Assert.assertEquals(1, 1);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i,  i2.intValue());
	
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		
		//entidade usuario implementado equals e hashcode, assim valida
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		
		Assert.assertEquals(u1, u2);
		
		Assert.assertNotSame(u1, u2);
		
		Assert.assertNotNull(u2);
	}

}
