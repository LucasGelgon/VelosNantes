import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class ConnexionPressedListener implements ActionListener {

    private Vue vue;
    
    public ConnexionPressedListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getCo().getInscription()){
            vue.getFrame().getP2().remove(vue.getCo());
            vue.getFrame().setP2(vue.getInscri());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getCo().getConnexion()){
            vue.getFrame().getP2().remove(vue.getCo());
            vue.getFrame().setP2(vue.getAcc());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getCo().getMdpOublie()){
            vue.getFrame().getP2().remove(vue.getCo());
            vue.getFrame().setP2(vue.getInscri());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }
    }

}
