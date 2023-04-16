package lecteur.exeption;

public class LivreBadRequestException extends Exception{

    private final Object requete_incorrecte;

    public LivreBadRequestException(String requete_incorrecte_) {
        this.requete_incorrecte = requete_incorrecte_;
    }

    public String LivreBadRequestException(String requête_incorrecte_) {
        return "bad request";
    }


}
