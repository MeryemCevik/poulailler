/*
 * Nom de classe : 2SIO2
 *
 * Description   : TP – Collections
 * 
 * Version       : 1.0
 *
 * Date          : 12/12/2023
 * 
 * Copyright     : CEVIK Meryem
 */
 
 /**
 * Classe : Ferme
 * 
 * @version 1.0
 *
 * @author Meryem CEVIK
 */
package classes;

import java.util.*;

public class Ferme {
	//ATTRIBUTS
	//-------------------
	private Set<Volaille> volailles;
	private int nbVolailles;
	
	///CONSTRUCTEUR par défaut
	//-------------------
	public Ferme() {
		this.volailles = new HashSet<Volaille>();
		this.nbVolailles = 0;
	}
	//CONSTRUCTEUR par initialisation
	//--------------------------------
	public Ferme(Set<Volaille> V, int nbV) {
		this.volailles=V;
		this.nbVolailles=nbV;
	}
	//ACCESSEURS + MODIFICATEURS
	//-----------------------------
	public Set<Volaille> getVolailles() {
		return volailles;
	}
	public void setVolailles(Set<Volaille> volailles) {
		this.volailles = volailles;
	}
	public int getNbVolailles() {
		return nbVolailles;
	}
	public void setNbVolailles(int nbVolailles) {
		this.nbVolailles = nbVolailles;
	}
	
	//METHODES
	//-------------------
	//Méthode qui ajoute les nouvelles volailles
	public void ajouterVolaille(Volaille volaille) {
		if(this.volailles.add(volaille)){
			this.nbVolailles++;
		}
	}
	//Méthode qui trie les animaux à abattre
	public Set<Volaille> AnimauxEnvoyerALabatoir(){
		Set<Volaille> listeV = new HashSet<Volaille>();

        for (Volaille v : this.volailles) {
            if (v.estPretPourAbattage()) {
                listeV.add(v);
            }
        }
        return listeV;
	}
	//Méthode qui permet d'évaluer le prix obtenu pour les animaux à abattre
	public double evalPrix() {
		double prixTot = 0;
        Set<Volaille> animauxAbattre = this.AnimauxEnvoyerALabatoir();
        for (Volaille v : animauxAbattre) {
            prixTot += v.prix();
        }
        return prixTot;
	}
	//toString
	public String toString() {
		//StringBuilder :créer des chaînes de caractères modifiables
		// Cette fonction a permis de debogger mon code
		StringBuilder text = new StringBuilder("Ferme : \n");
	    for (Volaille v : this.volailles) {
	        text.append(v.getId()).append(", ").append(v.getPoids()).append(", ").append(v.prix()).append("\n");
	    }
	    return text.toString();
	}

}

 
 /**
 * Classe : Volaille
 * 
 * @version 1.0
 *
 * @author Meryem CEVIK
 */
package classes;

public class Volaille {
	//ATTRIBUTS
	//-------------------
	private int id;
	private double poids;
	private int age;
	
	//CONSTRUCTEUR par defaut
	//-------------------
	public Volaille(){
		this.id=0;
		this.poids=0.0;
		this.age=3;
	}
	
	//CONSTRUCTEUR par initialisation
	//--------------------------------
	public Volaille(int I,double P,int A) {
		this.id=I;
		this.poids=P;
		this.age=A;
	}
	
	//ACCESSEURS + MODIFICATEURS
	//-----------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//METHODES
	//-------------------
	//Affichage : 
	@Override
	public String toString() {
	    return "Id : " + this.getId() + "\n" +
	           "Poids : " + this.getPoids() + "\n" +
	           "Age : " + this.getAge() + "\n" ;
	}
	public boolean estPretPourAbattage() {
		return false;
	}
	public double prix() {
		return 0;
	}

}

 /**
 * Classe : Canard
 * 
 * @version 1.0
 *
 * @author Meryem CEVIK
 */
package classes;

public class Canard extends Volaille {
	//ATTRIBUTS
	//-------------------
	private double prixAuKilo;
	private double poidsAbattage;
	
