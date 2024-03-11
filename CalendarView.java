import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CalendarView extends JPanel {
    private JPanel panel;
    private JLabel nomJour;
    private JLabel numJour;
    private JComboBox<String> mois;
    private JLabel numAnnee;

    private CalendarListener calendarListener;
    private Calendar calendar;

    public JLabel getNomJour() {
        return this.nomJour;
    }

    public JLabel getNumJour() {
        return this.numJour;
    }

    public JComboBox<String> getMois() {
        return this.mois;
    }

    public JLabel getNumAnnee() {
        return this.numAnnee;
    }

    public CalendarListener getCalendarListener() {
        return this.calendarListener;
    }

    public CalendarView() {
        this.calendar = new Calendar();
        this.initComponents();
    }

    private void initComponents() {
        panel = new JPanel();
        this.nomJour = new JLabel();
        this.numJour = new JLabel();
        this.mois = new JComboBox<>(calendar.getMonthsNames());
        this.numAnnee = new JLabel();

        this.calendarListener = new CalendarListener(this);
        
        panel.setLayout(new GridLayout(1, 4));
        panel.add(nomJour);
        panel.add(numJour);
        panel.add(mois);
        panel.add(numAnnee);

        mois.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    calendarListener.updateCalendarMonth(mois.getSelectedIndex());
                }
            }
        });

        panel.addKeyListener(calendarListener);
        add(panel);

    }

}
