package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionFactory {
    private static final String URL = "jdbc:mysql://localhost/SAE_creation";
    private static final String USERNAME = "Ronan";      // Nom d'utilisateur
    private static final String PASSWORD = "SAE";       // Mot de passe

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static CompteurDAO createCompteurDAO() {
        try {
            Connection connection = getConnection();
            return new CompteurDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static QuartierDAO createQuartierDAO() throws SQLException {
        Connection connection = getConnection();
        return new QuartierDAO(connection);
    }
    
    public static JourDAO createJourDAO() throws SQLException {
        Connection connection = getConnection();
        return new JourDAO(connection);
    }
    
    public static UserDAO createUserDAO() throws SQLException {
        Connection connection = getConnection();
        return new UserDAO(connection);
    }
}