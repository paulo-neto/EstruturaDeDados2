/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Arvore;


import java.util.Stack;

/**
 * Implementa��o da interface ArvoreAVL
 *
 * @author Euler Guimar�es Lobo
 */
public class ArvoreAVL implements TreeAVL{

    private noAVL raiz = new noAVL();//raiz da �rvoreAVL
    private noAVL op1 = raiz;//n� utilizado para opera��es tempor�rias
    private noAVL op2 = raiz;//n� utilizado para opera��es tempor�rias
        
    @Override
    /**
     * @return true se � uma �rvore vazia, false caso contrario
     */
    public boolean testeVazio() {
        
        Comparable teste = raiz.getValor();
        if (teste == null){
            return true;
        } else {
            return false;
        }//Fim do la�o if
    }//Fim do m�todo implementado testeVazio, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * L� o valor que esta na raiz da �rvore.
     * 
     * @return o valor na raiz da �rvore
     * @exception ExcecaoArvoreVazia
     */
    public Comparable consultaRaiz() throws ExcecaoArvoreVazia {
        return raiz.getValor();
    }//Fim do m�todo implementado consultaRaiz, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Busca o n� com o valor passado como par�metro, retornando a refer�ncia da
     * primeira ocorr�ncia do valor e null caso n�o ocorra na �rvore.
     * 
     * @return n� com a primeira refer�ncia do valor ou null caso contr�rio
     */
    public noAVL buscaBinaria(Comparable valor) {
        
        noAVL q = null;//n� de retorno
        
        if(!testeVazio()){
            
            Comparable valorRaiz = op1.getValor();
            if(valorRaiz.compareTo(valor) < 0){
                op1 = op1.getFilhoE();
                q = buscaBinaria(valor);
                op1 = raiz;//retornando op1 ao est�gio inicial (c�pia de raiz)
            }//Fim do la�o if
            if(valorRaiz.compareTo(valor) > 0){
                op1 = op1.getFilhoD();
                q = buscaBinaria(valor);
                op1 = raiz;//retornando op1 ao est�gio inicial (c�pia de raiz)
            }//Fim do la�o if
        }//Fim do la�o if
        
        return q;
        /*
         * Explica��o sobre op1: inicialmente op1 � raiz, sendo que a cada
         * nova chamada do m�todo de buscaBinaria, op1 vai se tornando o n�
         * descendente esquerdo ou direito at� a busca do valor pretendido.
         * Sendo que posteriomente op1 volta a ser a raiz da �rvore (para
         * utiliza��o nos outros m�todos).
         */
    }//Fim do m�todo implementado buscaBinaria, provindo de Interfaces.ArvroreAVL

