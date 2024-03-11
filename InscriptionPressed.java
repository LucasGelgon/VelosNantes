//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InscriptionPressed extends JPanel {
    private JPanel panel;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    //ajout d'un blankLabel pour la mise en page
    private JLabel blankLabel;
    private JLabel consigne;
    private JLabel nom;
    private JLabel prenom;
    private JLabel age;
    private JLabel mail;
    private JLabel phone;
    private JLabel motdp;

    // Les Boutons
    private JButton inscription;
    
    //les champs de texte
    private JTextField leNom;
    private JTextField lePrenom;
    private JTextField lAge;
    private JTextField leMail;
    private JTextField lePhone;
    private JPasswordField mdp;

    
    public InscriptionPressed(InscriptionPressedListener l) {
        this.initComponents(l);
        
    }

    private void initComponents(InscriptionPressedListener l) {
        
        //Ici, on initialise tous les labels
        blankLabel = new JLabel();
        nom = new JLabel();
        prenom = new JLabel();
        age = new JLabel();
        mail = new JLabel();
        phone = new JLabel();
        consigne = new JLabel();
        motdp = new JLabel();
        motdp.setText("Mot de passe");
        nom.setText("Nom");
        prenom.setText("Prénom");
        age.setText("Age");
        mail.setText("Adresse Mail");
        phone.setText("Numéro Téléphone (portable)");
        consigne.setText("Renseigner les champs ci-dessous");
        
        //Ici, on initialise les textFields
        mdp = new JPasswordField();
        leNom = new JTextField();
        lePrenom = new JTextField();
        lAge = new JTextField();
        leMail = new JTextField();
        lePhone = new JTextField();
        
        
        
        // Ici on ajoute les boutons 
        this.inscription = new JButton();
        inscription.setText("Inscription");
        inscription.addActionListener(l);
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.add(consigne);
        p2.setLayout(new GridLayout(10,2));
        p2.add(nom);
        p2.add(prenom);
        p2.add(leNom);
        p2.add(lePrenom);
        p2.add(age);
        p2.add(blankLabel);
        p2.add(lAge);
        p2.add(blankLabel);
        p2.add(mail);
        p2.add(blankLabel);
        p2.add(leMail);
        p2.add(blankLabel);
        p2.add(phone);
        p2.add(blankLabel);
        p2.add(lePhone);
        p2.add(blankLabel);
        p2.add(motdp);
        p2.add(blankLabel);
        p2.add(mdp);
        p3.add(inscription);
        panel.setLayout(new GridLayout(6,1));
        panel.add(p1);
        panel.add(blankLabel);
        panel.add(p2);
        panel.add(blankLabel);
        panel.add(p3);
        panel.add(blankLabel);
        add(panel);
    }
    
    public String getLeNom(){
        return this.leNom.getText();
    }
    
    public String getLePrenom(){
        return this.lePrenom.getText();
    }
    
    public String getLAge(){
        return this.lAge.getText();
    }
    
    public String getLeMail(){
        return this.leMail.getText();
    }
    
    public String getLePhone(){
        return this.lePhone.getText();
    }
    
    public JButton getInscription(){
        return this.inscription;
    }
}
