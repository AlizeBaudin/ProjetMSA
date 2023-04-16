package lecteur.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


// Classe persistente representant  un "taux de change"
@Entity
public class Lecteur {

    @Id
    private Long id;

    @Column(name="name_client")
    private String name_client;

    @Column(name="username")
    private String username;

    private String genre;
    private String date_naissance;

    public Lecteur() {

    }

    public Lecteur(Long id, String name_client, String username, String genre, String date_naissance) {
        super();
        this.id = id;
        this.name_client = name_client;
        this.username= username;
        this.genre = genre;

        this.date_naissance = date_naissance;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
}