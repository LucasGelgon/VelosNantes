package dao;

import java.sql.*;
import velo.*;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void createUser(User user) {
        try {
            // Préparation de la requête SQL pour insérer un utilisateur dans la base de données
            String query = "INSERT INTO users (nom, prenom, age, mail, tel, mdp) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Remplissage des paramètres de la requête avec les attributs de l'utilisateur
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getMail());
            statement.setInt(5, user.getTel());
            statement.setString(6, user.getMdp());

            // Exécution de la requête d'insertion
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        User user = null;
        try {
            // Préparation de la requête SQL pour récupérer un utilisateur par son adresse e-mail
            String query = "SELECT * FROM users WHERE mail = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Remplissage du paramètre de la requête avec l'adresse e-mail
            statement.setString(1, email);

            // Exécution de la requête de sélection
            ResultSet resultSet = statement.executeQuery();

            // Vérification si un utilisateur a été trouvé
            if (resultSet.next()) {
                // Création d'un objet User avec les données du résultat de la requête
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");
                int tel = resultSet.getInt("tel");
                String mdp = resultSet.getString("mdp");

                user = new User(nom, prenom, age, email, tel, mdp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    // Autres méthodes pour mettre à jour et supprimer un utilisateur dans la base de données
    // ...

    public void closeConnection() {
        try {
            // Fermeture de la connexion à la base de données
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}