    @Override
    /**
     * Insere um n� passado como par�metro, mantendo a estrutura ordenada.
     * O m�todo n�o aceita a entrada de valores repetidos.
     * 
     * @return retorna o n� inserido na �rvore ou null caso o n� j� exista
     */
    public noAVL insereNo(Comparable v) {
        
        noAVL q = null;
        
        if(buscaBinaria(v) == null){
                
            if(testeVazio()){
                raiz.setValor(v);
            }//Fim do la�o if
                
            try{
            
                if(v.compareTo(op1.getValor()) < 0){
                    op2 = op1;//op2 � o pai do novo op1
                    op1 = op1.getFilhoE();//novo op1 (sub�rvore esquerda do n� em quest�o)
                    q = insereNo(v);
                }else{
                    op2 = op1;//op2 � o pai do novo op1
                    op1 = op1.getFilhoD();//novo op1 (sub�rvore direita do n� em quest�o)
                    q = insereNo(v);
                }//Fim do la�o if            
            }catch(NullPointerException ex){
            
                if(v.compareTo(op2.getValor()) < 0){
                
                    op2.setFilhoE(new noAVL(v,null,null,op2,0));//Criando novo n� a esquerda
                    q = op2.getFilhoE();
                    fatorB();//ajustando fator de balanceamento
                    op1 = raiz;//retornando op1 ao est�gio inicial (c�pia de raiz)
                    op2 = raiz;//retornando op2 ao est�gio inicial (c�pia de raiz)
                }else{
                
                    op2.setFilhoD(new noAVL(v,null,null,op2,0));//Criando novo n� a direita
                    q = op2.getFilhoD();
                    fatorB();//ajustando fator de balanceamento
                    op1 = raiz;//retornando op1 ao est�gio inicial (c�pia de raiz)
                    op2 = raiz;//retornando op2 ao est�gio inicial (c�pia de raiz)
                }//Fim do la�o if
            }//Fim do la�o try-catch        
        }//Fim do la�o if
        
        return q;
        /*
         * Explica��o sobre funcionamento: o testeVazio() da sub�rvore que � 
         * trabalhada no c�digo � feito atrav�s da busca pela exce��o que ocorre
         * em Comparable quando o valor � comparado com null, sendo a exce��o
         * o NullPointerException.
         * 
         * No momento que op1 vira null, o m�todo � chamando recursivamente e a 
         * exce��o � gerada, com a exce��o gerada significa que op2 esta em uma
         * folha da �rvore, assim � feito a compara��o dentro do tratamento da
         * exce��o para determinar se o novo n� ficar� do lado esquerdo ou
         * direito da folha em op2.
         */
    }//Fim do m�todo implementado insereNo, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Remove o n� passado como par�metro, mantendo a estrutura ordenada. Retorna
     * o pai do n� removido, com o fator de balanceamento j� atualizado.
     * 
     * @return o pai do n� removido, com o fator de balanceamento atualizado ou o 
     * pr�prio n� passado como par�metro caso n�o esteja presente na �rvore
     */
    public noAVL removeNo(noAVL q) {
        
        noAVL p = buscaBinaria(q.getValor());
        
        if(p != null){
            
            noAVL d = p.getPai();
            
            if(d == null){
                //q � a raiz da �rvore
                raiz = p.getFilhoD();
            }else{
                
                if((d.getFilhoE()).equals(q)){
                    
                    d.setFilhoE(p.getFilhoD());
                    fatorB();//ajustando o fator de balanceamento
                }else{
                    
                    d.setFilhoD(p.getFilhoE());
                    fatorB();//ajustando o fator de balanceamento
                }//Fim do la�o if
            }//Fim do la�o if
            p = d;
        }else{
            p = q;
        }//Fim do la�o if
        
        return p;
    }//Fim do m�todo implementado removeNo, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Insere um n� com o valor v passado como par�metro, mantendo a estrutura
     * ordenada e balanceada. Por�m nada � feito caso o valor passado como
     * par�metro caso j� exista na �rvore.
     */
    public void insereAVL(Comparable v) {
        
        noAVL q = insereNo(v);
        
        if(q != null){
            
            if((q.getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(q);
                }else{
                    
                    q = rotacaoDuplaD(q);
                }//Fim do la�o if
            }//Fim do la�o if
            /*
             * Devido a forma como � feito a inser��o e remo��o de um n� em meu
             * c�digo � poss�vel que um n� pai de um n� pai (n� av�), tenha fator
             * de balanceamento acima do permitido em uma �rvore AVL, sendo
             * necess�rio esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(q);
                }else{
                    
                    q = rotacaoDuplaD(q);
                }//Fim do la�o if
                
            }//Fim do la�o if
            if((q.getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(q);
                }else{
                    
                    q = rotacaoDuplaE(q);
                }//Fim do la�o if
            }//Fim do la�o if
            /*
             * Devido a forma como � feito a inser��o e remo��o de um n� em meu
             * c�digo � poss�vel que um n� pai de um n� pai (n� av�), tenha fator
             * de balanceamento acima do permitido em uma �rvore AVL, sendo
             * necess�rio esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(q);
                }else{
                    
                    q = rotacaoDuplaE(q);
                }//Fim do la�o if
            }//Fim do la�o if//Fim do la�o if
        }//Fim do la�o if
    }//Fim do m�todo implementado insereAVL, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Remove o n� passado como par�metro, mantendo a estrutura ordenada e
     * balanceada. N�o fazendo nada caso o n� passado como par�metro n�o
     * exista na �rvore.
     */
    public void removeAVL(noAVL q) {
        
        noAVL p = removeNo(q);
        
        if(!(p.equals(q))){
            
            if((q.getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(p);
                }else{
                    
                    q = rotacaoDuplaD(p);
                }//Fim do la�o if
            }//Fim do la�o if
            /*
             * Devido a forma como � feito a inser��o e remo��o de um n� em meu
             * c�digo � poss�vel que um n� pai de um n� pai (n� av�), tenha fator
             * de balanceamento acima do permitido em uma �rvore AVL, sendo
             * necess�rio esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() > 1){
                
                if(q.getFatorB() >= 0){
                    
                    q = rotacaoDireita(p);
                }else{
                    
                    q = rotacaoDuplaD(p);
                }//Fim do la�o if
                
            }//Fim do la�o if
            if((q.getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(p);
                }else{
                    
                    q = rotacaoDuplaE(p);
                }//Fim do la�o if
            }//Fim do la�o if
            /*
             * Devido a forma como � feito a inser��o e remo��o de um n� em meu
             * c�digo � poss�vel que um n� pai de um n� pai (n� av�), tenha fator
             * de balanceamento acima do permitido em uma �rvore AVL, sendo
             * necess�rio esse tipo de ajuste.
             */
            if(((q.getPai()).getPai()).getFatorB() < -1 ){
                
                if(q.getFatorB() <= 0){
                    
                    q = rotacaoEsquerda(p);
                }else{
                    
                    q = rotacaoDuplaE(p);
                }//Fim do la�o if
            }//Fim do la�o if
        }//Fim do la�o if
    }//Fim do m�todo implementado removeAVL, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Uma string com a representa��o do caminho prefixado na �rvore, onde cada
     * n� � representado com o seu valor e o respectivo fator de balanceamento.
     * 
     * @return string representando cada n� com o seu valor e o seu respectivo fator de balanceamento no caminho prefixado
     */
    public String caminhoPrefixado() {
        
        Stack pilha = new Stack();//Pilha para caminhamento nos n�s
        String caminho = null;//String para representa��o do caminho
        
        pilha.push(raiz);
        while(!pilha.empty()){
            
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                caminho = caminho + "(" + q.getValor() + "," + q.getFatorB() + "); ";
                pilha.push(q.getFilhoD());
                pilha.push(q.getFilhoE());
            }//Fim do la�o if
        }//Fim do la�o while
        return caminho;
    }//Fim do m�todo implementado caminhoPrefixado, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Uma string com a representa��o do caminho central da �rvore.
     * 
     * @return string representando cada n� com o seu valor e o seu respectivo fator de balanceamento no caminho central
     */
    public String caminhoCentral() {
        
        Stack pilha = new Stack();//Pilha para caminhamento nos n�s
        String caminho = null;//String para representa��o do caminho
        
        while(!(op1.getFilhoE() == null)){
            op1 = op1.getFilhoE();            
        }//Fim do la�o while
        pilha.push(op1);
        
        while(!pilha.empty()){
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                caminho = caminho + "(" + q.getValor() + "," + q.getFatorB() + "); ";
                pilha.push((q.getPai()).getFilhoD());
                pilha.push(q.getPai());
            }//Fim do la�o if
        }//Fim do la�o while
        op1 = raiz;//retornando op ao est�gio inicial (c�pia de raiz)
        return caminho;
    }//Fim do m�todo implementado caminhoCentral, provindo de Interfaces.ArvoreAVL

