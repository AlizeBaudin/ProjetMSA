package web;

import Model.Emprunt;
import dao.emprunDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.exeption.ImpossibleAjouterEmpruntExeption;
import web.exeption.ImpossibleEmpruntExeption;

import java.util.Optional;

@RestController
public class EmpruntController {

    @Autowired
    emprunDao empruntDao;

    @PostMapping(value = "/bibliotheque")
    public ResponseEntity<Emprunt> rendreUnlivre(@RequestBody Emprunt emprunt) throws ImpossibleAjouterEmpruntExeption {

        Emprunt nouvelEmprunt = empruntDao.save(emprunt);

        if(nouvelEmprunt == null) throw new ImpossibleAjouterEmpruntExeption(
                "Impossible de retourner ce livre - veuillez aller voir votre bibliothécaire"
        );

        return new ResponseEntity<Emprunt>(emprunt, HttpStatus.CREATED);
    }

    @GetMapping(value = "/bibliotheque/{id}")
    public Optional<Emprunt> emprunterUneLivre(@PathVariable int id) throws ImpossibleEmpruntExeption {

        Optional<Emprunt> emprunt = empruntDao.findById(id);

        if(!emprunt.isPresent()) throw new ImpossibleEmpruntExeption(
                "Ce livre n'est pas disponible : renseignez-vous après du bibliothécaire"
        );

        return emprunt;
    }

    /*
     * Permet de mettre à jour une commande existante.
     * save() mettra à jours uniquement les champs renseignés dans l'objet commande reçu. Ainsi dans ce cas, comme le champs date dans "commande" n'est
     * pas renseigné, la date précédemment enregistrée restera en place
     **/


    @PutMapping(value = "/bibliotheque")
    public void updateLivre(@RequestBody Emprunt emprunt) {
        empruntDao.save(emprunt);
    }


}
