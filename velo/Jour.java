package velo;

import java.util.*;
import java.time.LocalDate;

/**
 * Class representing a day with its attributes such as date, average temperature, day of the week,
 * vacation status, and hours.
 */
public class Jour {

    private LocalDate date;
    private double temperatureMoyenne;
    private String joursemaine;
    private String vacances;
    private int[] heures;

    /**
     * Constructs a Jour object with the specified attributes.
     *
     * @param date               The date of the day.
     * @param temperatureMoyenne The average temperature of the day.
     * @param jourSemaine        The day of the week.
     * @param vacances           The vacation status of the day.
     * @param heures             The hours of the day.
     */
    public Jour(LocalDate date, double temperatureMoyenne, String jourSemaine, String vacances, int[] heures) {
        this.setDate(date);
        this.setTemperatureMoyenne(temperatureMoyenne);
        this.setJourSemaine(jourSemaine);
        this.setVacances(vacances);
        this.setHeures(heures);
    }

    /**
     * Returns the date of the day.
     *
     * @return The date of the day.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the average temperature of the day.
     *
     * @return The average temperature of the day.
     */
    public double getTemperatureMoyenne() {
        return temperatureMoyenne;
    }
    
    /**
     * Returns the day of the week.
     *
     * @return The day of the week.
     */
    public String getJourSemaine() {
        return joursemaine;
    }

    /**
     * Returns the vacation status of the day.
     *
     * @return The vacation status of the day.
     */
    public String getVacances() {
        return vacances;
    }

    /**
     * Returns the hours of the day.
     *
     * @return The hours of the day.
     */
    public int[] getHeures() {
        return heures;
    }

    /**
     * Sets the date of the day.
     *
     * @param date The date to set.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Sets the average temperature of the day.
     *
     * @param temperatureMoyenne The average temperature to set.
     */
    public void setTemperatureMoyenne(double temperatureMoyenne) {
        this.temperatureMoyenne = temperatureMoyenne;
    }
    
    /**
     * Sets the day of the week.
     *
     * @param The day of the week.
     */
    public void setJourSemaine(String joursemaine) throws RuntimeException {
        this.joursemaine = joursemaine;
    }
    
    /**
     * Sets the hours
     *
     * @param The hours.
     */
    public void setHeures(int[] heures) {
		this.heures = heures;
	}
	
    /**
     * Sets the holidays.
     *
     * @param The holidays.
     */
    public void setVacances(String vacances) throws RuntimeException {
        this.vacances = vacances;
    }
    


    /**
     * Returns the string representation of the Jour object.
     *
     * @return The string representation of the Jour object.
     */
    public String toString() {
        return "Jour{" +
                "date=" + this.getDate() +
                ", temperatureMoyenne=" + this.getTemperatureMoyenne() +
                ", jourSemaine=" + this.getJourSemaine() +
                ", vacances=" + this.getVacances() +
                ", heures=" + Arrays.toString(this.getHeures()) +
                '}';
    }
	/**
     * Checks if the given date is during the school vacation in Zone B (France) for any year.
     *
     * @param date The date to check.
     * @return True if the date is during the school vacation, false otherwise.
     */
    public boolean estVacances(LocalDate date) {
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		boolean ret = false;

		// Check if the date is during the school vacation in Zone B (France)
		if (month == 7 || month == 8) {
			ret = true; // Summer vacation
		} else if (month == 4 && day >= 8 && day <= 23) {
			ret = true; // Easter vacation
		} else if ((month == 2 && day >= 4) || (month == 3 && day <= 20)) {
			ret = true; // Winter vacation
		} else if ((month == 10 && day >= 21) || (month == 11 && day <= 6)) {
			ret = true; // Autumn vacation
		}

		return ret;
	}
	
	/**
	 * Checks if the day is a weekday (Monday to Friday).
	 *
	 * @return True if the day is a weekday, false otherwise.
	 */
	public boolean estWeekEnd() {
		boolean ret = false;
		if ((this.joursemaine == "Samedi") || (this.joursemaine == "Dimanche")) {
			ret = true;
		}
		return ret;
	}

		
}
	
	
