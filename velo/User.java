/**
 * @author clemence, ronan, lucas
 * This class represents the user who are registred in the DB
 */
package velo;

import java.util.*;

    
public class User{
    
    //attributs of the class
    private String nom;
    private String prenom;
    private int age;
    private String mail;
    private int tel;
    private String mdp;
    private HashMap<String,String> identifiant;


    /**
     * Constructs a User object with the specified attributes.
     *
     * @param nom                Name of the user
     * @param prenom             First name of the user
     * @param age                Age of the user
     * @param mail               Email adress of the user, also the Id for a connection
     * @param tel                phone nulber of a user
     * @param mdp                password of the user, will be the security for the connection
     */
    public User(String nom, String prenom, int age, String mail, int tel, String mdp)throws RuntimeException {
        if (nom != null){
            this.nom = nom;
        }
        else{
            throw new RuntimeException("invalid param : nom");
        }
        if(prenom != null){
            this.prenom = prenom;
        }else{
            throw new RuntimeException("invalid param : prenom");
        }
        if(age <=13 ){
            this.age = age;
        }else{
            throw new RuntimeException("invalid param : age : il faut avoir 13 ans minimum pour créer un compte");
        }
        if(mail != null){
            this.mail = mail;
        }else{
            throw new RuntimeException("invalid param : mail");
        }
        if(tel < 0){
            this.tel = tel;
        }else{
            throw new RuntimeException("invalid param : Numéro de téléphone");
        }
        if(mdp != null){
            this.mdp = mdp;
        }else{
            throw new RuntimeException("invalid param : Mot de passe");

        }
        if(mdp !=null && mail !=null){
            identifiant = new HashMap<String,String>();
            identifiant.put(mail, mdp);
        }else{
            throw new RuntimeException("invalide param : nous ne pouvons pas créer de compte car le mail ou le mot de passe est invalide");
        }
    }
    
   
   /**
     * get the Name of the user
     * @return String
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * get the firstname of the user
     * @return String
     */
     public String getPrenom(){
         return this.prenom;
     }
     
     /**
      * get the age for the user
      * @return int
      */
      public int getAge(){
          return this.age;
      }
      
      /**
       * get the mail of the user
       *@return String
       */
       public String getMail(){
           return this.mail;
       }
       
     /**
       * get the tel of the user
       *@return int
       */
       public int getTel(){
           return this.tel;
       }
       
     /**
       * get the mdp of the user
       *@return String
       */
       public String getMdp(){
           return this.mdp;
       }
       
       /**
         * set the name of the user
         * @param name : String
         */
       public void setNom(String name)throws RuntimeException{
           if (name != null){
            this.nom = name;
        }
        else{
            throw new RuntimeException("invalid param : name");
        }
     }
     
       /**
         * set the cprenom of the user
         * @param prenom : String
         */
       public void setPrenom(String prenom)throws RuntimeException{
           if (prenom != null){
            this.prenom = prenom;
        }
        else{
            throw new RuntimeException("invalid param : prenom");
        }
      }
      
        /**
         * set the age of the user
         * @param age : int
         */
       public void setAge(int age)throws RuntimeException{
           if (age <= 13){
            this.age = age;
        }
        else{
            throw new RuntimeException("invalid param : age");
        }
     }
     
     
       /**
         * set the mail of the user
         * @param mail : String
         */
       public void setMail(String mail)throws RuntimeException{
           if (mail != null){
            this.mail = mail;
        }
        else{
            throw new RuntimeException("invalid param : mail");
        }
     }
     
     /**
         * set the tel of the user
         * @param tel: int
         */
       public void setTel(int tel)throws RuntimeException{
           if (tel <= 0){
            this.tel = tel;
        }
        else{
            throw new RuntimeException("invalid param : tel");
        }
     }
     
     /**
         * set the mdp of the user
         * @param mail : String
         * @param mdp: String
         */
       public void setMdp(String mail, String mdp)throws RuntimeException{
           if(this.existe(mail)){
                if (mdp !=null){
                    this.mdp= mdp;
                    identifiant.replace(mail, mdp);
                }
           }
           else{
            throw new RuntimeException("invalid param : mdp");
        }
     }
     
     
     /**
      * method that connects if the email adress is correct and the mdp as well
      * @param String mail
      * @param String mdp
      * @return boolean
      */
      public boolean connexion(String  mail, String mdp){
        boolean ret = false;
        if(mail != null){
             if(this.identifiant.containsKey(mail)){
                 if(this.identifiant.get(mail).equals(mdp)){
                     ret = true;
                 }
            }
        }else{
            System.out.println("Error : invalid parametre");
        }
        return ret;
    }
    
    /**
     * methods that check if the user exist or not
     * @param String mail
     * @return boolean
     */
     public boolean existe(String mail){
         boolean ret = false;
         if(mail !=null){
             if (this.identifiant.containsKey(mail)){
                 ret = true;
             }
        }
        return ret;
    }
        
}
