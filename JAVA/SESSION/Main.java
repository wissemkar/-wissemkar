package exercice2gt;

import java.util.ArrayList;
import java.util.HashMap;

// Classe pour représenter une délégation
class Delegation {
    private String nom;
    private int population;

    public Delegation(String nom, int population) {
        this.nom = nom;
        this.population = population;
    }

    public String getNom() {
        return nom;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

// Classe pour représenter une ville
class Ville {
    private String nom;
    private ArrayList<Delegation> delegations;

    public Ville(String nom) {
        this.nom = nom;
        this.delegations = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterDelegation(Delegation delegation) {
        delegations.add(delegation);
    }

    public void supprimerDelegation(Delegation delegation) {
        delegations.remove(delegation);
    }

    public int calculerPopulationVille() {
        int populationVille = 0;
        for (Delegation delegation : delegations) {
            populationVille += delegation.getPopulation();
        }
        return populationVille;
    }
}

// Classe pour représenter un pays
class Pays {
    private String nom;
    private HashMap<String, Ville> villes;

    public Pays(String nom) {
        this.nom = nom;
        this.setVilles(new HashMap<>());
    }

    public String getNom() {
        return nom;
    }

    public void ajouterVille(String nomVille) {
        getVilles().put(nomVille, new Ville(nomVille));
        System.out.println("Ville ajoutée : " + nomVille);
    }

    public void supprimerVille(String nomVille) {
        getVilles().remove(nomVille);
        System.out.println("Ville supprimée : " + nomVille);
    }

    public int calculerPopulationPays() {
        int populationPays = 0;
        for (Ville ville : getVilles().values()) {
            populationPays += ville.calculerPopulationVille();
        }
        return populationPays;
    }

    public HashMap<String, Ville> getVilles() {
        return villes;
    }

    public void setVilles(HashMap<String, Ville> villes) {
        this.villes = villes;
    }
}

public class Main {
    public static void main(String[] args) {
        Pays pays = new Pays("PaysA");
        pays.ajouterVille("sfax");
        pays.ajouterVille("kebili");

        Ville villeA = pays.getVilles().get("sfax");
        Ville villeB = pays.getVilles().get("kebili");

        villeA.ajouterDelegation(new Delegation("Mahres", 10000));
        villeA.ajouterDelegation(new Delegation("Tina", 1400));
        villeB.ajouterDelegation(new Delegation("Douz", 400));

        int populationTotale = pays.calculerPopulationPays();
        System.out.println("Population totale du pays : " + populationTotale);
    }
}
