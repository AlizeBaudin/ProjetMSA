package fr.dauphine.miageif.msa.MSA;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


// Classe persistente representant  un "taux de change"
@Entity
public class Client {

    @Id
    private Long id;

    @Column(name="name_client")
    private String name_client;

    @Column(name="username")
    private String username;

    private BigDecimal taux;
    private int port;

    public Client() {

    }

    public Client(Long id, String source, String dest, BigDecimal taux) {
        super();
        this.id = id;
        this.source = source;
        this.dest = dest;
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDest() {
        return dest;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setId( Long idPort){this.id = idPort;}

}