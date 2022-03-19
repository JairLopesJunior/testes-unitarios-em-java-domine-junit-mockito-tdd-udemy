package br.ce.wcaquino.servicos;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {
	
	public static int count = 0;

	/* 1º Forma de grantir a Ordem
	public void inicia() {
		this.count = 1;
	}
	
	public void verifica() {
		assertEquals(1, this.count);
	}
	
	@Test
	public void testGeral() {
		this.inicia();
		this.verifica();
	}
	*/
	
	@Test
	public void inicia() {
		this.count = 1;
	}
	
	@Test
	public void verifica() {
		assertEquals(1, this.count);
	}
}
