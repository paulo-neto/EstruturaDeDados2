package br.ufpb.ed2.arvoreAVL;

public class TreeAVL {
	 Nodo raiz;
	
	public TreeAVL(){
		this.raiz = null;
	}
	
	private static int maior(int a, int b){
		if(a > b)
			return a;
		return b;
	}
	
//------------------------------------altura	
	private static int altura(Nodo n){
		if(n == null)
			return -1;
		return n.getAltura();
	}
	
//------------------------------------------rotação a Esquerda
	private static Nodo rotacaoEsquerda(Nodo umNo){
		Nodo noAux = umNo.getFilhoEsquerda();
		int a;
		int b;
		umNo.setFilhoEsquerda(noAux.getFilhoDireita());
		noAux.setFilhoDireita(umNo);
		a = TreeAVL.altura(umNo.getFilhoEsquerda());
		b = TreeAVL.altura(umNo.getFilhoDireita());
		umNo.setAltura(TreeAVL.maior(a, b)+1);
		a = TreeAVL.altura(noAux.getFilhoEsquerda());
		b = umNo.getAltura();
		noAux.setAltura(TreeAVL.maior(a, b)+1);
		return noAux;
	}
	
//------------------------------------------------rotação a Direita
	private static Nodo rotacaoDireita(Nodo umNo){
		Nodo noAux = umNo.getFilhoDireita();
		int a,b;
		
		umNo.setFilhoDireita(noAux.getFilhoEsquerda());
		noAux.setFilhoEsquerda(umNo);
		a = TreeAVL.altura(umNo.getFilhoEsquerda());
		b = TreeAVL.altura(umNo.getFilhoDireita());
		umNo.setAltura(TreeAVL.maior(a, b)+1);
		a = TreeAVL.altura(noAux.getFilhoDireita());
		b = umNo.getAltura();
		noAux.setAltura(TreeAVL.maior(a, b)+1);
		return noAux;	
	}
	
//-------------------------------------------------rotação Dupla a Esquerda
	private static Nodo rotDuplaEsquerda(Nodo umNo){
		umNo.setFilhoEsquerda(TreeAVL.rotacaoDireita(umNo.getFilhoEsquerda()));
		return TreeAVL.rotacaoEsquerda(umNo);
	}

//-------------------------------------------------rotação Dupla a Direita
	private static Nodo rotDuplaDireita(Nodo umNo){
		umNo.setFilhoDireita(TreeAVL.rotacaoEsquerda(umNo.getFilhoDireita()));
		return TreeAVL.rotacaoDireita(umNo);
	}

//-------------------------------insere
	public void insere(int info){
		this.raiz = insere(info,this.raiz);
	}
//------------------------------insere(sobre carga)
	private Nodo insere(int info,Nodo umNo){
		int a,b;
		if(umNo == null){
			umNo = new Nodo(null,info,null);
		}else{
			if(info > umNo.getInfo()){
				umNo.setFilhoDireita(insere(info,umNo.getFilhoDireita()));
				a = TreeAVL.altura(umNo.getFilhoDireita());
				b = TreeAVL.altura(umNo.getFilhoEsquerda());
				if(a - b == 2){
					if(info > umNo.getFilhoDireita().getInfo()){
						umNo = TreeAVL.rotacaoDireita(umNo);
					}	
					else{
						umNo = TreeAVL.rotDuplaDireita(umNo);
					}
				}
			}
			else{
				if(info < umNo.getInfo()){
					umNo.setFilhoEsquerda(insere(info,umNo.getFilhoEsquerda()));
					a = TreeAVL.altura(umNo.getFilhoEsquerda());
					b = TreeAVL.altura(umNo.getFilhoDireita());
					if(a - b == 2){
						if(info < umNo.getFilhoEsquerda().getInfo()){
							umNo = TreeAVL.rotacaoEsquerda(umNo);
						}
						else{
							umNo = TreeAVL.rotDuplaEsquerda(umNo);
						}
					}
				}
			}
		}
		a = TreeAVL.altura(umNo.getFilhoEsquerda());
		b = TreeAVL.altura(umNo.getFilhoDireita());
		umNo.setAltura(TreeAVL.maior(a, b)+1);
		return umNo;
	}

//---------------------------verifica se a arvore esta vazia
	private boolean vazia(){
		if(this.raiz == null) return true;
		return false;
	}
	private static boolean vazia(Nodo tree){
		if(tree == null) return true;
		return false;
	}
	
//---------------------------exibir
	public void exibe(){
		if(vazia()){
			System.out.println("A Arvore está Vazia");
		}else{
			exibe(this.raiz,1);
		}
	}
	
//----------------------------exibe(sobre carga)
	private void exibe(Nodo umNo,int n){
		if(umNo != null){
			exibe(umNo.getFilhoDireita(), n+1);
//			for(int i = 0;i < n;i++){
//				System.out.println("   ");
//			}
			System.out.println("\n"+umNo.getInfo());
			exibe(umNo.getFilhoEsquerda(), n+1);
		}
	}
	
//----------------------------------------Caminhamento Pré-Ordem
	public static void caminhamentoPreOrdem(Nodo tree){
		if(!vazia(tree)){
			System.out.println(" Valor :"+tree.getInfo());
			caminhamentoPreOrdem(tree.getFilhoEsquerda());
			caminhamentoPreOrdem(tree.getFilhoDireita());
		}
	}
	
}




