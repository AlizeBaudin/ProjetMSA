package dao;

import model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/* ----------------------------- Repository des livres

Cette classe va permettre de retrouver tous les élément de l'implementation de JpaRepository
et d'agir ici sur les livres

 -----------------------------------------*/

@Repository
public interface livreRepository extends JpaRepository<Livre, Integer> {
    List<Livre> listeDesLivres();
    Optional<Livre> recupererUnLivre(int idLivre);
    void suprimerLivre(int idLivre);
    ResponseEntity<Livre> miseAjourLivre(int id,Livre livre);

}
