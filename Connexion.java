//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Connexion extends JPanel {
    private JPanel panel;
    
    //ajout d'un blankLabel pour la mise en page
    private JLabel blankLabel;

    // Les Boutons
    private JButton connexion;
    private JButton inscription;


    public Connexion(ConnexionListener l) {
        this.initComponents(l);
        
    }

    private void initComponents(ConnexionListener l) {
        
        // Ici on ajoute les boutons 

        this.connexion = new JButton();
        connexion.setText("Connexion");
        connexion.addActionListener(l);
        this.inscription = new JButton();
        inscription.setText("S'inscrire");
        inscription.addActionListener(l);
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.blankLabel = new JLabel();
        this.panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(connexion);
        panel.add(blankLabel);
        panel.add(inscription);

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
}
