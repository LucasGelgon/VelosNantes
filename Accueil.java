//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Accueil extends JPanel {
    private JPanel panel;
    
    //ajout d'un blankLabel pour la mise en page
    private JLabel blankLabel;

    // Les Boutons
    private JButton deconnexion;
    private JButton lignes;
    private JButton donnees;
    private JButton ville;
    private JButton contact;
    


    public Accueil(AccueilListener l) {
        this.initComponents(l);
        
    }

    private void initComponents(AccueilListener l) {
        
        // Ici on ajoute les boutons 

        this.deconnexion = new JButton();
        deconnexion.setText("Déconnexion");
        deconnexion.addActionListener(l);
        this.lignes = new JButton();
        lignes.setText("LIGNES VELO");
        lignes.addActionListener(l);
        this.donnees = new JButton();
        donnees.setText("DONNEES");
        donnees.addActionListener(l);
        this.ville = new JButton();
        ville.setText("LA VILLE");
        ville.addActionListener(l);
        this.contact = new JButton();
        contact.setText("CONTACT");
        contact.addActionListener(l);
        
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.blankLabel = new JLabel();
        this.panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(lignes);
        panel.add(donnees);
        panel.add(ville);
        panel.add(contact);

        add(panel);
    }
    
    
    public JButton getDeconnexion(){
        return this.deconnexion;
    }
    
    public JButton getLignes(){
        return this.lignes;
    }
    
    public JButton getDonnees(){
        return this.donnees;
    }
    
    public JButton getVille(){
        return this.ville;
    }
    
    public JButton getContact(){
        return this.contact;
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
}
