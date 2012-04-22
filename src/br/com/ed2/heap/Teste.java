package br.com.ed2.heap;

public class Teste {

	public static void main(String[] args) {
		FilaPrioridade fp = new FilaPrioridade(9);
		// {23,17,14,6,13,10,15,7,12}
		fp.addElemento(23);
		fp.addElemento(17);
		fp.addElemento(14);
		fp.addElemento(6);
		fp.addElemento(13);
		fp.addElemento(10);
		fp.addElemento(15);
		fp.addElemento(7);
		fp.addElemento(12);

		System.out.println("Valores adicionados :");
		String aux = "";
		for (int i = 1; i <= fp.tamanho_heap; i++)
			aux += "[" + fp.e[i] + "]" + " ";
		System.out.println(aux);
		System.out.println("\n--------------------------------------------\n");

		System.out.println("Costruindo a Heap :\n");
		fp.buildMaxHeap();
		aux = "";
		for (int i = 1; i <= fp.tamanho_heap; i++)
			aux += "[" + fp.e[i] + "]" + " ";
		System.out.println(aux);
		System.out.println("\n--------------------------------------------\n");

		System.out.println("Extraindo o maior valor :\n");
		int j = fp.heapExtractMax();
		System.out.println(j + "\n");
		aux = "";
		for (int i = 1; i <= fp.tamanho_heap; i++)
			aux += "[" + fp.e[i] + "]" + " ";
		System.out.println(aux);
		System.out.println("\n--------------------------------------------\n");


		System.out.println("Colocando na 2� posi��o o valor 16 :\n");
		fp.heapIncreaseKey(2, 16);
		aux = "";
		for (int i = 1; i <= fp.tamanho_heap; i++)
			aux += "[" + fp.e[i] + "]" + " ";
		System.out.println(aux);
		System.out.println("\n--------------------------------------------\n");


		System.out.println("Inserindo um novo folha com valor 11 :\n");
		fp.maxHeapInsert(11);
		aux = "";
		for (int i = 1; i <= fp.tamanho_heap; i++)
			aux += "[" + fp.e[i] + "]" + " ";
		System.out.println(aux);
		System.out.println("\n--------------------------------------------\n");
		
		System.out.println("Ordenando com o Heap Sort :\n");
		fp.HeapSort();
		aux = "";
		for (int i = 1; i <= fp.comprimento; i++)
			aux += "[" + fp.e[i] + "]" + " ";
		System.out.println(aux);

	}

}
