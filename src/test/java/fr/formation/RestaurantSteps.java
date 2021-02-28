package fr.formation;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RestaurantSteps {

	Commande commande;

	@Given("le menu contient les plats suivants$")
	public void le_menu_contient_les_plats_suivants(final List<Plat> plats) {
		commande = new Commande(plats);
	}

	@When("le client commande (\\d+) (.+)$")
	public void le_client_commande(final Integer qte, final String nomPlat) {
		commande.commandePlat(nomPlat, qte);
	}

	@And("le client a une reduction de (\\d+\\.\\d+) euros$")
	public void le_client_a_une_reduction_de(final double red) {
		commande.reduction(red);
	}

	@Then("le montant total devrait être (\\d+\\.\\d+)$")
	public void le_montant_total_devrait_etre(final double montant) {
		Assert.assertEquals(montant, commande.getPrix(), 0.01);
	}

	@DataTableType()
	public Plat convert(Map<String, String> entry) {
		return new Plat(entry.get("nom"), Double.parseDouble(entry.get("prix")));
	}
}
