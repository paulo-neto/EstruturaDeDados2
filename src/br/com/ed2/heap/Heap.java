package br.com.ed2.heap;
public class Heap {

    private int [] heap;
    private int tam;
    private int comp;
    int maior;

    public Heap(int [] h){        
    	heap = h;
        comp = h.length;
        this.tam = comp;
    }
    
    public void set(int pos, int valor){
    	this.heap[pos-1] = valor;
    }
    
    
    public int get(int pos){
    	return this.heap[pos-1];
    
    }
    
    public int getComp(){
    	return this.comp;
    }
    

    public void maxHeapFY(int i){
        
        int l = 2 * i;
        int r = (2 * i) + 1;

        if(l <= this.tam && this.get(l) > this.get(i)){
            maior = l;
        }else maior = i;

        if(r <= this.tam && this.get(r) > this.get(maior)){
            maior = r;
        }

        if(this.get(maior) != this.get(i)){
            int temp = this.get(i);
            this.set(i, this.get(maior));
            this.set(maior, temp);
            maxHeapFY( maior);
        }
    }

    public int [] getVetor(){
        return this.heap;
    }
    
    public void buildMaxHeap(){
        int ini = tam/2;
        for(int t = ini; t >=1 ;t--){
            maxHeapFY(t);
        }
    }
    

    
}
