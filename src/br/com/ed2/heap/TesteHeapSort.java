package br.com.ed2.heap;

public class TesteHeapSort {

		public static void main(String args[]){
			//{23,17,14,6,13,10,15,7,12}
			HeapBinario hb = new HeapBinario(9);
			hb.addElemento(23);
			hb.addElemento(17);
			hb.addElemento(14);
			hb.addElemento(6);
			hb.addElemento(13);
			hb.addElemento(10);
			hb.addElemento(15);
			hb.addElemento(7);
			hb.addElemento(12);
			
			System.out.println("Valores adicionados :\n");
			for(int i = 1 ;i <= hb.tamanho_heap;i++)
				System.out.println(hb.e[i]);
			
			System.out.println("\n");
			
			System.out.println("Construindo o Heap Maximo :\n");
			hb.buildMaxHeap();
			for(int i = 1 ;i <= hb.tamanho_heap;i++)
				System.out.println(hb.e[i]);
			
			System.out.println("\n");
			
			System.out.println("Ordenando com o Heap Sort :\n");
			hb.HeapSort();
			for(int i = 1 ;i <= hb.tamanho_heap;i++)
				System.out.println(hb.e[i]);
			
			
		}
}
