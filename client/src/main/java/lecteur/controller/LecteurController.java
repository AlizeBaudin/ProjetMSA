package lecteur.controller;

import Model.Emprunt;
import lecteur.Model.Lecteur;
import lecteur.bean.LivreBean;
import lecteur.clientRepository;
import model.Livre;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import lecteur.proxie.MicroserviceEmpruntProxy;
import lecteur.proxie.MicroserviceLivreProxy;
import org.springframework.web.bind.annotation.*;
//import org.springframework.hateoas.Resource; test modèle Richardson de complexité 3 : infrutueu

import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;


@RestController
public class LecteurController {

    private final MicroserviceEmpruntProxy empruntProxy;
    private final MicroserviceLivreProxy livreProxy;
    private final clientRepository lecteurDao;

    @Autowired
    public LecteurController(MicroserviceEmpruntProxy empruntProxy, MicroserviceLivreProxy livreProxy, clientRepository lecteurDao) {
        this.empruntProxy = empruntProxy;
        this.livreProxy = livreProxy;
        this.lecteurDao = lecteurDao;
    }

/// On fait ici l'accoeuil du site d'emprunt de livre, par le listing des livres de la bibliothèque
    @RequestMapping(value = "/", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public String accueil(Model model)
    {
        List<LivreBean> livres =  livreProxy.listeDesLivres();
        model.addAttribute("livres", livres);
        return "Bibliothèque";

    }

    @RequestMapping(value = "/livres/{id}", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public String fichelivre(@PathVariable int id, Model model){
        Optional<Livre> livre = livreProxy.recupererUnLivre(id);
        model.addAttribute("livre", livre);
        return "FicheLivre";
    }

    @RequestMapping(value="/emprunts/{id}",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public String emprunter(@PathVariable Emprunt emprunt, Model model){
        List<Emprunt> emprunter = empruntProxy.emprunterUnLivre(emprunt);
        model.addAttribute("emprunt", emprunt);
        return "Livre emprunté";
    }

    @RequestMapping(value="/emprunts",method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public String retour(@PathVariable Emprunt emprunt, @PathVariable int id, Model model){
        ResponseEntity<Emprunt> retour = empruntProxy.rendreUnlivre(id, emprunt);
        model.addAttribute("emprunt", emprunt);
        return "Livre rendu";
    }

// Ajout d'un lecteur dans la base de donnée : le lecteur n'a pas accès à ces requêtes
    @PostMapping(value="/lecteur")
    private ResponseEntity<Lecteur> ajouterLecteur(@RequestBody Lecteur lecteur){
        Lecteur nouveauLecteur = lecteurDao.save(lecteur);
        return ResponseEntity.ok(nouveauLecteur);
    }

    @GetMapping(value="/lecteur")
    private ResponseEntity<String> rechercherLecteurParNom(@RequestParam(required = false) String nom){
        String nomLecteur = clientRepository.rechercherLecteurParNom(nom);
        return ResponseEntity.ok(nomLecteur);
    }

    @DeleteMapping(value="/lecteur/{id}")
    private void supprimerLecteur(@PathVariable int id){
        lecteurDao.deleteById(id);
    }

}