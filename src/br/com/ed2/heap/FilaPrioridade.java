package br.com.ed2.heap;
public class FilaPrioridade extends HeapBinario {

	
	public FilaPrioridade(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	public int heapMaximum(){
		return this.e[1];
	}
	
	public int heapExtractMax() {
		int r = heapMaximum();
		int t = this.e[this.tamanho_heap];
		this.e[this.tamanho_heap] = r;
		e[1] = t;
		this.tamanho_heap--;
		this.maxHeapify(1);
		return r;
	}
	
	public void heapIncreaseKey(int i,int chave) {
		if(chave<e[i])
			return;
		e[i] = chave;
		while(i>1 && e[this.Pai(i)]<e[i]) {
			int t = e[i];
			e[i] = e[this.Pai(i)];
			e[this.Pai(i)] = t;
			i = this.Pai(i); 
		}
	}
	
	public void maxHeapInsert(int i) {
		int num[] = new int[this.e.length+1];
		
		num[0] = 0;
		for(int j = 1;j <= num.length-2;j++) {
			num[j]=e[j];
		}
		e=num;
		this.tamanho_heap++;
		num[tamanho_heap] = -10000;
		heapIncreaseKey(tamanho_heap, i);
	}
	
 }
