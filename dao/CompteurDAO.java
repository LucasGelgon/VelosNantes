package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import velo.Compteur;

import velo.*;

public class CompteurDAO {
    private Connection connection;

    public CompteurDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterCompteur(Compteur compteur) {
        PreparedStatement statement = null;

        try {
            String query = "INSERT INTO compteur (idCompteur, libelle, sens, longitude, latitude) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, compteur.getIdCompteur());
            statement.setString(2, compteur.getLibelle());
            statement.setString(3, compteur.getSens());
            statement.setDouble(4, compteur.getLongitude());
            statement.setDouble(5, compteur.getLatitude());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }

    public void supprimerCompteur(int idCompteur) {
        PreparedStatement statement = null;

        try {
            String query = "DELETE FROM compteur WHERE idCompteur = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, idCompteur);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(statement);
        }
    }

    public List<Compteur> obtenirTousLesCompteurs() {
        List<Compteur> compteurs = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT * FROM compteur";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idCompteur = resultSet.getInt("idCompteur");
                String libelle = resultSet.getString("libelle");
                String sens = resultSet.getString("sens");
                double longitude = resultSet.getDouble("longitude");
                double latitude = resultSet.getDouble("latitude");
                Compteur compteur = new Compteur(idCompteur, libelle, sens, longitude, latitude);
                compteurs.add(compteur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(resultSet);
            closeStatement(statement);
        }

        return compteurs;
    }

    private void closeStatement(PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}