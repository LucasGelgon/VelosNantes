import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class LignesListener implements ActionListener {

    private Vue vue;
    
    public LignesListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getLignes().getDeconnexion()){
            vue.getPanel().remove(vue.getLignes());
            vue.getFrame().getP2().remove(vue.getAcc());
            vue.getFrame().setP2(vue.getConnexion());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getLignes().getNumRoute()){
            //combobox avec les noms quartier 
            vue.getPanel().add(vue.getDonnees());//afficher les compteurs de ce quartier
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getLignes().getHeure()){
            vue.getPanel().add(vue.getVille());//afficher le nbe velo comptés a cette heure pour chaque compteur affiché
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getLignes().getDate()){
            vue.getPanel().add(vue.getCalendar());//afficher le nbe vélos a la date 
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getLignes().getRetour()){
            vue.getPanel().remove(vue.getLignes());
            vue.getFrame().setP2(vue.getAcc());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }
    }

}
