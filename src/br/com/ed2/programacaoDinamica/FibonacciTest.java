package br.com.ed2.programacaoDinamica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFibonacci() {
		Fibonacci fib = new Fibonacci();
		int num = 60;
		int res = fib.fibonacci(num);
		System.out.println(" Fibonacci de "+num+" é : "+res);
		
	}

}
