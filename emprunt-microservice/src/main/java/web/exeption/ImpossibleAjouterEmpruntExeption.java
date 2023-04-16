package web.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterEmpruntExeption extends Throwable {
    public ImpossibleAjouterEmpruntExeption(String message) {
        super(message);
    }
}
