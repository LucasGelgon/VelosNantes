/**
 * @author clemence, ronan, lucas
 * This class represents the amount of cycles that passes in a street per day
 */
 
package velo;
import java.util.*;

    
public class Comptage{
    
    //attributs of the class
    private Jour jour;
    private Compteur compteur;
    private String presenceAnomalie;
    private int[] heures;


    /**
     * Constructs a Comptage object with the specified attributes.
     *
     * @param jour               The date of the day.
     * @param compteur           The Compteur that does the Comptage
     * @param presenceAnomalie   The problem if there is one.
     * @param heures             The hours of the day
     */
    public Comptage(Jour jour, Compteur cpt, String presenceAnomalie, int[] heures)throws RuntimeException {
        if (jour != null){
            this.jour = jour;
        }
        else{
            throw new RuntimeException("invalid param : jour");
        }
        if(cpt != null){
            this.compteur = cpt;
        }else{
            throw new RuntimeException("invalid param : compteur");
        }
        boolean anomalie = false;
        int i =0;
        while(!anomalie && i<PresenceAnomalie.values().length){
            if(presenceAnomalie == PresenceAnomalie.values()[i].toString()){
                anomalie = true;
            }else {
                i++;
            }
        }
        if(anomalie == false && presenceAnomalie !=null){
            throw new RuntimeException("invalid param : presenceAnomalie");
        }
        else{
            this.presenceAnomalie = presenceAnomalie;
        }
        if(heures != null){
            this.heures = heures;
        }else{
            throw new RuntimeException("invalid param : heures");
        }
    }
    
   
   /**
     * get the Jour of the Comptage
     * @return Jour
     */
    public Jour getJour(){
        return this.jour;
    }
    
    /**
     * get the Compteur of the Comptage
     * @return Compteur
     */
     public Compteur getCompteur(){
         return this.compteur;
     }
     
     /**
      * get the presence anomalie for the compteur
      * @return String
      */
      public String getPresenceAnomalie(){
          return this.presenceAnomalie;
      }
      
      /**
       * get the number of bikes per hour of the comptage
       *@return int[]
       */
       public int[] getHeures(){
           return this.heures;
       }
       
       /**
         * set the jour of the Comptage
         * @param newJour : Jour
         */
       public void setJour(Jour newJour)throws RuntimeException{
           if (newJour != null){
            this.jour = newJour;
        }
        else{
            throw new RuntimeException("invalid param : newJour");
        }
     }
     
       /**
         * set the compteur of the Comptage
         * @param newCompteur : Compteur
         */
       public void setCompteur(Compteur newCompteur)throws RuntimeException{
           if (newCompteur != null){
            this.compteur = newCompteur;
        }
        else{
            throw new RuntimeException("invalid param : newCompteur");
        }
      }
      
        /**
         * set the presenceAnomalie of the Comptage
         * @param newAnom : String
         */
       public void setPresenceAnomalie(String newAnom)throws RuntimeException{
           if (newAnom != null){
            this.presenceAnomalie = newAnom;
        }
        else{
            throw new RuntimeException("invalid param : newAnom");
        }
     }
     
     
       /**
         * set the hours of the Comptage
         * @param newHeures : int[]
         */
       public void setHeures(int[] newHeures)throws RuntimeException{
           if (newHeures != null){
            this.heures = newHeures;
        }
        else{
            throw new RuntimeException("invalid param : newHeures");
        }
     }
     
     
     /**
      * method that returns a readable string which represents a comptage
      * @return String
      */
      public String toString(){
        String ret = "Compteur : " +this.getCompteur().toString() + ", Jour = " + this.getJour().toString() + ", Présence anomalie = " + this.getPresenceAnomalie() + ", Heures = " + this.getHeures();
        return ret;
    }
    
    /**
     * methods that returns the number of bike for only one hour
     * @param heure : int
     * @return int
     */
     public int nbVelos(int heure){
         int ret = getHeures()[heure-1];
         return ret;
     }
    
}
