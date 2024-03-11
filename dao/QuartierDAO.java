package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import velo.*;

public class QuartierDAO {
    
    private List<Quartier> quartiers;
    private Connection connection;

    public QuartierDAO(Connection connection) {
        this.connection = connection;
    }
    
    public QuartierDAO() {
        quartiers = new ArrayList<>();
    }
    
    public void ajouterQuartier(Quartier quartier) {
        quartiers.add(quartier);
        if (quartier.getIdQuartier() == 0) {
            quartier.setIdQuartier(quartiers.size());
        }
    }
    
    public void supprimerQuartier(Quartier quartier) {
        quartiers.remove(quartier);
        int i = 1;
        for (Quartier q : quartiers) {
            q.setIdQuartier(i);
            i++;
        }
    }
    
    public List<Quartier> obtenirTousLesQuartiers() {
        return quartiers;
    }
    
    // ajout d'autres méthodes

    public void mettreAJourQuartier(Quartier quartier) {
        // Vérification si le quartier existe dans la liste
        boolean quartierExiste = false;
        for (int i = 0; i < quartiers.size(); i++) {
            if (quartiers.get(i).getIdQuartier() == quartier.getIdQuartier()) {
                quartiers.set(i, quartier);
                quartierExiste = true;
                break;
            }
        }
        
        if (!quartierExiste) {
            System.out.println("Le quartier n'existe pas.");
        }
        
        // Ici, vous pouvez ajouter le code pour mettre à jour le quartier dans la base de données ou autre système de stockage
    }
    
}