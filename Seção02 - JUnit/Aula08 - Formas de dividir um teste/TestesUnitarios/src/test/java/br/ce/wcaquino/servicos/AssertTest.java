package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertEquals(1, 1);
		Assert.assertEquals(0.51, 0.51, 0.01);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Jair");
		Usuario u2 = new Usuario("Jair");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2); // Verifica se o Objeto é igual
		Assert.assertSame(u1, u1); // Verifica se a Instancia dos Objetos são iguais.
		
		Assert.assertTrue(u3 == null); // Verificar se o Objeto é null
		Assert.assertNull(u3);         // Verificar se o Objeto é null
	}
}


















