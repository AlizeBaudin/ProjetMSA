package lecteur;

import Model.Emprunt;
import lecteur.Model.Lecteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

// Creation du JPA Repository basé sur Spring Data
//  Permet de "générer" toutes sortes de requêtes JPA, sans implementation
@Repository
public interface clientRepository extends JpaRepository<Lecteur, Integer>{
    String accueil(Model model);
    String fichelivre(int id, Model model);
    String emprunter(Emprunt emprunt, Model model);
    String retour(Emprunt emprunt,int id, Model model);
    ResponseEntity<Lecteur> ajouterLecteur(Lecteur lecteur);
    void supprimerLecteur(int id);
    static String rechercherLecteurParNom(String nom) {
        return nom;
    }

}