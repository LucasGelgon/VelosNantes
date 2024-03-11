import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class FrameListener implements ActionListener {

    private Vue vue;
    
    public FrameListener(Vue vue){
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent paramActionEvent) {
        if(paramActionEvent.getSource() == vue.getFrame().getDeconnexion()){
            vue.getFrame().getP2().remove(vue.getAcc());
            vue.getFrame().setP2(vue.getConnexion());
            vue.getPanel().add(vue.getFrame());
            vue.add(vue.getPanel());
        }
    }

}
