package dao;

import Model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

    Emprunt emprunterUnLivre(Emprunt idEmprunt);
    Emprunt rendreUnlivre(Emprunt commande);
    void updateLivre(Emprunt emprunt);
    ResponseEntity<Emprunt> renouvellement(int idEmprunt, Model.Emprunt emprunt);
    void suprimerEmprunt( int idEmprunt);

}
