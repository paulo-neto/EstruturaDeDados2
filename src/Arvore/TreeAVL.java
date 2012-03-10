/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;

/**
 * TAD Árvore AVL: Uma estrutura de dados do tipo árvore binária de busca
 * balancedada, com operações de inserção e remoção que preservam a propriedade
 * de balanceamento.
 * 
 * @author Daniel Ventura
 * @see ExcecaoArvoreVazia
 */

public interface TreeAVL{
   
    /**
     * @return true se é uma árvore vazia, false caso contrário.
     */
    public boolean testeVazio();
    
    /**
     * Lê o valor que esta na raiz da árvore.
     * 
     * @return o valor na raiz da árvore
     * @exception ExcecaoArvoreVazia
     */
    public Comparable consultaRaiz() throws ExcecaoArvoreVazia;
    
    /**
     * Busca o nó com o valor passado como parâmetro, retornando a referência
     * da primeira ocorrência do valor e null caso não ocorra na árvore.
     */
    public noAVL buscaBinaria(Comparable valor);
    
    /**
     * Insere um nó com o valor passado como parâmetro, mantendo a estrura
     * ordenada.
     */
    public noAVL insereNo(Comparable v);
    
    /**
     * Remove o nó passado como parâmetro, mantendo a estrutura ordenada.
     * Retorna o pai do nó removido, com o fator de balanceamento já atualizado.
     */
    public noAVL removeNo(noAVL q);
    
    /**
     * Insere um nó com o valor v passado como parâmetro, mantendo a estrutura
     * ordenada e balanceada.
     */
    public void insereAVL(Comparable v);
    
    /**
     * Remove o nó passado como parâmetro, mantendo a estrutura ordenada e
     * balanceada.
     */
    public void removeAVL(noAVL q);
    
    /**
     * Uma string com a representação do caminhamento prefixado na árvore, onde
     * cada nó é representado pelo seu valor e respectivo fator de balancemanto.
     */
    public String caminhoPrefixado();
    
    /**
     * Uma string com a representação do caminhamento central na árvore.
     */
    public String caminhoCentral();
    
    /**
     * Uma string com a representação do caminhamento posfixado na árvore.
     */
    public String caminhoPosfixado();
    
    /* Observação: Os métodos para operação de rotação e atualização do fator de
     * balancemanto não constam na interface porque devem ser definidos como
     * métodos privados. 
     */
}