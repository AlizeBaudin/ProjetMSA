package controller;

import configuration.ApplicationPropertieConfiguration;
import dao.livreDao;
import exeption.LivreNotFoundExpeption;
import model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class controllerLivre {

    @Autowired
    livreDao LivreDao;
    private final ApplicationPropertieConfiguration appProperties;

    public controllerLivre(livreDao LivreDao, ApplicationPropertieConfiguration appProperties){
        this.LivreDao = LivreDao;
        this.appProperties = appProperties;
    }


    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/bibliotheque")
    public List<Livre> listeDesLivres(){
        List<Livre> products = LivreDao.findAll();
        if(products.isEmpty()) throw new LivreNotFoundExpeption("Clôture des emprunts");
        List<Livre> listeLimitee = products.subList(0, appProperties.getLimitDeProduits());
        return listeLimitee;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/bibliotheque/{id}")
    public Optional<Livre> recupererUnLivre(@PathVariable int id) {
        Optional<Livre> product = LivreDao.findById(id);
        if(!product.isPresent())  throw new LivreNotFoundExpeption(
                "Le livre correspondant à l'id " + id + " n'existe pas"
        );
        return product;
    }
}
