package ch.hearc.boutiqueservice.domaine.model;

import java.util.Objects;
import java.util.UUID;


public class Biere extends Article{

	public String getNom() {
		return nom;
	}

	public TypeBiere getType() {
		return type;
	}

	

	
	public String getIdentifiant() {
		return identifiant;
	}

	private String identifiant;
	private String nom;
	private TypeBiere type;
	
	
	public static Biere creerBiere(String nom, TypeBiere type) {
		
		valideParametres(nom, type);
		
		return new Biere(nom, type);
	}

	private Biere(String nom, TypeBiere type) {
		super();
		this.nom = nom;
		this.type = type;
		this.identifiant = UUID.randomUUID().toString();
	}

	public Biere(String nom, TypeBiere typeBiere, Fabricant fabricant) {
		this(nom,typeBiere);
		this.defineFabricant(fabricant);
	}

	private static void valideParametres(String nom, TypeBiere type) {
		
		Objects.requireNonNull(nom);
		Objects.requireNonNull(type);
		
		if(nom.isEmpty() || nom.length() < 5) {
			throw new IllegalArgumentException("Le nom de la biere doit comporter au moins 5 caract�res");
		}
	}

	public static Biere creerBiere(String nom, TypeBiere typeBiere, Fabricant fabricant) {
		Biere bierre = new Biere(nom, typeBiere, fabricant);
		return bierre;
		
		
	}
}
