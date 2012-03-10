/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 * TAD �rvore AVL: Uma estrutura de dados do tipo �rvore bin�ria de busca
 * balancedada, com opera��es de inser��o e remo��o que preservam a propriedade
 * de balanceamento.
 * 
 * @author Daniel Ventura
 * @see ExcecaoArvoreVazia
 */

public interface TreeAVL{
   
    /**
     * @return true se � uma �rvore vazia, false caso contr�rio.
     */
    public boolean testeVazio();
    
    /**
     * L� o valor que esta na raiz da �rvore.
     * 
     * @return o valor na raiz da �rvore
     * @exception ExcecaoArvoreVazia
     */
    public Comparable consultaRaiz() throws ExcecaoArvoreVazia;
    
    /**
     * Busca o n� com o valor passado como par�metro, retornando a refer�ncia
     * da primeira ocorr�ncia do valor e null caso n�o ocorra na �rvore.
     */
    public noAVL buscaBinaria(Comparable valor);
    
    /**
     * Insere um n� com o valor passado como par�metro, mantendo a estrura
     * ordenada.
     */
    public noAVL insereNo(Comparable v);
    
    /**
     * Remove o n� passado como par�metro, mantendo a estrutura ordenada.
     * Retorna o pai do n� removido, com o fator de balanceamento j� atualizado.
     */
    public noAVL removeNo(noAVL q);
    
    /**
     * Insere um n� com o valor v passado como par�metro, mantendo a estrutura
     * ordenada e balanceada.
     */
    public void insereAVL(Comparable v);
    
    /**
     * Remove o n� passado como par�metro, mantendo a estrutura ordenada e
     * balanceada.
     */
    public void removeAVL(noAVL q);
    
    /**
     * Uma string com a representa��o do caminhamento prefixado na �rvore, onde
     * cada n� � representado pelo seu valor e respectivo fator de balancemanto.
     */
    public String caminhoPrefixado();
    
    /**
     * Uma string com a representa��o do caminhamento central na �rvore.
     */
    public String caminhoCentral();
    
    /**
     * Uma string com a representa��o do caminhamento posfixado na �rvore.
     */
    public String caminhoPosfixado();
    
    /* Observa��o: Os m�todos para opera��o de rota��o e atualiza��o do fator de
     * balancemanto n�o constam na interface porque devem ser definidos como
     * m�todos privados. 
     */
}