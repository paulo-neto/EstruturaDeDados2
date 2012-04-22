package br.com.ed2.programacaoDinamica;

public class Quick_Sort {
	int [] vet;
	
	public Quick_Sort(){
		vet = new int [10]; 	
	}	
	 //Verifica se existe um valor em um vetor de inteiros. Para isto o vetor de entrada deve estar ordenado.
	public boolean contem(int[] umVetor, int inicio, int fim, int valor) {

		//DIVISÃO: Coloca na variável "meio" a divisão entre as extremidades do vetor a cada chamada recursiva ao mesmo.
		int meio = (fim + inicio) / 2;		
		
		
		// BASE: Verifica se o elemento do meio contém o valor que se está procurando.
		if (umVetor[meio] == valor)
			return true;		
		
		//	CONQUISTA: Verifica se o valor procurado está a direita ou esquerda do vetor, ou seja, se o valor do 
		//  meio for maior do que o procurado, então, chama recursivo do início até o (meio - 1), caso contrário, chama 	
		//  recursivo para o (meio + 1) até o fim.
		if (umVetor[meio] > valor && (meio - 1) >= inicio)
			return contem(umVetor, inicio, meio - 1, valor); /* vetor a esquerda*/
		else
			if (umVetor[meio] < valor && (meio + 1) <= fim)
				return contem(umVetor, meio + 1, fim, valor); /* vetor a direita*/	
		
		//Se chegar ao fim e nao encontrar o valor, retorna "false".
		return false;
	}
		 	 

	// O procedimento de divisão e conquista do Algoritmo de Ordenação
	// Quick-Sort consiste em colocar os valores em suas posições corretas.
	// Assim, após colocar o chamado elemento "pivô" em sua posição correta,
	// todos os elementos que estiverem a sua esquerda
	// formarão um sub-vetor, como também os que estiverem ao lado direito desse
	// pivô. Sendo assim, cada um desses
	// sub-vetores serão passados recursivamente para a função para que tenham o
	// pivô de cada um colocado na sua posição
	// correta. Após o fim da função, todos os elementos estarão ordenados.	 
	
	//2ª QUESTÃO: Explicação com implementação
	public int[] quickSort(int[] umVetor, int _inic, int _tam) { 
		
		// Cópia os valores de "_início" e "_fim"
		int inicio = _inic; 
		int tamanho = _tam; 		
		
		// Verifica se "inicio" (apontador para o início) é maior ou igual ao
		// "_tam" (tamanho), se for igual só tem
		// um elemento, então retorna o vetor recebido como parametro. Se for
		// maior, existe algum erro, então retorna o mesmo vetor
		// de entrada.
		if (inicio >= _tam)
			return umVetor;	
		
		
		// DIVISÃO: Coloca na variável "meio" o elemento que está no meio do
		// vetor de entrada. 
		int meio = umVetor[(inicio + tamanho) / 2];		
		
		
		//Desloca os ponteiros afim de achar a posição correta do pivô  
		while (inicio < tamanho) {
			
			// desloca o ponteiro da esquerda para a direita procurando um elemento que seja maior 
			while (inicio < tamanho && umVetor[inicio] < meio) { 
				inicio++; 
			}
			// desloca o ponteiro da direita para a esquerda procurando um elemento que seja menor
			while (inicio < tamanho && umVetor[tamanho] > meio) { 
				tamanho--; 
			}			
			
			//CONQUISTA: Se for verdadeiro, troca as posições entre os ponteiros do início e fim. 
			if (inicio < tamanho) {
				int aux = umVetor[inicio];
				umVetor[inicio] = umVetor[tamanho];
				umVetor[tamanho] = aux;
			}			
		}		
		
		 


		// CONQUISTA: Caso seja verdadeiro, significa que os ponteiros se cruzaram, então,
		// coloca o pivô na posição correta 
		if (tamanho < inicio) {
			int aux = tamanho;
			tamanho = inicio;
			inicio = aux;
		}
		
		// Chamada recursiva para o vetor ao lado direito do pivô
		quickSort(umVetor, _inic, inicio);
		
		if(inicio == _inic)
			inicio++;
		
		// Chamada recursiva para o vetor ao lado esquerdo do pivô
		quickSort(umVetor,inicio, _tam);		
		
		//COMBINAÇÃO: Após todas as chamadas recursivas, combina todos
 		//os elementos ordenados e retorna um único arranjo.
		return umVetor;		
	  }	
	
	// Procura dentro de um vetor o menor elemento.
	// Faz uma chamada à função getMin(int v1, int v2) que retorna o menor elemento entre v1 e v2. 
	public int menorElemento(int [] umVetor, int inicio, int fim){		
		
		int meio;	
		
		// BASE: Verifica se o "apontador" do fim menor o do início
		// é menor do que 1 (um), caso seja verdade, chama a função
		// getMin(int v1, int v2) e retorna o resultado logo após.
		if ((fim - inicio) <= 1)
			return menor(umVetor[inicio], umVetor[fim]);		
		
		else {			

			// DIVISÃO: A variável "meio" está sendo utilizada para aplicar
			// o conceito de divisão, ou seja, ela é responsável
			// por indicar o meio de um vetor.
			meio = ((fim+inicio) / 2);			

			// valor1 recebe a primeira parte do arranjo já dividido, ou seja
			// apontadores para o início e o meio (que se torna o fim após
			// a divisão).
			int valor1 = menorElemento(umVetor, inicio, meio);			
		
			// valor2 recebe a segunda parte do arranjo dividido, ou seja
			// apontadores para o (meio + 1) e o fim (o meio se torna
			// o início).
			int valor2 = menorElemento(umVetor, meio+1, fim);			
			
			// CONQUISTA: Retorna o menor entre os valores obtidos nas
			// divisões.
			return menor(valor1, valor2);
		}				
	}	
	
	//Retorna o menor entre dois números inteiros
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
