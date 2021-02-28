package fr.formation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Commande {

	private Map<String, Plat> plats = new HashMap<>();

	private Double prix = 0.0;

	public Commande(final List<Plat> dishes) {
		this.plats = dishes.stream().collect(Collectors.toMap(Plat::getNom, Function.<Plat>identity()));
	}

	public void commandePlat(String nomPlat, Integer qte) {
		Plat plat = plats.get(nomPlat);
		double prix = plat.getPrix();
		prix = prix * qte;
		this.prix += prix;
	}

	public Double getPrix() {
		return prix;
	}

	public void reduction(double red) {
		prix -= red;
	}

}
