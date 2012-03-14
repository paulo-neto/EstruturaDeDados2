package br.com.ed2.heap;

public class HeapBinario {

	public int[] e;
	public int tamanho_heap;
	public int comprimento;

	public HeapBinario(int n) {
		e = new int[n + 1];
		e[0] = 0;
		this.tamanho_heap = this.comprimento = 0;
	}

	public void addElemento(int i) {
		this.tamanho_heap++;
		this.comprimento++;
		e[tamanho_heap] = i;

	}

	public int Pai(int i) {
		return i / 2;
	}

	public int esquerdo(int i) {
		return 2 * i;
	}

	public int direito(int i) {
		return 2 * i + 1;
	}

	public void maxHeapify(int i) {
		int l = esquerdo(i);
		int r = direito(i);
		int maior = i;

		if (l <= this.tamanho_heap && e[l] > e[i])
			maior = l;
		
		if (r <= this.tamanho_heap && e[r] > e[maior])
			maior = r;
		if (maior != i) {
			int t = e[i];
			e[i] = e[maior];
			e[maior] = t;
			maxHeapify(maior);

		}

	}

	public void buildMaxHeap() {
		
		
		for (int i = this.comprimento / 2; i >= 1; i--) {
			maxHeapify(i);
		}
	}
	
	public void HeapSort(){
		buildMaxHeap();
		
		for(int i= comprimento;i>1;i--) {
			int t = this.e[1];
			this.e[1] = this.e[tamanho_heap];
			this.e[tamanho_heap] = t;
			tamanho_heap--;
			maxHeapify(1);
		}
	}
}
