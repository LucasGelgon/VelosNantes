//package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Contact extends JPanel {
    private JPanel panel;//borderlayout, contient l'intégralité de la page à ajouter a la frame
    private JPanel p1;//contient le texte en haut a gauche
    private JPanel p2;//contient deconnexion et le logo
    private JPanel p3;//contient p1(west) et p2(east), placé en north
    private JPanel p4;//contient l image
    private JPanel p5; // contient le reste
    private JPanel p6;//contient p4(west) et p5(east), placé en south
    
    private BufferedImage image;   
    private BufferedImage logo;
    //ajout d'un blankLabel pour la mise en page
    private JLabel blankLabel;
    private JLabel texte1;
    private JLabel texte2;
    private JLabel texte3;
    private JLabel consigne;
    private JLabel imContainer;
    private JLabel logoContainer;
    

    // Les Boutons
    private JButton deconnexion;
    private JButton retour;
    

    public Contact(ContactListener l) {
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
 

    private void initComponents(ContactListener l) {
        
        // Ici on ajoute les boutons 

        this.deconnexion = new JButton();
        deconnexion.setText("Déconnexion");
        deconnexion.addActionListener(l);
        this.retour= new JButton();
        retour.setText("RETOUR");
        retour.addActionListener(l);
        
        try{image = ImageIO.read(new File("../nantes.jpeg"));}
        catch(IOException e){System.out.println(e);}
        ImageIcon photo = new ImageIcon(image);
        
        
        try{logo = ImageIO.read(new File("../logo.png"));}
        catch(IOException e){System.out.println(e);}
        int width = 200;
        int height = 50;
        try{resize("../logo.png", "../logo.png", width, height);}
        catch(IOException e){System.out.println(e);}
        try{logo = ImageIO.read(new File("../logo.png"));}
        catch(IOException e){System.out.println(e);}
        ImageIcon logoNantes = new ImageIcon(logo);
        
        // Ici on ajoute le panel et les deux boutons au panel
        this.blankLabel = new JLabel();
        texte1 = new JLabel();
        texte3 = new JLabel();
        texte2 = new JLabel();
        texte1.setText("Contacts : @...Ronan");
        texte2.setText("                    @...Clémence");
        texte3.setText("                    @...Lucas");
        
        this.panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(texte1);
        p1.add(texte2);
        p1.add(texte3);
        p2.setLayout(new GridLayout(1,2));
        logoContainer = new JLabel();
        logoContainer.setIcon(logoNantes);
        p2.add(logoContainer);
        p2.add(deconnexion);
        p3.setLayout(new GridLayout(1,2));
        p3.add(p1);
        p3.add(p2);
        p4.setLayout(new GridLayout(1,1));
        imContainer = new JLabel();
        imContainer.setIcon(photo);
        p4.add(imContainer);
        p5.setLayout(new GridLayout(1,1));
        p5.add(retour);
        p6.setLayout(new GridLayout(1,2));
        p6.add(p4);
        p6.add(p5);
        
        panel.setLayout(new BorderLayout());
        panel.add(p3, BorderLayout.NORTH);
        panel.add(p6, BorderLayout.SOUTH);
        add(panel);
    }
    
    
    public JButton getDeconnexion(){
        return this.deconnexion;
    }
     
    
    public JButton getRetour(){
        return this.retour;
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
}
