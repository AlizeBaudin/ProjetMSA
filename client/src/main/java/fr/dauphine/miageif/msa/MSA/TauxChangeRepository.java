package fr.dauphine.miageif.msa.MSA;
import org.springframework.data.jpa.repository.JpaRepository;

// Creation du JPA Repository basé sur Spring Data
//  Permet de "générer" toutes sortes de requêtes JPA, sans implementation
public interface TauxChangeRepository extends  JpaRepository<Client, Long>{
  // Query Method findBy
  Client findBySourceAndDest(String source, String dest);

  //void put();
}