package br.com.ed2.programacaoGulosa.mochila;
public class Produto {
 double peso;
 double valor;
 double quant;
 double razao;
 
 public Produto(int umValor, int umPeso){
	 this.peso = umPeso;
	 this.valor = umValor;
	 this.razao = this.valor/this.peso;
 }
 
 public Produto(){}

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

public double getRazao() {
	return razao;
}

public void setRazao(double razao) {
	this.razao = razao;
}

 
 
 
}
