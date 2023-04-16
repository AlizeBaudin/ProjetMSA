package lecteur.proxie;


import Model.Emprunt;
import lecteur.bean.EmpruntBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*--------------------- Classe proxy pour l'emprunt
*  Cette classe permet de faire appel grâve à l'anotation FeignClient, que l'on utilise
* le controller du microservice de l'emprunt
* -------------------------------------------------- */
@FeignClient(name = "emprunt-microservice", url = "http://localhost:9002")
public interface MicroserviceEmpruntProxy {

    @PostMapping(value = "/emprunt")
    ResponseEntity<Emprunt> rendreUnlivre(@PathVariable int id, @RequestBody Emprunt emprunt);

    @GetMapping(value = "/emprunt/{id}")
    List<Emprunt> emprunterUnLivre(@RequestBody Emprunt emprunt);

    @PutMapping(value = "/emprunt")
    void updateLivre(@RequestBody Emprunt emprunt);

    @DeleteMapping(value = "/emprunt/{id}")
    void suprimerEmprunt(@PathVariable int id);

    @PostMapping(value = "/emprunt/renouvellement/{id}")
    ResponseEntity<Emprunt> renouvellement(@PathVariable int id, @RequestBody Model.Emprunt emprunt);

}
