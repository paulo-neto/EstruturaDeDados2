/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 * Define o nó da árvore
 *
 * @author Euler Guimarães Lobo
 */
public class noAVL {
    
    private Comparable valor; //valor do nó.
    private noAVL filhoE; //filho a esquerda.
    private noAVL filhoD; //filho a direita.
    private noAVL pai; //pai do nó.
    private int fatorB; //fator de balanceamento.
    
    public noAVL(){
        valor = null;
        filhoE = filhoD = pai = null;
        fatorB = 0;
    }//Fim do construtor vazio
    
    public noAVL(Comparable valor, noAVL filhoE, noAVL filhoD, noAVL pai, int fatorB){
        this.valor = valor;
        this.filhoE = filhoE;
        this.filhoD = filhoD;
        this.pai = pai;
        this.fatorB = fatorB;
    }//Fim do construto
    
    public void setValor(Comparable valor){
        this.valor = valor;
    }
    
    public void setFilhoE(noAVL filhoE){
        this.filhoE = filhoE;
    }
    
    public void setFilhoD(noAVL filhoD){
        this.filhoD = filhoD;
    }
    
    public void setPai(noAVL pai){
        this.pai = pai;
    }
    
    public void setFatorB(int fatorB){
        this.fatorB = fatorB;
    }
    
    public Comparable getValor(){
        return valor;
    }
    
    public noAVL getFilhoE(){
        return filhoE;
    }
    
    public noAVL getFilhoD(){
        return filhoD;
    }
    
    public noAVL getPai(){
        return pai;
    }
    
    public int getFatorB(){
        return fatorB;
    }
}//Fim da classe noAVL