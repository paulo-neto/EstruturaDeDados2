/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 * Classe repons�vel por gerar a exce��o gerada por uma opera��o em �rvore vazia.
 * Sendo extendida da da classe Exception
 * 
 * @author Euler Guimar�es Lobo
 */
public class ExcecaoArvoreVazia extends Exception {
    public ExcecaoArvoreVazia(String mensg){
		super(mensg);
	}
}