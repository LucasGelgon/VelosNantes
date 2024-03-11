import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class AccueilListener implements ActionListener {

    private Vue vue;
    
    public AccueilListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getAcc().getLignes()){
            vue.getPanel().remove(vue.getFrame());
            vue.getPanel().add(vue.getLignes());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getAcc().getDonnees()){
            vue.getPanel().remove(vue.getFrame());
            vue.getPanel().add(vue.getDonnees());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getAcc().getVille()){
            vue.getPanel().remove(vue.getFrame());
            vue.getPanel().add(vue.getVille());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getAcc().getContact()){
            vue.getPanel().remove(vue.getFrame());
            vue.getPanel().add(vue.getContact());
            vue.add(vue.getPanel());
        }
    }

}
