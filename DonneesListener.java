import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class DonneesListener implements ActionListener {

    private Vue vue;
    
    public DonneesListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getDonnees().getDeconnexion()){
            vue.getPanel().remove(vue.getDonnees());
            vue.getFrame().getP2().remove(vue.getAcc());
            vue.getFrame().setP2(vue.getConnexion());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getDonnees().getJour()){
            //SELECT * FROM Jour WHERE jour = jour.getSource   : JTable requetes dernier tp mysql
            vue.getPanel().add(vue.getDonnees());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getDonnees().getHeure()){
            //SELECT ... FROM ... WHERE jour = jour && heure = heure : requetes dernier tp mysql
            vue.getPanel().add(vue.getVille());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getDonnees().getRetour()){
            vue.getPanel().remove(vue.getDonnees());
            vue.getFrame().setP2(vue.getAcc());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }
    }

}
