package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Emprunt {

    @Id
    @GeneratedValue
    private int id;
    private int lecteurId;
    private Double ISBN;
    private Date date_pret;
    private Date date_retour;
    private Integer quantite;
    private Boolean empruntRetirer;

    public Emprunt() {
    }

    public Emprunt(int id, int lecteurId, Double isbn, Date date_pret, Date date_retour, Integer quantite, Boolean empruntRetirer) {
        this.id = id;
        this.lecteurId = lecteurId;
        this.ISBN = isbn;
        this.date_pret = date_pret;
        this.date_retour = date_retour;
        this.quantite = quantite;
        this.empruntRetirer = empruntRetirer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return date_pret;
    }

    public void setDateEmprunt(Date  date_pret) {
        this. date_pret =  date_pret;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Boolean getEmpruntRetirer() {
        return empruntRetirer;
    }

    public void setEmpruntFait(Boolean commandePayee) {
        this.empruntRetirer = empruntRetirer;
    }

    public int getLecteurId() {
        return lecteurId;
    }

    public void setLecteurId(int lecteurId) {
        this.lecteurId = lecteurId;
    }

    public Double getISBN() {
        return ISBN;
    }

    public void setISBN(Double ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDateRetour() {
        return date_retour;
    }

    public void setDateRetour(Date dateRetour) {
        this.date_retour = dateRetour;
    }

    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", lecteurId=" + lecteurId +
                ", dateEmprunt=" + date_pret +
                ", dateRetour="+ date_retour+
                ", quantite=" + quantite +
                ", empruntRetirer=" + empruntRetirer +
                '}';
    }

}

