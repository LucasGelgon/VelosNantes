import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class InscriptionPressedListener implements ActionListener {

    private Vue vue;
    
    public InscriptionPressedListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getInscri().getInscription()){
            vue.getFrame().getP2().remove(vue.getInscri());
            vue.getFrame().setP2(vue.getCo());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
            vue.add(vue.getPanel());
        }
    }

}
