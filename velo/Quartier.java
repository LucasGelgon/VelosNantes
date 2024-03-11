/**
 * @author clemence, ronan, lucas
 * This class represents the different streets
 */
package velo;
import java.util.*;
public class Quartier{
    
    //attributs de la classe
    private int idQuartier;
    private String nomQuartier;
    private double lgPisteCyclable;
    private ArrayList<Compteur> listCpt;
    
    /**
     * Constructor of Quartier 
     * @param idQ : int, represents the id of the Quartier
     * @param nomQ : String, represents the name of the Quartier
     * @param longueur : double, reprensents the length, in meters of the riding pist in the Quartier
     * @param liste : ArrayList<Compteur>, the list that has all the Compteur of the Quartier
     */
     public Quartier(int idQ, String nomQ, double longueur, ArrayList<Compteur> liste){
         if(idQ>0){
             this.idQuartier = idQ;
         }else{ 
             this.idQuartier = 0;
             System.out.println("Error : invalid param");
         }
         if(nomQ != null){
             this.nomQuartier = nomQ;
         }else{
             System.out.println("Error : invalid param");
             this.nomQuartier = "Default";
         }
         if(longueur > 0.0){
             this.lgPisteCyclable = longueur;
         }
         else{
             System.out.println("Error : invalid param");
             this.lgPisteCyclable = 0.0;
         }
         if(liste != null){
             this.listCpt = liste;
         }else{
             this.listCpt = new ArrayList<Compteur>();
             System.out.println("Error : invalid param");
         }
    }
    
    
    /**
     * get the id of the Quartier
     * @return int
     */
     public int getIdQuartier(){
         return this.idQuartier;
     }
     
     /**
      * get the name of the Quartier
      * @return String
      */
      public String getNomQuartier(){
          return this.nomQuartier;
      }
      
      /**
       * get the length of riding pists of the Quartier
       * @return double
       */
       public double getLongueurPiste(){
           return this.lgPisteCyclable;
       }
       
       /**
        * get the list of Compteur in the Quartier
        * @return ArrayList<Compteur>
        */
        public ArrayList<Compteur> getListeCpt(){
            return this.listCpt;
        }
        
        /**
         * set the id of the Quartier
         * @param newId : int
         */
        public void setIdQuartier(int newId){
            if(newId >0){
                this.idQuartier = newId;
            }else{
                System.out.println("Error : invalid param");
            } 
        }
        
        /**
         * set the name of the Quartier
         * @param newName : String
         */
        public void setNomQuartier(String newName){
            if(newName != null){
                this.nomQuartier = newName;
            }else{
                System.out.println("Error : invalid param");
            } 
        }
        
        /**
         * set the length of riding pist of the Quartier
         * @param newlg : double
         */
        public void setlgPiste(double newlg){
            if(newlg >0.0){
                this.lgPisteCyclable = newlg;
            }else{
                System.out.println("Error : invalid param");
            } 
        }
        
        /**
         * set the list of Compteur of the Quartier
         * @param newCpt : ArrayList<Compteur>
         */
        public void setLisCpt(ArrayList<Compteur> newCpt){
            if(newCpt != null){
                this.listCpt = newCpt;
            }else{
                System.out.println("Error : invalid param");
            } 
        }
        
        /**
         * this method allows to add a Compteur in the ArrayList
         * @param cpt : Compteur
         */
        public void addCpt(Compteur cpt){
            if(cpt != null){
                this.listCpt.add(cpt);
            }else{
                System.out.println("Error : invalid param");
            }
        }
        
        /**
         * this method allows to drop a Compteur from the ArrayList
         * @param ind : int, the index of the element to drop
         */
        public void dropCpt(int ind){
            if(ind<= this.listCpt.size()){
                this.listCpt.remove(ind);
            }
            else{
                System.out.println("Error : invalid param");
            }
        }
        
        /**
         * it allows to pass from meters to kms the length of riding pists of the Quartier
         * @return double
         */
         public double toKm(){
             double ret;
             ret = this.lgPisteCyclable/1000;
             return ret;
         }
         
         /**
          * returns the number of Compteurs wich are in the Quartier
          * @return int
          */
          public int nbCompteurs(){
              return this.listCpt.size();
          }
          
          /**
           * this method returns a string that describes the Quartier
           * @return string
           */
           public String toString(){
               String ret = "";
               ret = "Ce quartier porte l'identifiant : "+ getIdQuartier() + ", \n  Son nom est : " + getNomQuartier() + ", \n Il contient "+getLongueurPiste() + "mètres de piste cyclabes, \n" + "Soit : " + toKm()+ "km. \n Et les compteurs suivants : \n";
               for (int i =0; i<this.getListeCpt().size(); i++){
                   ret = ret + this.getListeCpt().get(i).toString() + "\n";
               }
               return ret;
          }
        
        
        
}
