//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ConnexionPressed extends JPanel {
    private JPanel panel;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    //ajout d'un blankLabel pour la mise en page
    private JLabel blankLabel;
    private JLabel consigne;
    private JLabel mail;
    private JLabel mdp;
    

    // Les Boutons
    private JButton inscription;
    private JButton connexion;
    private JButton mdpOublie;
    
    //les champs de texte
    private JTextField leMail;
    private JPasswordField leMdp;

    
    
    public ConnexionPressed(ConnexionPressedListener l) {
        this.initComponents(l);
        
    }

    private void initComponents(ConnexionPressedListener l) {
        
        //Ici, on initialise tous les labels
        blankLabel = new JLabel();
        mail = new JLabel();
        mdp = new JLabel();
        consigne = new JLabel();
        
    
        mail.setText("Adresse Mail");
        mdp.setText("Mot de passe");
        consigne.setText("Renseigner les champs ci-dessous");
        
        //Ici, on initialise les textFields
        
        leMail = new JTextField();
        leMdp = new JPasswordField();
        
        
        
        // Ici on ajoute les boutons 
        this.inscription = new JButton();
        inscription.setText("Inscription");
        inscription.addActionListener(l);
        this.connexion= new JButton();
        connexion.setText("Connexion");
        connexion.addActionListener(l);
        this.mdpOublie= new JButton();
        mdpOublie.setText("Mot de passe oublié ?");
        mdpOublie.addActionListener(l);
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.add(consigne);
        p2.setLayout(new GridLayout(6,1));
        p2.add(mail);
        p2.add(leMail);
        p2.add(blankLabel);
        p2.add(mdp);
        p2.add(leMdp);
        p2.add(mdpOublie);
        p3.add(connexion);
        p4.add(inscription);
        panel.setLayout(new GridLayout(8,1));
        panel.add(p1);
        panel.add(blankLabel);
        panel.add(p2);
        panel.add(blankLabel);
        panel.add(p3);
        panel.add(blankLabel);
        panel.add(p4);
        panel.add(blankLabel);
        add(panel);
    }
    
    
    public JButton getConnexion(){
        return this.connexion;
    }
    
    public JButton getInscription(){
        return this.inscription;
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
    
    public JButton getMdpOublie(){
        return this.mdpOublie;
    }
}
