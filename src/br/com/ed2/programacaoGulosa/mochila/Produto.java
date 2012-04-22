package br.com.ed2.programacaoGulosa.mochila;
public class Produto {
 double peso;
 double valor;
 double quant;
 
 public Produto(int umPeso, int umValor){
	 this.peso = umPeso;
	 this.valor = umValor;
 }

public double getPeso() {
	return peso;
}

public void setPeso(double peso) {
	this.peso = peso;
}

public double getValor() {
	return valor;
}

public void setValor(double valor) {
	this.valor = valor;
}

public double getQuant() {
	return quant;
}

public void setQuant(double quant) {
	this.quant = quant;
}
 
 
 
}