	//CONSTRUCTEUR par defaut
	//-------------------
	public Canard() {
		this.setPrixAuKilo(1);
		this.setPoidsAbattage(1);
	}
	//CONSTRUCTEUR par initialisation
	//--------------------------------
	public Canard(double prix, double poids) {
		this.prixAuKilo=prix;
		this.poidsAbattage=poids;
	}
	//ACCESSEURS + MODIFICATEURS
	//-----------------------------
	public double getPrixAuKilo() {
		return prixAuKilo;
	}
	public void setPrixAuKilo(double prixAuKilo) {
		this.prixAuKilo = prixAuKilo;
	}
	public double getPoidsAbattage() {
		return poidsAbattage;
	}
	public void setPoidsAbattage(double poidsAbattage) {
		this.poidsAbattage = poidsAbattage;
	}
	//METHODES
	//-------------------
	//Permet de calculer le prix au kilo du jour
	public double prix(){
		return poidsAbattage*prixAuKilo;
		}
	//Renvoie true si la volaille est prête sinon false
	public boolean estPretPourAbattage(){
		boolean estPret=false;
		if(this.getPoids() >= poidsAbattage) {
			estPret=true;
		}
		return estPret;
		}
	//toString
		@Override
		public String toString() { 
		    return super.toString() + "\n"+"Prix au kilo du jour : " + this.getPrixAuKilo() + "\n"+"Poids limite d'abattage "+ this.poidsAbattage;
		}

}
 /**
 * Classe : Poulet
 * 
 * @version 1.0
 *
 * @author Meryem CEVIK
 */
package classes;

public class Poulet extends Volaille {
	//ATTRIBUTS
	//-------------------
	private double prixAuKilo;
	private double poidsAbattage;
	
	///CONSTRUCTEUR par defaut
	//-------------------
	public Poulet() {
		this.setPrixAuKilo(1);
		this.setPoidsAbattage(1);
	}
	//CONSTRUCTEUR par initialisation
	//--------------------------------
	public Poulet(double prix, double poids) {
		this.prixAuKilo=prix;
		this.poidsAbattage=poids;
	}
	//ACCESSEURS + MODIFICATEURS
	//-----------------------------
	public double getPrixAuKilo() {
		return prixAuKilo;
	}
	public void setPrixAuKilo(double prixAuKilo) {
		this.prixAuKilo = prixAuKilo;
	}
	public double getPoidsAbattage() {
		return poidsAbattage;
	}
	public void setPoidsAbattage(double poidsAbattage) {
		this.poidsAbattage = poidsAbattage;
	}
	//METHODES
	//-------------------
	//Permet de calculer le prix au kilo du jour
	public double prix(){
		return poidsAbattage *prixAuKilo;
		}
	//Renvoie true si la volaille est prête sinon false
	public boolean estPretPourAbattage(){
		boolean estPret=false;
		if(this.getPoids() >= poidsAbattage) {
			estPret=true;
		}
		return estPret;
		}
	//toString
	@Override
	public String toString() { 
	    return super.toString() + "\n"+"Prix au kilo du jour : " + this.getPrixAuKilo() + "\n"+"Poids limite d'abattage "+ this.poidsAbattage;
	}
}
  /**
 * Classe : Test
 * 
 * @version 1.0
 *
 * @author Meryem CEVIK
 */
package test;

import java.util.Set;

import classes.Canard;
import classes.Ferme;
import classes.Poulet;
import classes.Volaille;

public class Test {

	public static void main(String[] args) {
		
		//classe POULET
		
		//Créer 2 poulets
		Poulet P1 = new Poulet(5,10);
		Poulet P2 = new Poulet(6,1);
		
		//Q6 : vérification si prêt pour l'abbattage
		System.out.println(P1.estPretPourAbattage());
		
		//Q4 : modifier poids limite d'abattage
		P2.setPoidsAbattage(50);
		
		//Q3 : modifier prix au kilo du jour
		P2.setPrixAuKilo(50);
		
		//Q5 : modifier poids d'une volaille
		P2.setPoids(15);
		
		//Q2 : Calcul du prix
		System.out.println(P2.prix());
		
		//AFFICHAGE : 
		System.out.println(P1.toString());
		System.out.println(P2.toString());
		
		//classe CANARD
		Canard C1 = new Canard(7,10);
		System.out.println(C1.estPretPourAbattage());
		Canard C2 = new Canard(8,15);
		System.out.println(C2.estPretPourAbattage());
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		
		//classe FERME
		
		//création de la Ferme
		Ferme F1 = new Ferme();
		
		// Q9 :Affichage des animaux après le trie
		Set<Volaille> exempleFerme = F1.AnimauxEnvoyerALabatoir();
		System.out.println(exempleFerme.toString());
		
		
		//Q10 : Evaluation des prix
		double prixTot =F1.evalPrix();
		System.out.println(F1.toString());
		
		
		// Q8 : enregister les jeunes animaux
		F1.ajouterVolaille(C1);
		F1.ajouterVolaille(C2);
		F1.ajouterVolaille(P1);
		F1.ajouterVolaille(P2);
		F1.AnimauxEnvoyerALabatoir();
		
		//AFFICHAGE
		System.out.println(F1.toString());
		System.out.println(F1.evalPrix());
		System.out.println(F1.toString());
	}

}
