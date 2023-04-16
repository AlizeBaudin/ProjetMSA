package controller;

import configuration.ApplicationPropertieConfiguration;
import dao.livreRepository;
import exeption.LivreNotFoundExpeption;
import model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class controllerLivre {

    @Autowired
    livreRepository LivreDao;
    private final ApplicationPropertieConfiguration appProperties;

    public controllerLivre(livreRepository LivreDao, ApplicationPropertieConfiguration appProperties){
        this.LivreDao = LivreDao;
        this.appProperties = appProperties;
    }


    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/livres")
    public List<Livre> listeDesLivres(){
        List<Livre> livres = LivreDao.findAll();
        if(livres.isEmpty()) throw new LivreNotFoundExpeption("Clôture des emprunts");
        List<Livre> listeLimitee = livres.subList(0, appProperties.getLimitDeProduits());
        return listeLimitee;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/livres/{id}")
    public Optional<Livre> recupererUnLivre(@PathVariable int id) {
        Optional<Livre> livre = LivreDao.findById(id);
        if(!livre.isPresent()) throw new LivreNotFoundExpeption(
                "Le livre correspondant à l'id " + id + " n'existe pas"
        );
        return livre;
    }

    /* ----------------------- Gestion bibliotheque

    Nous allons ici développer tous les outils netecessaire pour la bonne gestion de la bibliothèque
    Ces requêtes ne seront pas accéssible par le client mais par le personnel

     --------------------------------------------*/
    // modification ou mise a jour des livres : non accéssible pas le lecteur
    // ajout, suppression, modification, etc...
    @PutMapping(value = "/livres/modifie/{id}")
    public ResponseEntity<Livre> miseAjourLivre(@PathVariable int id, @RequestBody Livre livre){
        Optional<Livre> livreOptional = LivreDao.findById(id);
        if (!livreOptional.isPresent())  throw  new LivreNotFoundExpeption(
                "Le livre correspondant à l'id " + id + " n'existe pas"
        );

        livre = livreOptional.get();
        Livre livreModifie = new Livre();
        livre.setTitre(livreModifie.getTitre());
        livre.setISBN(livreModifie.getISBN());
        livre.setEditeur(livreModifie.getEditeur());
        livre.setEdition(livreModifie.getEdition());
        Livre livreSauvegarde = LivreDao.save(livre);
        return ResponseEntity.ok(livreSauvegarde);

    }

    @PostMapping(value = "/livres/ajout")
    public ResponseEntity<Livre> ajouterLivre(@RequestBody Livre livre) {
        Livre livreAjouter = LivreDao.save(livre);
        return ResponseEntity.ok(livreAjouter);
    }

    @DeleteMapping(value = "/livres/suprime/{id}")
    public void suprimerLivre(@PathVariable int id){
        LivreDao.deleteById(id);
    }
}
