package ch.hearc.boutiqueservice.domaine.model;

import java.util.Objects;

import org.apache.tomcat.util.buf.StringUtils;

public class Biere {

	public String getNom() {
		return nom;
	}

	public TypeBiere getType() {
		return type;
	}

	private String nom;
	private TypeBiere type;
	private Fabricant fabricant;
	
	public static Biere creerBiere(String nom, TypeBiere type, Fabricant fabricant) {
		valideParametres(nom, type, fabricant);
		
		return new Biere(nom, type);
		
	}

	private Biere(String nom, TypeBiere type) {
		super();
		this.nom = nom;
		this.type = type;
	}

	private static void valideParametres(String nom, TypeBiere type, Fabricant fabricant) {
		
		Objects.requireNonNull(nom);
		Objects.requireNonNull(type);
		Objects.requireNonNull(fabricant);
		
		if(nom.isEmpty() || nom.length() < 5) {
			throw new IllegalArgumentException("Le nom de la biere doit comporter au moins 5 caractères");
		}
	}
}
