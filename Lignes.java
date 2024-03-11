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

enum Heure{
    H0, H1, H2, H3, H4, H5, H6, H7, H8, H9, H10, H11, H12, H13, H14, H15, H16, H17, H18, H19, H20, H21, H22, H23
}
enum JourSemaine {
	Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche
}
enum Vacances {
	Noel, Ascension, Hiver, Ete, Toussaint, Printemps
}

public class Lignes extends JPanel {
    private JPanel panel;//borderlayout, contient l'intégralité de la page à ajouter a la frame
    private JPanel p1;//contient lignes de velos + deconnexion
    private JPanel p2;//contient les 4 blocs en dessous
    private JPanel p3;//contient p1 et p2, placé en north
    private JPanel p4;//contient le tableau, placé en center
    private JPanel p5; // contient le reste, place en south
    
    private JProgressBar progress;
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
    private JButton numRoute;//a transformer en COmbobox contenant les nom quartiers
    private JComboBox<Heure> heure;
    private JComboBox<Vacances> vacances;
    private JButton date;
    private JButton retour;
    private JButton newLigne;
    
    //les labels vides qui seront remplis à la demande de l'utilisateur
    private JLabel tl1;
    private JLabel tl2;
    private JLabel tl3;
    private JLabel tl4;
    

    public Lignes(LignesListener l) {
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

    private void initComponents(LignesListener l) {
        progress = new JProgressBar(0,100);
        progress.setBounds(35,40,165,30);
        progress.setValue(0);
        progress.setStringPainted(true);
        add(progress);

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
        
        
        // Ici on ajoute les boutons 

        this.deconnexion = new JButton();
        deconnexion.setText("Déconnexion");
        deconnexion.addActionListener(l);
        this.numRoute= new JButton();
        numRoute.setText("Numéro route");
        numRoute.addActionListener(l);
        this.heure = new JComboBox<Heure>(
        Heure.values());
        heure.addActionListener(l);
        //heure.setText("Heure");
        this.date = new JButton();
        date.setText("Date");
        date.addActionListener(l);
        this.vacances= new JComboBox<Vacances>(
            Vacances.values()
        );
        vacances.addActionListener(l);
        //vacances.setText("Vacances");
        this.newLigne = new JButton();
        newLigne.setText("Nouvelle ligne de vélo");
        newLigne.addActionListener(l);
        this.retour= new JButton();
        retour.setText("RETOUR");
        retour.addActionListener(l);
        
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.blankLabel = new JLabel();
        tl1 = new JLabel();
        tl2 = new JLabel();
        tl3 = new JLabel();
        tl4 = new JLabel();
        l1 = new JLabel();
        l1.setText("Ligne 1");
        l2 = new JLabel();
        l2.setText("Ligne 2 ");
        l3 = new JLabel();
        l3.setText("Ligne 3");
        l4 = new JLabel();
        l4.setText("Ligne 4");
        entete = new JLabel();
        entete.setText("LIGNES DE VELOS");
        this.panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p1.setLayout(new GridLayout(1,3));
        p1.add(logoContainer);
        p1.add(entete);
        p1.add(deconnexion);
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.add(numRoute);
        p2.add(heure);
        p2.add(date);
        p2.add(vacances);
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
        p5.setLayout(new FlowLayout(FlowLayout.CENTER));
        p5.add(newLigne);
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
    
    public JButton getNewLigne(){
        return this.newLigne;
    }
    
    public JButton getNumRoute(){
        return this.numRoute;
    }
    
    public JComboBox getHeure(){
        return this.heure;
    }
    
    public JButton getDate(){
        return this.date;
    }
    
    public JComboBox getVacances(){
        return this.vacances;
    }
    
    public JButton getRetour(){
        return this.retour;
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
}
