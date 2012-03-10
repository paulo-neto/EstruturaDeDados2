/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;


import java.util.Stack;

/**
 * Implementação da interface ArvoreAVL
 *
 * @author Euler Guimarães Lobo
 */
public class ArvoreAVL implements TreeAVL{

    private noAVL raiz = new noAVL();//raiz da árvoreAVL
    private noAVL op1 = raiz;//nó utilizado para operações temporárias
    private noAVL op2 = raiz;//nó utilizado para operações temporárias
        
    @Override
    /**
     * @return true se é uma árvore vazia, false caso contrario
     */
    public boolean testeVazio() {
        
        Comparable teste = raiz.getValor();
        if (teste == null){
            return true;
        } else {
            return false;
        }//Fim do laço if
    }//Fim do método implementado testeVazio, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Lê o valor que esta na raiz da árvore.
     * 
     * @return o valor na raiz da árvore
     * @exception ExcecaoArvoreVazia
     */
    public Comparable consultaRaiz() throws ExcecaoArvoreVazia {
        return raiz.getValor();
    }//Fim do método implementado consultaRaiz, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Busca o nó com o valor passado como parâmetro, retornando a referência da
     * primeira ocorrência do valor e null caso não ocorra na árvore.
     * 
     * @return nó com a primeira referência do valor ou null caso contrário
     */
    public noAVL buscaBinaria(Comparable valor) {
        
        noAVL q = null;//nó de retorno
        
        if(!testeVazio()){
            
            Comparable valorRaiz = op1.getValor();
            if(valorRaiz.compareTo(valor) < 0){
                op1 = op1.getFilhoE();
                q = buscaBinaria(valor);
                op1 = raiz;//retornando op1 ao estágio inicial (cópia de raiz)
            }//Fim do laço if
            if(valorRaiz.compareTo(valor) > 0){
                op1 = op1.getFilhoD();
                q = buscaBinaria(valor);
                op1 = raiz;//retornando op1 ao estágio inicial (cópia de raiz)
            }//Fim do laço if
        }//Fim do laço if
        
        return q;
        /*
         * Explicação sobre op1: inicialmente op1 é raiz, sendo que a cada
         * nova chamada do método de buscaBinaria, op1 vai se tornando o nó
         * descendente esquerdo ou direito até a busca do valor pretendido.
         * Sendo que posteriomente op1 volta a ser a raiz da árvore (para
         * utilização nos outros métodos).
         */
    }//Fim do método implementado buscaBinaria, provindo de Interfaces.ArvroreAVL

