package lecteur.bean;

public class LivreBean {
    private int id;
    private String titre;
    private String auteur;
    private String editeur;
    private Double edition;
    private Double ISBN;

    public LivreBean(int id, String titre, String auteur, String editeur, Double edition, Double isbn){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
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
