package br.com.ed2.programacaoDinamica;

public class Quick_Sort {
	int [] vet;
	
	public Quick_Sort(){
		vet = new int [10]; 	
	}	
	 //Verifica se existe um valor em um vetor de inteiros. Para isto o vetor de entrada deve estar ordenado.
	public boolean contem(int[] umVetor, int inicio, int fim, int valor) {

		//DIVIS�O: Coloca na vari�vel "meio" a divis�o entre as extremidades do vetor a cada chamada recursiva ao mesmo.
		int meio = (fim + inicio) / 2;		
		
		
		// BASE: Verifica se o elemento do meio cont�m o valor que se est� procurando.
		if (umVetor[meio] == valor)
			return true;		
		
		//	CONQUISTA: Verifica se o valor procurado est� a direita ou esquerda do vetor, ou seja, se o valor do 
		//  meio for maior do que o procurado, ent�o, chama recursivo do in�cio at� o (meio - 1), caso contr�rio, chama 	
		//  recursivo para o (meio + 1) at� o fim.
		if (umVetor[meio] > valor && (meio - 1) >= inicio)
			return contem(umVetor, inicio, meio - 1, valor); /* vetor a esquerda*/
		else
			if (umVetor[meio] < valor && (meio + 1) <= fim)
				return contem(umVetor, meio + 1, fim, valor); /* vetor a direita*/	
		
		//Se chegar ao fim e nao encontrar o valor, retorna "false".
		return false;
	}
		 	 

	// O procedimento de divis�o e conquista do Algoritmo de Ordena��o
	// Quick-Sort consiste em colocar os valores em suas posi��es corretas.
	// Assim, ap�s colocar o chamado elemento "piv�" em sua posi��o correta,
	// todos os elementos que estiverem a sua esquerda
	// formar�o um sub-vetor, como tamb�m os que estiverem ao lado direito desse
	// piv�. Sendo assim, cada um desses
	// sub-vetores ser�o passados recursivamente para a fun��o para que tenham o
	// piv� de cada um colocado na sua posi��o
	// correta. Ap�s o fim da fun��o, todos os elementos estar�o ordenados.	 
	
	//2� QUEST�O: Explica��o com implementa��o
	public int[] quickSort(int[] umVetor, int _inic, int _tam) { 
		
		// C�pia os valores de "_in�cio" e "_fim"
		int inicio = _inic; 
		int tamanho = _tam; 		
		
		// Verifica se "inicio" (apontador para o in�cio) � maior ou igual ao
		// "_tam" (tamanho), se for igual s� tem
		// um elemento, ent�o retorna o vetor recebido como parametro. Se for
		// maior, existe algum erro, ent�o retorna o mesmo vetor
		// de entrada.
		if (inicio >= _tam)
			return umVetor;	
		
		
		// DIVIS�O: Coloca na vari�vel "meio" o elemento que est� no meio do
		// vetor de entrada. 
		int meio = umVetor[(inicio + tamanho) / 2];		
		
		
		//Desloca os ponteiros afim de achar a posi��o correta do piv�  
		while (inicio < tamanho) {
			
			// desloca o ponteiro da esquerda para a direita procurando um elemento que seja maior 
			while (inicio < tamanho && umVetor[inicio] < meio) { 
				inicio++; 
			}
			// desloca o ponteiro da direita para a esquerda procurando um elemento que seja menor
			while (inicio < tamanho && umVetor[tamanho] > meio) { 
				tamanho--; 
			}			
			
			//CONQUISTA: Se for verdadeiro, troca as posi��es entre os ponteiros do in�cio e fim. 
			if (inicio < tamanho) {
				int aux = umVetor[inicio];
				umVetor[inicio] = umVetor[tamanho];
				umVetor[tamanho] = aux;
			}			
		}		
		
		 


		// CONQUISTA: Caso seja verdadeiro, significa que os ponteiros se cruzaram, ent�o,
		// coloca o piv� na posi��o correta 
		if (tamanho < inicio) {
			int aux = tamanho;
			tamanho = inicio;
			inicio = aux;
		}
		
		// Chamada recursiva para o vetor ao lado direito do piv�
		quickSort(umVetor, _inic, inicio);
		
		if(inicio == _inic)
			inicio++;
		
		// Chamada recursiva para o vetor ao lado esquerdo do piv�
		quickSort(umVetor,inicio, _tam);		
		
		//COMBINA��O: Ap�s todas as chamadas recursivas, combina todos
 		//os elementos ordenados e retorna um �nico arranjo.
		return umVetor;		
	  }	
	
	// Procura dentro de um vetor o menor elemento.
	// Faz uma chamada � fun��o getMin(int v1, int v2) que retorna o menor elemento entre v1 e v2. 
	public int menorElemento(int [] umVetor, int inicio, int fim){		
		
		int meio;	
		
		// BASE: Verifica se o "apontador" do fim menor o do in�cio
		// � menor do que 1 (um), caso seja verdade, chama a fun��o
		// getMin(int v1, int v2) e retorna o resultado logo ap�s.
		if ((fim - inicio) <= 1)
			return menor(umVetor[inicio], umVetor[fim]);		
		
		else {			

			// DIVIS�O: A vari�vel "meio" est� sendo utilizada para aplicar
			// o conceito de divis�o, ou seja, ela � respons�vel
			// por indicar o meio de um vetor.
			meio = ((fim+inicio) / 2);			

			// valor1 recebe a primeira parte do arranjo j� dividido, ou seja
			// apontadores para o in�cio e o meio (que se torna o fim ap�s
			// a divis�o).
			int valor1 = menorElemento(umVetor, inicio, meio);			
		
			// valor2 recebe a segunda parte do arranjo dividido, ou seja
			// apontadores para o (meio + 1) e o fim (o meio se torna
			// o in�cio).
			int valor2 = menorElemento(umVetor, meio+1, fim);			
			
			// CONQUISTA: Retorna o menor entre os valores obtidos nas
			// divis�es.
			return menor(valor1, valor2);
		}				
	}	
	
	//Retorna o menor entre dois n�meros inteiros
	public int menor(int _n1, int _n2){		
		if (_n1 > _n2)
			return _n2;
		else
			return _n1;		
	}
	
	//Imprime um vetor de inteiros
	public void toString(int [] v){
		
		
		String aux = "";
		for(int i = 0; i < v.length;i++){
			aux += "["+v[i]+"]"+" ";
		}
		System.out.println("Vetor = "+aux);
		
//		System.out.print("Vetor = [");
//		for (int i = 0; i < v.length; i++) {
//			System.out.print(v[i]);
//			if ((i + 1) < v.length)
//				System.out.print(", ");
//			
//		}
//		System.out.println("]");		
	}
}
