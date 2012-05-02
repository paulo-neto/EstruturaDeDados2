package br.com.ed2.programacaoGulosa.mochila;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Mochila {
	double capacidade;
	int numProdutos;
	ArrayList<Produto> listaProdutosPeso;
	ArrayList<Produto> listaProdutosValor;
	ArrayList<Produto> listaProdutosRazao;
	Produto produtos[];
	
	public Mochila(File arquivo) throws FileNotFoundException{
		Scanner leitor = new Scanner(arquivo);
		this.numProdutos = leitor.nextInt();
		this.capacidade = leitor.nextInt();
		listaProdutosValor = new ArrayList<Produto>();
		listaProdutosPeso = new ArrayList<Produto>();
		listaProdutosRazao = new ArrayList<Produto>();
		
		for(int i = 0; i < numProdutos; i++){
			Produto umProduto = new Produto(leitor.nextInt(),leitor.nextInt());
			listaProdutosValor.add(umProduto);
			Collections.sort(listaProdutosValor,new ComparaProdutoValor());
			listaProdutosPeso.add(umProduto);
			Collections.sort(listaProdutosPeso, new ComparaProdutoPeso());
			listaProdutosRazao.add(umProduto);
			Collections.sort(listaProdutosRazao,new ComparaProdutoRazao());
		}
	}
	
	public double produtoMaisLeve() {
		double lucro = 0;
		ArrayList<Produto> aux = new ArrayList<Produto>();
		for (Produto p : this.listaProdutosPeso) {
			if (p.getPeso() < capacidade) {
				aux.add(p);
				this.capacidade = this.capacidade - p.getPeso();
				lucro += p.getValor();
			}else{
				lucro += (capacidade/p.getPeso())*p.getValor();
				capacidade=0;
			}
			if(capacidade == 0)break;
		}
		return lucro;
	}

	public double produtoMaisCaro() {
		double lucro = 0;
		ArrayList<Produto> aux = new ArrayList<Produto>();
		for (Produto p : this.listaProdutosValor) {
			if (p.getPeso() < capacidade) {
				aux.add(p);
				this.capacidade = this.capacidade - p.getPeso();
				lucro += p.getValor();
			}else {
				lucro += (capacidade/p.getPeso())*p.getValor();
				capacidade = 0;
			}if(capacidade == 0) break; 
		}
		return lucro;
	}

	public double razao() {
		double lucro = 0;
		ArrayList<Produto> aux = new ArrayList<Produto>();
		for(Produto p : this.listaProdutosRazao){
			if(p.getPeso() < capacidade){
				aux.add(p);
				this.capacidade = this.capacidade-p.getPeso();
				lucro += p.getValor();
			}else{
				lucro += (capacidade/p.getPeso())*p.getValor();
				capacidade = 0;
			}if(capacidade == 0)break;
		}
		return lucro;
	}	
}
