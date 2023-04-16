package lecteur.exeption;

import feign.codec.ErrorDecoder;
import feign.Response;

public class CustomErrorDecoder implements ErrorDecoder{
    private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String invoqueur, Response reponse) {
        if(reponse.status() == 400 ) {
            return new LivreBadRequestException(
                    "Requête incorrecte "
            );
        }
        return defaultErrorDecoder.decode(invoqueur, reponse);
    }
}
