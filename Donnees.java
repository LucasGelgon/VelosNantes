//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import velo.*;

public class Donnees extends JPanel {
    private JPanel panel;//borderlayout, contient l'intégralité de la page à ajouter a la frame
    private JPanel p1;//contient lignes de velos + deconnexion
    private JPanel p2;//contient les 4 blocs en dessous
    private JPanel p3;//contient p1 et p2, placé en north
    private JPanel p4;//contient le tableau, placé en center
    private JPanel p5; // contient le reste, place en south
    
    
    //ajout d'un blankLabel pour la mise en page
    private JLabel blankLabel;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel entete;
    private JLabel logoContainer;
    
    private BufferedImage logo;


    // Les Boutons
    private JButton deconnexion;
    private JComboBox<JourSemaine> jour;
    private JComboBox<Heure> heure;
    private JButton retour;
    
    //les labels vides qui seront remplis à la demande de l'utilisateur
    private JLabel tl1;
    private JLabel tl2;
    private JLabel tl3;
    private JLabel tl4;
    

    public Donnees(DonneesListener l) {
        this.initComponents(l);
        
    }
    
    
            /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(String inputImagePath,String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
 

    private void initComponents(DonneesListener l) {
        
        // Ici on ajoute les boutons 

        this.deconnexion = new JButton();
        deconnexion.setText("Déconnexion");
        deconnexion.addActionListener(l);
        this.heure = new JComboBox<Heure>(
        Heure.values());
        heure.addActionListener(l);
        this.jour = new JComboBox<JourSemaine>(
        JourSemaine.values());
        jour.addActionListener(l);
        this.retour= new JButton();
        retour.setText("RETOUR");
        retour.addActionListener(l);
        
        
        //ici on ajoute le logo
        try{logo = ImageIO.read(new File("../logo.png"));}
        catch(IOException e){System.out.println(e);}
        int width = 200;
        int height = 50;
        try{resize("../logo.png", "../logo.png", width, height);}
        catch(IOException e){System.out.println(e);}
        try{logo = ImageIO.read(new File("../logo.png"));}
        catch(IOException e){System.out.println(e);}
        ImageIcon logoNantes = new ImageIcon(logo);
        
        logoContainer = new JLabel();
        logoContainer.setIcon(logoNantes);
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.blankLabel = new JLabel();
        tl1 = new JLabel();
        tl2 = new JLabel();
        tl3 = new JLabel();
        tl4 = new JLabel();
        l1 = new JLabel();
        l1.setText("Donnée 1");
        l2 = new JLabel();
        l2.setText("Donnée 2 ");
        l3 = new JLabel();
        l3.setText("Donnée 3");
        l4 = new JLabel();
        l4.setText("...");
        entete = new JLabel();
        entete.setText("DONNEES TECHNIQUES");
        this.panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.add(logoContainer);
        p1.add(entete);
        p1.add(deconnexion);
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(jour);
        p2.add(heure);
        p3.setLayout(new GridLayout(2,1));
        p3.add(p1);
        p3.add(p2);
        p4.setLayout(new GridLayout(4,2));
        p4.add(l1);
        p4.add(tl1);
        p4.add(l2);
        p4.add(tl2);
        p4.add(l3);
        p4.add(tl3);
        p4.add(l4);
        p4.add(tl4);
        p5.setLayout(new GridLayout(1,3));
        p5.add(blankLabel);
        p5.add(blankLabel);
        p5.add(retour);
        
        panel.setLayout(new BorderLayout());
        panel.add(p3, BorderLayout.NORTH);
        panel.add(p4, BorderLayout.CENTER);
        panel.add(p5, BorderLayout.SOUTH);
        add(panel);
    }
    
    
    public JButton getDeconnexion(){
        return this.deconnexion;
    }
    
    public JComboBox getJour(){
        return this.jour;
    }
    
    public JComboBox getHeure(){
        return this.heure;
    }
    
    
    public JButton getRetour(){
        return this.retour;
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
}
