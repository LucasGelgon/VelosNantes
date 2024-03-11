//package view;
import javax.swing.*;
import java.awt.BorderLayout;
public class Vue extends JFrame {

    private JPanel panel;

    private Connexion connexion;
    private CalendarView calendar;
    private InscriptionPressed inscri;
    private ConnexionPressed co;
    private Accueil acc;
    private Lignes lignes;
    private Donnees donnees;
    private Ville ville;
    private Contact contact;
    private ConnexionListener cl;
    private InscriptionPressedListener ipl;
    private ConnexionPressedListener cpl;
    private AccueilListener al;
    private LignesListener ll;
    private DonneesListener dl;
    private VilleListener vl;
    private ContactListener contactl;
    private Frame frame;
    private FrameListener fl;



    public Vue() {
        this.initComponents();
        
    }

    private void initComponents() {
        fl = new FrameListener(this);
        contactl = new ContactListener(this);
        vl = new VilleListener(this);
        ll = new LignesListener(this);
        dl = new DonneesListener(this);
        cl = new ConnexionListener(this);
        ipl = new InscriptionPressedListener(this);
        cpl = new ConnexionPressedListener(this);
        al = new AccueilListener(this);
        connexion = new Connexion(cl);
        inscri = new InscriptionPressed(ipl);
        co = new ConnexionPressed(cpl);
        acc = new Accueil(al);
        lignes = new Lignes(ll);
        donnees = new Donnees(dl);
        ville = new Ville(vl);
        contact = new Contact(contactl);
        calendar = new CalendarView();
        frame = new Frame(fl);
        panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        //panel.add(getConnexion(), BorderLayout.CENTER);
        //panel.add(getInscri(), BorderLayout.CENTER);
        //panel.add(getCo(), BorderLayout.CENTER);
       // panel.add(getAcc(), BorderLayout.CENTER);
        //panel.add(getVille());
        //panel.add(getContact());
        //panel.add(getDonnees());
         //panel.add(getLignes());
         //panel.add(getCalendar());
         getFrame().setP2(getConnexion());
         panel.add(getFrame());
        add(panel);
    }

    public Connexion getConnexion(){
       return this.connexion;
    }
    
    public Donnees getDonnees(){
        return this.donnees;
    }
    
    public Contact getContact(){
        return this.contact;
    }

    public InscriptionPressed getInscri(){
        return this.inscri;
    }

    public ConnexionPressed getCo(){
        return this.co;
    }
    
    public Accueil getAcc(){
       return this.acc;
    }
    
    public Lignes getLignes(){
        return this.lignes;
    }
    
    public Ville getVille(){
        return this.ville;
    }
    
    public JPanel getPanel(){
        return this.panel;
    }
    
    public CalendarView getCalendar(){
        return this.calendar;
    }
    
    public Frame getFrame(){
        return this.frame;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //JFrame frame = new JFrame("Vélos Nantes");
                
                Vue vue = new Vue();
                vue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                vue.pack();
                vue.setVisible(true);
                //frame.add(vue);
                //frame.pack();
                //frame.setVisible(true);

                vue.setFocusable(true);
                vue.requestFocusInWindow();
            }
        });
    }



}
