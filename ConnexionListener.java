import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class ConnexionListener implements ActionListener {

    private Vue vue;
    
    public ConnexionListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getConnexion().getConnexion()){
            vue.getFrame().getP2().remove(vue.getConnexion());
            vue.getFrame().setP2(vue.getCo());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }else if(paramActionEvent.getSource() == vue.getConnexion().getInscription()){
            vue.getFrame().getP2().remove(vue.getConnexion());
            vue.getFrame().setP2(vue.getInscri());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }
    }

}
