import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class VilleListener implements ActionListener {

    private Vue vue;
    
    public VilleListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getVille().getDeconnexion()){
            vue.getPanel().remove(vue.getVille());
            vue.getFrame().getP2().remove(vue.getAcc());
            vue.getFrame().setP2(vue.getConnexion());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getVille().getLignes()){
            vue.getPanel().remove(vue.getVille());
            vue.getPanel().add(vue.getLignes());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getVille().getRetour()){
            vue.getPanel().remove(vue.getVille());
            vue.getFrame().setP2(vue.getAcc());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }
    }

}