    @Override
    /**
     * Uma string com o caminho posfixado na �rvore.
     * 
     * @return string representando cada n� com o seu valor e o seu respectivo fator de balanceamento no caminho posfixado
     */
    public String caminhoPosfixado() {
        
        Stack pilha = new Stack();//Pilha para caminhamento nos n�s
        String caminho = null;//String para representa��o do caminho
        
        pilha.push(op1);//empilhando a raiz da �rvore
        while(!(op1.getFilhoE() == null)){
            op1 = op1.getFilhoE();            
        }//Fim do la�o while
        pilha.push(op1);
        
        while(!pilha.empty()){
            
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                caminho = caminho + "(" + q.getValor() + "," + q.getFatorB() + "); ";
                pilha.push(q.getPai());
                pilha.push((q.getPai()).getFilhoD());
            }//Fim do la�o while
        }//Fim do la�o while
        op1 = raiz;//retornando op ao est�gio inicial (c�pia de raiz)
        return caminho;
    }//Fim do m�todo implementado caminhoPosfixado, provindo de Interfaces.ArvoreAVL
    
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
            }//Fim do la�o if
            y.setFatorB(0);
        }//Fim do la�o if
        
        return y;
    }
    
    private void fatorB(){
        //reajuste de fator atrav�s de caminho posfixado
        
        Stack pilha = new Stack();//Pilha para caminhamento nos n�s
                
        pilha.push(op1);//empilhando a raiz da �rvore
        while(!(op1.getFilhoE() == null)){
            op1 = op1.getFilhoE();            
        }//Fim do la�o while
        pilha.push(op1);
        
        while(!pilha.empty()){
            
            noAVL q = (noAVL) pilha.pop();
            if(q != null){
                
                if(q.getFilhoE() == null){
                    
                    if(q.getFilhoD() == null){
                        
                        q.setFatorB(0);
                    }else{
                        
                        q.setFatorB((q.getFilhoD()).getFatorB() - 1);
                    }//Fim do la�o if
                }else{
                    
                    if(q.getFilhoD() == null){
                        
                        q.setFatorB((q.getFilhoE()).getFatorB() + 1);
                    }else{
                        
                        q.setFatorB((q.getFilhoE()).getFatorB() - (q.getFilhoD()).getFatorB());
                    }//Fim do la�o if
                }//Fim do la�o if
                pilha.push(q.getPai());
                pilha.push((q.getPai()).getFilhoD());
            }//Fim do la�o while
        }//Fim do la�o while
        op1 = raiz;//retornando op ao est�gio inicial (c�pia de raiz)
        /*
         * Explica��o sobre o funcionamento: o c�lculo do fator de balancemanento
         * � feito atrav�s de um caminho posfixado realizado na �rvore, que
         * reajusta o fator de balanceamento de acordo com o fator de balanceamento
         * dos n�s descendentes, se o n� de fato tiver descendentes.
         */
    }
    
}//Fim da classe ArvoreAVL