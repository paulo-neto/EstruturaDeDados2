package br.com.prova2.questao02;

public class Main {
	public static void main(String[] args) {

		LinhaDeProducao l_Producao = new LinhaDeProducao();
		l_Producao.leArquivo("tempos.txt");
		l_Producao.menorTempoDeProducao();
	}

}
