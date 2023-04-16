package configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("mes-configs")
public class ApplicationPropertieConfiguration
{

    private int limitDeProduits;

    public int getLimitDeProduits()
    {

        return limitDeProduits;

    }

    public void setLimitDeProduits(int limitDeProduits)
    {
        this.limitDeProduits = limitDeProduits;
    }
}
