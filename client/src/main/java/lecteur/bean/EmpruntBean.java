package lecteur.bean;

import java.util.Date;

public class EmpruntBean {
    private int id;
    private int lecteurId;
    private Double ISBN;
    private Date date_pret;
    private Date date_retour;
    private Integer quantite;
    private Boolean empruntRetirer;
    public EmpruntBean() {
    }
    public int getLecteurId() {
        return lecteurId;
    }
    public void setLecteurId(int lecteurId) {
        this.lecteurId = lecteurId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getISBN() {
        return ISBN;
    }
    public void setISBN(Double ISBN) {
        this.ISBN = ISBN;
    }
    public Date getDate_pret() {
        return date_pret;
    }
    public void setDate_pret(Date date_pret) {
        this.date_pret = date_pret;
    }
    public Date getDate_retour() {
        return date_retour;
    }
    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
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
    public void setEmpruntRetirer(Boolean empruntRetirer) {
        this.empruntRetirer = empruntRetirer;
    }
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
