package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Livre {
    @Id
    @GeneratedValue
    private int id;
    private String titre;
    private String auteur;
    private String editeur;
    private Double edition;
    @Column(unique = true)
    private Double ISBN;

    public Livre() {
    }

    public Livre(int id, String titre, String auteur, String editeur, Double edition, Double isbn) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.edition = edition;
        this.ISBN = isbn;
    }


    public Double getEdition() {
        return edition;
    }

    public void setEdition(Double edition) {
        this.edition = edition;
    }

    public Double getISBN() {
        return ISBN;
    }

    public void setISBN(Double ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "emprunt{" +
                "id=" + id +
                ", titre=" + titre +
                ", auteur=" + auteur +
                ", editeur=" + editeur +
                ", edition=" +edition+
                ", ISBN="+ISBN+
                '}';
    }

}