    @Override
    /**
     * Insere um nó passado como parâmetro, mantendo a estrutura ordenada.
     * O método não aceita a entrada de valores repetidos.
     * 
     * @return retorna o nó inserido na árvore ou null caso o nó já exista
     */
    public noAVL insereNo(Comparable v) {
        
        noAVL q = null;
        
        if(buscaBinaria(v) == null){
                
            if(testeVazio()){
                raiz.setValor(v);
            }//Fim do laço if
                
            try{
            
                if(v.compareTo(op1.getValor()) < 0){
                    op2 = op1;//op2 é o pai do novo op1
                    op1 = op1.getFilhoE();//novo op1 (subárvore esquerda do nó em questão)
                    q = insereNo(v);
                }else{
                    op2 = op1;//op2 é o pai do novo op1
                    op1 = op1.getFilhoD();//novo op1 (subárvore direita do nó em questão)
                    q = insereNo(v);
                }//Fim do laço if            
            }catch(NullPointerException ex){
            
                if(v.compareTo(op2.getValor()) < 0){
                
                    op2.setFilhoE(new noAVL(v,null,null,op2,0));//Criando novo nó a esquerda
                    q = op2.getFilhoE();
                    fatorB();//ajustando fator de balanceamento
                    op1 = raiz;//retornando op1 ao estágio inicial (cópia de raiz)
                    op2 = raiz;//retornando op2 ao estágio inicial (cópia de raiz)
                }else{
                
                    op2.setFilhoD(new noAVL(v,null,null,op2,0));//Criando novo nó a direita
                    q = op2.getFilhoD();
                    fatorB();//ajustando fator de balanceamento
                    op1 = raiz;//retornando op1 ao estágio inicial (cópia de raiz)
                    op2 = raiz;//retornando op2 ao estágio inicial (cópia de raiz)
                }//Fim do laço if
            }//Fim do laço try-catch        
        }//Fim do laço if
        
        return q;
        /*
         * Explicação sobre funcionamento: o testeVazio() da subárvore que é 
         * trabalhada no código é feito através da busca pela exceção que ocorre
         * em Comparable quando o valor é comparado com null, sendo a exceção
         * o NullPointerException.
         * 
         * No momento que op1 vira null, o método é chamando recursivamente e a 
         * exceção é gerada, com a exceção gerada significa que op2 esta em uma
         * folha da árvore, assim é feito a comparação dentro do tratamento da
         * exceção para determinar se o novo nó ficará do lado esquerdo ou
         * direito da folha em op2.
         */
    }//Fim do método implementado insereNo, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Remove o nó passado como parâmetro, mantendo a estrutura ordenada. Retorna
     * o pai do nó removido, com o fator de balanceamento já atualizado.
     * 
     * @return o pai do nó removido, com o fator de balanceamento atualizado ou o 
     * próprio nó passado como parâmetro caso não esteja presente na árvore
     */
    public noAVL removeNo(noAVL q) {
        
        noAVL p = buscaBinaria(q.getValor());
        
        if(p != null){
            
            noAVL d = p.getPai();
            
            if(d == null){
                //q é a raiz da árvore
                raiz = p.getFilhoD();
            }else{
                
                if((d.getFilhoE()).equals(q)){
                    
                    d.setFilhoE(p.getFilhoD());
                    fatorB();//ajustando o fator de balanceamento
                }else{
                    
                    d.setFilhoD(p.getFilhoE());
                    fatorB();//ajustando o fator de balanceamento
                }//Fim do laço if
            }//Fim do laço if
            p = d;
        }else{
            p = q;
        }//Fim do laço if
        
        return p;
    }//Fim do método implementado removeNo, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Insere um nó com o valor v passado como parâmetro, mantendo a estrutura
     * ordenada e balanceada. Porém nada é feito caso o valor passado como
     * parâmetro caso já exista na árvore.
     */
    public void insereAVL(Comparable v) {
        
        noAVL q = insereNo(v);
        
        if(q != null){
            
            if((q.getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(q);
                }else{
                    
                    q = rotacaoDuplaD(q);
                }//Fim do laço if
            }//Fim do laço if
            /*
             * Devido a forma como é feito a inserção e remoção de um nó em meu
             * código é possível que um nó pai de um nó pai (nó avó), tenha fator
             * de balanceamento acima do permitido em uma árvore AVL, sendo
             * necessário esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(q);
                }else{
                    
                    q = rotacaoDuplaD(q);
                }//Fim do laço if
                
            }//Fim do laço if
            if((q.getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(q);
                }else{
                    
                    q = rotacaoDuplaE(q);
                }//Fim do laço if
            }//Fim do laço if
            /*
             * Devido a forma como é feito a inserção e remoção de um nó em meu
             * código é possível que um nó pai de um nó pai (nó avó), tenha fator
             * de balanceamento acima do permitido em uma árvore AVL, sendo
             * necessário esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(q);
                }else{
                    
                    q = rotacaoDuplaE(q);
                }//Fim do laço if
            }//Fim do laço if//Fim do laço if
        }//Fim do laço if
    }//Fim do método implementado insereAVL, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Remove o nó passado como parâmetro, mantendo a estrutura ordenada e
     * balanceada. Não fazendo nada caso o nó passado como parâmetro não
     * exista na árvore.
     */
    public void removeAVL(noAVL q) {
        
        noAVL p = removeNo(q);
        
        if(!(p.equals(q))){
            
            if((q.getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(p);
                }else{
                    
                    q = rotacaoDuplaD(p);
                }//Fim do laço if
            }//Fim do laço if
            /*
             * Devido a forma como é feito a inserção e remoção de um nó em meu
             * código é possível que um nó pai de um nó pai (nó avó), tenha fator
             * de balanceamento acima do permitido em uma árvore AVL, sendo
             * necessário esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(p);
                }else{
                    
                    q = rotacaoDuplaD(p);
                }//Fim do laço if
                
            }//Fim do laço if
            if((q.getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(p);
                }else{
                    
                    q = rotacaoDuplaE(p);
                }//Fim do laço if
            }//Fim do laço if
            /*
             * Devido a forma como é feito a inserção e remoção de um nó em meu
             * código é possível que um nó pai de um nó pai (nó avó), tenha fator
             * de balanceamento acima do permitido em uma árvore AVL, sendo
             * necessário esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(p);
                }else{
                    
                    q = rotacaoDuplaE(p);
                }//Fim do laço if
            }//Fim do laço if
        }//Fim do laço if
    }//Fim do método implementado removeAVL, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Uma string com a representação do caminho prefixado na árvore, onde cada
     * nó é representado com o seu valor e o respectivo fator de balanceamento.
     * 
     * @return string representando cada nó com o seu valor e o seu respectivo fator de balanceamento no caminho prefixado
     */
    public String caminhoPrefixado() {
        
        Stack pilha = new Stack();//Pilha para caminhamento nos nós
        String caminho = null;//String para representação do caminho
        
        pilha.push(raiz);
        while(!pilha.empty()){
            
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                caminho = caminho + "(" + q.getValor() + "," + q.getFatorB() + "); ";
                pilha.push(q.getFilhoD());
                pilha.push(q.getFilhoE());
            }//Fim do laço if
        }//Fim do laço while
        return caminho;
    }//Fim do método implementado caminhoPrefixado, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Uma string com a representação do caminho central da árvore.
     * 
     * @return string representando cada nó com o seu valor e o seu respectivo fator de balanceamento no caminho central
     */
    public String caminhoCentral() {
        
        Stack pilha = new Stack();//Pilha para caminhamento nos nós
        String caminho = null;//String para representação do caminho
        
        while(!(op1.getFilhoE() == null)){
            op1 = op1.getFilhoE();            
        }//Fim do laço while
        pilha.push(op1);
        
        while(!pilha.empty()){
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                caminho = caminho + "(" + q.getValor() + "," + q.getFatorB() + "); ";
                pilha.push((q.getPai()).getFilhoD());
                pilha.push(q.getPai());
            }//Fim do laço if
        }//Fim do laço while
        op1 = raiz;//retornando op ao estágio inicial (cópia de raiz)
        return caminho;
    }//Fim do método implementado caminhoCentral, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Uma string com o caminho posfixado na árvore.
     * 
     * @return string representando cada nó com o seu valor e o seu respectivo fator de balanceamento no caminho posfixado
     */
    public String caminhoPosfixado() {
        
        Stack pilha = new Stack();//Pilha para caminhamento nos nós
        String caminho = null;//String para representação do caminho
        
        pilha.push(op1);//empilhando a raiz da árvore
        while(!(op1.getFilhoE() == null)){
            op1 = op1.getFilhoE();            
        }//Fim do laço while
        pilha.push(op1);
        
        while(!pilha.empty()){
            
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                caminho = caminho + "(" + q.getValor() + "," + q.getFatorB() + "); ";
                pilha.push(q.getPai());
                pilha.push((q.getPai()).getFilhoD());
            }//Fim do laço while
        }//Fim do laço while
        op1 = raiz;//retornando op ao estágio inicial (cópia de raiz)
        return caminho;
    }//Fim do método implementado caminhoPosfixado, provindo de Interfaces.ArvoreAVL
    
    private noAVL rotacaoEsquerda(noAVL B){
        
        noAVL u = B.getFilhoD();
        
        B.setFilhoD(u.getFilhoE());
        u.setFilhoE(B);
        u.setFatorB(0);
        B.setFatorB(0);
        return u;
    }
    
    private noAVL rotacaoDireita(noAVL B){
        
        noAVL u = B.getFilhoE();
        
        B.setFilhoE(u.getFilhoD());
        u.setFilhoD(B);
        u.setFatorB(0);
        B.setFatorB(0);
        return u;
    }
    
    private noAVL rotacaoDuplaE(noAVL B){
        
        noAVL z = B.getFilhoD();
        noAVL y = B.getFilhoE();
        
        B.setFilhoD(y.getFilhoE());
        z.setFilhoE(y.getFilhoD());
        y.setFilhoE(B);
        y.setFilhoD(z);
        
        if(y.getFatorB() == 0){
            
            B.setFatorB(0);
            z.setFatorB(0);
        }else{
            
            if(y.getFatorB() > 0){
                
                B.setFatorB(0);
                z.setFatorB(-1);
            }else{
                
                B.setFatorB(1);
                z.setFatorB(0);
            }//Fim do else
            y.setFatorB(0);
        }//Fim do else
        
        return y;
    }
    
    private noAVL rotacaoDuplaD(noAVL B){
        
        noAVL z = B.getFilhoE();
        noAVL y = z.getFilhoD();
        
        B.setFilhoE(y.getFilhoD());
        z.setFilhoD(y.getFilhoE());
        y.setFilhoD(B);
        y.setFilhoE(z);
        
        if(y.getFatorB() == 0){
            
            z.setFatorB(0);
            B.setFatorB(0);
        }else{
            
            if(y.getFatorB() > 0 ){
                
                z.setFatorB(0);
                B.setFatorB(-1);
            }else{
                
                z.setFatorB(1);
                B.setFatorB(0);
            }//Fim do laço if
            y.setFatorB(0);
        }//Fim do laço if
        
        return y;
    }
    
    private void fatorB(){
        //reajuste de fator através de caminho posfixado
        
        Stack pilha = new Stack();//Pilha para caminhamento nos nós
                
        pilha.push(op1);//empilhando a raiz da árvore
        while(!(op1.getFilhoE() == null)){
            op1 = op1.getFilhoE();            
        }//Fim do laço while
        pilha.push(op1);
        
        while(!pilha.empty()){
            
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                
                if(q.getFilhoE() == null){
                    
                    if(q.getFilhoD() == null){
                        
                        q.setFatorB(0);
                    }else{
                        
                        q.setFatorB((q.getFilhoD()).getFatorB() - 1);
                    }//Fim do laço if
                }else{
                    
                    if(q.getFilhoD() == null){
                        
                        q.setFatorB((q.getFilhoE()).getFatorB() + 1);
                    }else{
                        
                        q.setFatorB((q.getFilhoE()).getFatorB() - (q.getFilhoD()).getFatorB());
                    }//Fim do laço if
                }//Fim do laço if
                pilha.push(q.getPai());
                pilha.push((q.getPai()).getFilhoD());
            }//Fim do laço while
        }//Fim do laço while
        op1 = raiz;//retornando op ao estágio inicial (cópia de raiz)
        /*
         * Explicação sobre o funcionamento: o cálculo do fator de balancemanento
         * é feito através de um caminho posfixado realizado na árvore, que
         * reajusta o fator de balanceamento de acordo com o fator de balanceamento
         * dos nós descendentes, se o nó de fato tiver descendentes.
         */
    }
    
}//Fim da classe ArvoreAVL