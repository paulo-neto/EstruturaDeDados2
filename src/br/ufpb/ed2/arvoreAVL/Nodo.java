package br.ufpb.ed2.arvoreAVL;

public class Nodo {
	private Nodo filhoEsquerda;
	private Nodo filhoDireita;
	private int info,altura;
	
	public Nodo(Nodo esq,int info,Nodo dir){
		this.filhoEsquerda = esq;
		this.filhoDireita = dir;
		this.info = info;
		this.altura = 0;
	}
	public Nodo(int info){
		this(null,info,null);
	}
	public Nodo getFilhoEsquerda() {
		return filhoEsquerda;
	}
	public void setFilhoEsquerda(Nodo filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
	public Nodo getFilhoDireita() {
		return filhoDireita;
	}
	public void setFilhoDireita(Nodo filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
}
