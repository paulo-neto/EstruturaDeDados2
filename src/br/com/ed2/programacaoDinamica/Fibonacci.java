package br.com.ed2.programacaoDinamica;

public class Fibonacci {
	public int fibonacci(int num){
	        int v[] = new int[num];
	        for(int i = 0; i < num; i++){
	            v[i]= -1;
	        }
	        return fibonacci(v,num);

	    }

	    private int fibonacci(int v[], int n){
	        if(v[n-1] != -1){
	            System.out.println("Fib : "+n);
	            return v[n-1];
	        }else{
	            if(n == 1 || n ==2){
	                v[n-1]=1;
	                return v[n-1];
	            }else{
	             v[n-1] = fibonacci(v, n - 1)+fibonacci(v, n - 2);
	            }
	            return v[n-1];
	        }
	    }
}
