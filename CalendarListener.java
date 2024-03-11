import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class CalendarListener implements KeyListener {

    private CalendarView calendarView;
    private Calendar calendrier;

    public CalendarListener(CalendarView calendarView) {
        this.calendarView = calendarView;
        this.calendrier = new Calendar();
        updateCalendarView();
    }

    public Calendar getCalendar() {
        return this.calendrier;
    }

    private void updateCalendarView() {
        calendarView.getNomJour().setText(calendrier.getDayName());
        calendarView.getNumJour().setText(Integer.toString(calendrier.getDayNumber()));
        calendarView.getMois().setSelectedIndex(calendrier.getMonthNumber() - 1);
        calendarView.getNumAnnee().setText(Integer.toString(calendrier.getYear()));
    }

    public void keyPressed(KeyEvent k) {
        switch (k.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                calendrier.previousDay();
                break;
            case KeyEvent.VK_RIGHT:
                calendrier.nextDay();
                break;
        }
        updateCalendarView(); 
    }

    public void keyTyped(KeyEvent k) {
    }

    public void keyReleased(KeyEvent k) {
    }

    public void updateCalendarMonth(int monthIndex) {
        calendrier.setMonth(monthIndex + 1);
        updateCalendarView();
	}
}
