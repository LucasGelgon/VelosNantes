import java.sql.Connection;
import java.sql.SQLException;
import dao.*;
import velo.*;

public class ConnexionFactoryTest {
    public static void main(String[] args) throws SQLException {
        testConnexionFactoryWithDAOs();
    }

    public static void testConnexionFactoryWithDAOs() throws SQLException {
        // Obtention d'une connexion à la base de données
        Connection connection = ConnexionFactory.getConnection();

        // Création des instances des DAOs en leur passant la connexion
        CompteurDAO compteurDAO = new CompteurDAO(connection);
        QuartierDAO quartierDAO = new QuartierDAO(connection);
        JourDAO jourDAO = new JourDAO(connection);
        UserDAO userDAO = new UserDAO(connection);

        // Utilisation des DAOs pour effectuer des opérations dans la base de données
        // ...

        // Fermeture de la connexion
        ConnexionFactory.closeConnection(connection);
    }
}