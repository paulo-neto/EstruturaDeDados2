package br.com.ed2.programacaoGulosa.menorCaminho;

import java.util.Comparator;

public class CompareDistancia implements Comparator<Cidade>{

	@Override
	public int compare(Cidade _c1, Cidade _c2) {
		
		Cidade c1 = _c1;
		Cidade c2 = _c2;
		
		if (c1.distancia > c2.distancia)
			return 1;
		else
			if (c2.distancia < c1.distancia)
				return -1;
		
		return 0;
	}

}
