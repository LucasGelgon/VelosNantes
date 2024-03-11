package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import velo.*;

public class JourDAO {

    private Connection connection;

    public JourDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Insère un nouvel objet Jour dans la base de données.
     *
     * @param jour L'objet Jour à insérer.
     * @throws SQLException en cas d'erreur lors de l'insertion.
     */
    public void insert(Jour jour) throws SQLException {
        String query = "INSERT INTO jours (date, temperature_moyenne, jour_semaine, vacances, heures) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setObject(1, jour.getDate());
        statement.setDouble(2, jour.getTemperatureMoyenne());
        statement.setString(3, jour.getJourSemaine());
        statement.setString(4, jour.getVacances());
        statement.setString(5, jour.getHeures().toString());
        statement.executeUpdate();
    }

    /**
     * Récupère tous les objets Jour à partir de la base de données.
     *
     * @return Une liste d'objets Jour.
     * @throws SQLException en cas d'erreur lors de la récupération.
     */
    public List<Jour> getAll() throws SQLException {
        String query = "SELECT * FROM jours";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Jour> jours = new ArrayList<>();
        while (resultSet.next()) {
            LocalDate date = resultSet.getObject("date", LocalDate.class);
            double temperatureMoyenne = resultSet.getDouble("temperature_moyenne");
            String jourSemaine = resultSet.getString("jour_semaine");
            String vacances = resultSet.getString("vacances");
            String heuresStr = resultSet.getString("heures");
            int[] heures = parseHeures(heuresStr);

            Jour jour = new Jour(date, temperatureMoyenne, jourSemaine, vacances, heures);
            jours.add(jour);
        }

        return jours;
    }

    /**
     * Parse une chaîne de caractères représentant les heures en un tableau d'entiers.
     *
     * @param heuresStr La chaîne de caractères représentant les heures.
     * @return Un tableau d'entiers représentant les heures.
     */
    private int[] parseHeures(String heuresStr) {
        String[] heuresArr = heuresStr.replaceAll("\\[|\\]", "").split(", ");
        int[] heures = new int[heuresArr.length];
        for (int i = 0; i < heuresArr.length; i++) {
            heures[i] = Integer.parseInt(heuresArr[i]);
        }
        return heures;
    }
}