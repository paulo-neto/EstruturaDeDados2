package br.com.ed2.heap;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilaPrioridade e = new FilaPrioridade(9);
		
		e.addElemento(4);
		e.addElemento(1);
		e.addElemento(3);
		e.addElemento(16);
		
		
		for(int i = 1 ;i <= e.tamanho_heap;i++)
			System.out.println(e.e[i]);
		
		System.out.println("\n");
		
		e.buildMaxHeap();
		
		int j = e.heapExtractMax();
		
		System.out.println(j + "\n");
		
		
		for(int i = 1 ;i <= e.tamanho_heap;i++)
			System.out.println(e.e[i]);
		
		e.heapIncreaseKey(1, 16);;
		
		System.out.println("\n");
		
		for(int i = 1 ;i <= e.tamanho_heap;i++)
			System.out.println(e.e[i]);
		
		e.maxHeapInsert(11);
		
		System.out.println("\n");
		
		for(int i = 1 ;i <= e.tamanho_heap;i++)
			System.out.println(e.e[i]);
		
		
	}

}
