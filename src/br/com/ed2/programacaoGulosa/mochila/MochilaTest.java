package br.com.ed2.programacaoGulosa.mochila;


import java.io.File;
import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MochilaTest {

	@Before
	public void setUp() throws Exception {
	}
	@Test 
	public void testProdutoMaisLeve() throws FileNotFoundException {
		Mochila m1 = new Mochila(new File("mochila_4.txt"));
		Assert.assertEquals(4450.0,m1.produtoMaisLeve());
	}
	@Test
	public void testProdutoMaisCaro() throws FileNotFoundException{
		Mochila m1 = new Mochila(new File("mochila_4.txt"));
		Assert.assertEquals(4750.0, m1.produtoMaisCaro());
	}
	@Test
	public void testRazao() throws FileNotFoundException {
		Mochila m1 = new Mochila(new File("mochila_4.txt"));
		Assert.assertEquals(5150.0,m1.razao());
	}
}
