package br.com.entropie.githubers;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class Locations {

	public static List<String> get() {
		List<String> brasil = Lists.newArrayList("Brasil", "Brazil");

		List<String> states = Lists.newArrayList("Para", "Acre", "Tocantins",
				"Rondônia", "Amazonas", "Amapá", "Paraná", "Santa Catarina",
				"Rio grande do sul", "São Paulo", "Espirito Santo",
				"Rio de Janeiro", "Minas gerais", "Distrito Federal", "Goiás",
				"Mato Grosso", "Mato Grosso do sul", "Rio grande do norte",
				"Pernambuco", "Maranhão", "Ceará", "Paraíba", "Alagoas",
				"Sergipe", "Piauí", "Bahia");

		List<String> cities = Lists.newArrayList("Belém", "Belem",
				"Rio Branco", "Palmas", "Boa Vista", "Macapá", "Macapa",
				"Curitiba", "Florianópolis", "Florianopolis", "Porto Alegre",
				"Sao Paulo", "Vitória", "Vitoria", "Rio de Janeiro",
				"Belo%20Horizonte", "Brasília", "Goiania", "Cuiabá", "Cuiaba",
				"Campo Grande", "Natal", "Recife", "São Luis", "Sao Luis",
				"Fortaleza", "João Pessoa", "Joao Pessoa", "Maceió", "Maceio",
				"Aracaju", "Teresina", "Salvador");

		List<String> locations = new ArrayList<>();
		locations.addAll(brasil);
		locations.addAll(states);
		locations.addAll(cities);

		return locations;
	}
}
