package zilldy.com.github.cineminha.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import zilldy.com.github.cineminha.modelos.Filme;
import zilldy.com.github.cineminha.modelos.Serie;
import zilldy.com.github.cineminha.modelos.Titulo;

public class PrincipalComListas {

	public static void main(String[] args) {
		Filme meuFilme = new Filme("O poderoso chefão", 1970);
		meuFilme.avalia(9);		
		Filme outroFilme = new Filme("Avatar", 2023);
		outroFilme.avalia(7);
		var filmeDoPaulo = new Filme("Dogville", 2003);
		filmeDoPaulo.avalia(10);
		Serie lost = new Serie("Lost", 2000);
		lost.avalia(8);
		
		List<Titulo> lista = new ArrayList<>();
		
		lista.add(filmeDoPaulo);
		lista.add(meuFilme);
		lista.add(outroFilme);
		lista.add(lost);
		
		for (Titulo item : lista) {
			System.out.println(item);
			if (item instanceof Filme filme)
				System.out.println("Classificação: " + filme.getClassificacao());
		}
		
		List<String> buscaPorArtista = new ArrayList<String>();
		buscaPorArtista.add("Adam Sandler");
		buscaPorArtista.add("Paulo");
		buscaPorArtista.add("Jacqueline");
		System.out.println(buscaPorArtista);
		Collections.sort(buscaPorArtista);
		System.out.println(buscaPorArtista);
		
		System.out.println("Ordenando por nome");
		Collections.sort(lista);
		System.out.println(lista);
		lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
		System.out.println("Ordenando por ano");
		System.out.println(lista);
		
		
		
	}
}
