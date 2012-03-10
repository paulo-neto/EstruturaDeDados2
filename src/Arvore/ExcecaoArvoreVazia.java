/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 * Classe reponsável por gerar a exceção gerada por uma operação em árvore vazia.
 * Sendo extendida da da classe Exception
 * 
 * @author Euler Guimarães Lobo
 */
public class ExcecaoArvoreVazia extends Exception {
    public ExcecaoArvoreVazia(String mensg){
		super(mensg);
	}
}