package br.com.ed2.programacaoGulosa.mochila;

import java.util.Comparator;

public class ComparaProdutoRazao implements Comparator< Produto> {

	@Override
	public int compare(Produto p1, Produto p2) {
		if(p1.getRazao() < p2.getRazao())
			return 1;
		else
			if(p1.getRazao() > p2.getRazao())
				return -1;
		return 0;
	}

}
