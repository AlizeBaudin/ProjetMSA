package lecteur;


import Model.Emprunt;
import lecteur.Model.Lecteur;
import lecteur.bean.LivreBean;
import lecteur.proxie.MicroserviceEmpruntProxy;
import lecteur.proxie.MicroserviceLivreProxy;
import model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class lecteurService {
    private final MicroserviceEmpruntProxy empruntProxy;
    private final MicroserviceLivreProxy livreProxy;

    private final clientRepository lecteurDao;

    @Autowired
    public lecteurService(MicroserviceEmpruntProxy empruntProxy, MicroserviceLivreProxy livreProxy, clientRepository lecteurDao) {
        this.empruntProxy = empruntProxy;
        this.livreProxy = livreProxy;
        this.lecteurDao = lecteurDao;
    }

    public List<LivreBean> library()
    {
        return livreProxy.listeDesLivres();
    }

    public Optional<Livre> fichelivre(int id){
        return livreProxy.recupererUnLivre(id);
    }

    public List<Emprunt> emprunter(int id, Emprunt emprunt){
        return empruntProxy.emprunterUnLivre(emprunt);
    }

    public ResponseEntity<Emprunt> retour(Emprunt emprunt, int id){
        return empruntProxy.rendreUnlivre(id, emprunt);
    }

    public Lecteur ajouterLecteur(Lecteur lecteur) {
        return lecteurDao.save(lecteur);
    }

    public String rechercherLecteurParNom(String nom) {
        return clientRepository.rechercherLecteurParNom(nom);
    }

}
