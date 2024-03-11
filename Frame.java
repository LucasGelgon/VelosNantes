import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame extends JPanel {
    private JPanel panel;//borderlayout, contient l'intégralité de la page à ajouter a la frame
    private JPanel p1;
    private JPanel p2;

    
    private BufferedImage image;   
    private BufferedImage logo;

    private JLabel imContainer;
    private JLabel logoContainer;
    

    // Les Boutons
    private JButton deconnexion;


    public Frame(FrameListener l) {
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
 

    private void initComponents(FrameListener l) {
        
        // Ici on ajoute les boutons 

        this.deconnexion = new JButton();
        deconnexion.setText("Déconnexion");
        deconnexion.addActionListener(l);

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
        

        this.panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        logoContainer = new JLabel();
        logoContainer.setIcon(logoNantes);
        imContainer = new JLabel();
        imContainer.setIcon(photo);
        p1.setLayout(new GridLayout(1,3));
        p1.add(imContainer);
        p1.add(logoContainer);
        p1.add(deconnexion);
        //p2.setColor(GREY);//#BFBFBF);

        
        panel.setLayout(new BorderLayout());
        panel.add(p1, BorderLayout.NORTH);
        panel.add(p2, BorderLayout.SOUTH);
        add(panel);
    }
    
    
    public JButton getDeconnexion(){
        return this.deconnexion;
    }

    public JPanel getP2(){
        return this.p2;
    }
    
    public void setP2(JPanel ajout){
        this.p2.add(ajout);
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
}

