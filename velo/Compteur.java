// @autor: UZEL Ronan
// SAE Velo de Nantes

/**
 * this class represents a counter on a road section. It is characterized by an id, a label, a direction, a longitude and a latitude.
 * She has a constructor and getters and setters.
 */
package velo;
import java.util.ArrayList;


public class Compteur {
    //attributs of the Compteur class
     //id of the counter
    private int idCompteur;

     //label of the counter
    private String libelle;

     //direction of the counter
    private String sens;

     //longitude of the counter
    private double longitude;

     //latitude of the counter
    private double latitude;

    /**
     * Constructor of the class Compteur
     * @param idCompteur : id of the counter
     * @param libelle : label of the counter
     * @param sens : direction of the counter
     * @param longitude : longitude of the counter
     * @param latitude : latitude of the counter
     */
    public Compteur(int idCompteur, String libelle, String sens, double longitude, double latitude) {
        if (idCompteur < 0) {
            throw new IllegalArgumentException("idCompteur must be positive");
        } else {
            this.idCompteur = idCompteur;
        }

        if (libelle == null) {
            throw new IllegalArgumentException("libelle must not be null");
        } else {
            this.libelle = libelle;
        }

        if (sens == null) {
            throw new IllegalArgumentException("sens must not be null");
        } else {
            this.sens = sens;
        }

        if (longitude < 0) {
            throw new IllegalArgumentException("longitude must be positive");
        } else {
            this.longitude = longitude;
        }

        if (latitude < 0) {
            throw new IllegalArgumentException("latitude must be positive");
        } else {
            this.latitude = latitude;
        }
    }

    /**
     * getter of the id of the counter
     * @return idCompteur : id of the counter
     */
    public int getIdCompteur() {
        return idCompteur;
    }

    /**
     * setter of the id of the counter
     * @param idCompteur : id of the counter
     */
    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    /**
     * getter of the label of the counter
     * @return libelle : label of the counter
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * setter of the label of the counter
     * @param libelle : label of the counter
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDirection(String sens) {
        String[] parts = sens.split("vers");
        String part2 = parts[1];
        System.out.println(part2);
        return part2;
    }

    public void setDirection(String sens) {
        this.sens = sens;
    }

    /**
     * getter of the direction of the counter
     * @return sens : direction of the counter
     * doit fonctionner avec le split
     */
    public String getSens() {
        
        if (sens == "12") {
            sens = "Nord";
        } else if (sens == "6") {
            sens = "Sud";
        } else if (sens == "3") {
            sens = "Est";
        } else if (sens == "9") {
            sens = "Ouest";
        } else {
            sens = "Inconnu";
        }
        return sens;
    }

    /**
     * setter of the direction of the counter
     * @param sens : direction of the counter
     * doit fonctionner avec le split pour avoir la direction en clair
     */
    public void setSens(String sens) {
        this.sens = sens;
    }

    /**
     * getter of the longitude of the counter
     * @return longitude : longitude of the counter
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * setter of the longitude of the counter
     * @param longitude : longitude of the counter
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * getter of the latitude of the counter
     * @return latitude : latitude of the counter
     */
    public double getLatitude() { 
        return latitude; 
    }

    /**
     * setter of the latitude of the counter
     * @param latitude : latitude of the counter
     */
    public void setLatitude(double latitude) { 
        this.latitude = latitude; 
    }

    /**
     * toString method of the class Compteur
     * @return libelle, sens, longitude, latitude
     */
    public String toString() {
        String ret = "Compteur : " + "libelle = " + this.getLibelle() + ", sens = " + this.getSens() + ", longitude = " + this.getLongitude() + ", latitude = " + this.getLatitude();
        return ret;
    }

    // ajout de méthodes
    // coordonnees : ArrayList<Double>
    // nomComplet : String

    /**
     * Methode coordonnees : elle retourne les coordonnees du compteur
     * @param longitude : double
     * @param latitude : double
     * @return coordonnees : ArrayList<Double>
     */

    public ArrayList<Double> coordonnees(double longitude, double latitude) {
        ArrayList<Double> coordonnees = new ArrayList<Double>();
        coordonnees.add(longitude);
        coordonnees.add(latitude);
        return coordonnees;
    }

    /**
     * Methode nomComplet : elle retourne le nom complet du compteur
     * @param libelle : String
     * @param sens : String
     * @return nomComplet : String
     */

    public String nomComplet(String libelle, String sens) {
        String nomComplet = libelle + " " + sens;
        return nomComplet;
    }
}




