package lecteur.proxie;

import lecteur.bean.LivreBean;
import model.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
/*--------------------- Classe proxy pour l'accès aux livres
 *  Cette classe permet de faire appel grâce à l'annotation FeignClient, que l'on utilise
 * le controller du microservice des livres
 * -------------------------------------------------- */
@FeignClient(name = "livre-microservice", url = "http://localhost:9001")
public interface MicroserviceLivreProxy {

    @GetMapping(value = "/livres")
    List<LivreBean> listeDesLivres();

    @GetMapping( value = "/livres/{id}")
    Optional<Livre> recupererUnLivre(@PathVariable int id);

}
