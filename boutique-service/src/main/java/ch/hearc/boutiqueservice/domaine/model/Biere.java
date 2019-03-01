package ch.hearc.boutiqueservice.domaine.model;

import java.util.Objects;
import java.util.UUID;


public class Biere {

	public String getNom() {
		return nom;
	}

	public TypeBiere getType() {
		return type;
	}

	public Fabricant getFabricant() {
		return fabricant;
	}

	
	public String getIdentifiant() {
		return identifiant;
	}

	private String identifiant;
	private String nom;
	private TypeBiere type;
	private Fabricant fabricant;
	
	public static Biere creerBiere(String nom, TypeBiere type, Fabricant fabricant) {
		
		valideParametres(nom, type, fabricant);
		
		return new Biere(nom, type, fabricant);
	}

	private Biere(String nom, TypeBiere type, Fabricant fabricant) {
		super();
		this.nom = nom;
		this.type = type;
		this.fabricant = fabricant;
		this.identifiant = UUID.randomUUID().toString();
	}

	private static void valideParametres(String nom, TypeBiere type, Fabricant fabricant) {
		
		Objects.requireNonNull(nom);
		Objects.requireNonNull(type);
		Objects.requireNonNull(fabricant);
		
		if(nom.isEmpty() || nom.length() < 5) {
			throw new IllegalArgumentException("Le nom de la biere doit comporter au moins 5 caract�res");
		}
	}
}
