package fr.dauphine.miageif.msa.MSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;


@RestController
public class ChangeController {

  // Spring se charge de la création d'instance
  @Autowired
  private Environment environment;

  // Spring se charge de la création d'instance
  @Autowired
  private TauxChangeRepository repository;

  @GetMapping("/devise-change/source/{source}/dest/{dest}")
  public Client retrouveTauxChange (@PathVariable String source,
                                    @PathVariable String dest)
  {

    Client client =
        repository.findBySourceAndDest(source, dest);

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/
    if(client == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return client;
  }

  @PostMapping("/devise-change/source/{source}/dest/{dest}/id/{id}/taux/{taux}")
  public Client modifyTaux (@PathVariable String source,
                            @PathVariable String dest,
                            @PathVariable Long id,
                            @PathVariable BigDecimal taux){
    //TauxChange newTauxChange = new TauxChange();
    Client client = new Client(id,source,dest,taux);
    repository.save(client);

    return client;
  }

  @DeleteMapping("/devise-change/source/{source}/dest/{dest}")
  public Client deleteTaux
          (@PathVariable String source,
           @PathVariable String dest){

    Client clientDelete = repository.findBySourceAndDest(source, dest);
    repository.delete(clientDelete);

    return clientDelete;
  }

}