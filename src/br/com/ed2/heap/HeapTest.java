package br.com.ed2.heap;
public class HeapTest {


    public static void main(String[] args) {

        int [] v = new int[] {23,17,14,6,13,10,15,7,12};
        Heap heap = new Heap(v);
        heap.buildMaxHeap();
       //heap.maxHeapFY(4);
        for(int i=0;i<v.length;i++){
            System.out.print(v[i] + ", ");
        }

    }
}
