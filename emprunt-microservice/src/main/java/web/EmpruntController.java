package web;

import Model.Emprunt;
import configuration.ApplicationPropertieConfigurationEmprunt;
import dao.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.exeption.ImpossibleAjouterEmpruntExeption;
import web.exeption.ImpossibleEmpruntExeption;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpruntController {

    @Autowired
    EmpruntRepository empruntDao;
    private final ApplicationPropertieConfigurationEmprunt appProperties;

    public EmpruntController(EmpruntRepository empruntDao, ApplicationPropertieConfigurationEmprunt appProperties) {
        this.appProperties = appProperties;
        this.empruntDao =empruntDao;
    }

    ///accé à tous les emprunts
    @GetMapping(value = "/emprunt")
    public List<Emprunt> listeDesEmprunts(){
        List<Emprunt> emprunts = empruntDao.findAll();
        if(emprunts.isEmpty()) { System.out.println("PAs d'emprunt");}
        return emprunts;
    }

    @PostMapping(value = "/emprunt/retour")
    public ResponseEntity<Emprunt> rendreUnlivre(@PathVariable int id, @RequestBody Emprunt emprunt) throws ImpossibleAjouterEmpruntExeption {

        Optional<Emprunt> nouveauRetour = empruntDao.findById(id);
        if(nouveauRetour == null) throw new ImpossibleAjouterEmpruntExeption(
                "Impossible de retourner ce livre - veuillez aller voir votre bibliothécaire"
        );
        return new ResponseEntity<Emprunt>(emprunt, HttpStatus.CREATED);
    }

    @GetMapping(value = "/emprunt/{id}")
    public List<Emprunt> emprunterUnLivre(@RequestBody Emprunt emprunt) throws ImpossibleEmpruntExeption {

        List<Emprunt> nouvelEmprunt = Collections.singletonList(empruntDao.save(emprunt));

        if(emprunt == null) throw new ImpossibleEmpruntExeption(
                "Ce livre n'est pas disponible : renseignez-vous après du bibliothécaire"
        );
        //limite d'emprunt par livre
        List<Emprunt> limitEmprunt = nouvelEmprunt.subList(0, appProperties.getLimitEmprunt());
        return limitEmprunt;
    }

    /*
     * Permet de mettre à jour une commande existante.
     * save() mettra à jours uniquement les champs renseignés dans l'objet emprunt. Ainsi dans ce cas, comme le champs date n'est
     * pas renseigné, la date précédemment enregistrée restera en place
     **/
    // le client n'a pas accès à cette fonctionnalité : uniquement l'équipe de la bibliothèque
    // si besoin de configurer le nouvelle emprunt si problème sur le livre (non retour, perte, etc..)
    @PutMapping(value = "/emprunt/{id}")
    public void updateLivre(@RequestBody Emprunt emprunt) {
        empruntDao.save(emprunt);
    }


    // Mise a jour d'un emprunt : allongement de la date d'emprunt
    @PostMapping(value = "/emprunt/renouvellement/{id}")
    public Emprunt renouvellement(@PathVariable int id, @RequestBody Emprunt emprunt) throws ImpossibleEmpruntExeption {
        Optional<Emprunt> empruntOptional = empruntDao.findById(id);
        if (!empruntOptional.isPresent())  throw new ImpossibleEmpruntExeption(
                "Enprunt " + id + " n'existe pas"
        );
        emprunt = empruntOptional.get();
        Emprunt empruntModifie = new Emprunt();
        emprunt.setDateEmprunt(empruntModifie.getDateEmprunt());
        emprunt.setDateRetour(empruntModifie.getDateRetour());
        Emprunt empruntProlonge = empruntDao.emprunterUnLivre(emprunt);
        return empruntProlonge;

    }

    @DeleteMapping(value = "/emprunt/{id}")
    public void suprimerEmprunt(@PathVariable int id){
        empruntDao.deleteById(id);
    }

}
