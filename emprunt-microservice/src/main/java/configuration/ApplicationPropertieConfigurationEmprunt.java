package configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("mes-configs-emprunt")
public class ApplicationPropertieConfigurationEmprunt
{
    private int limitEmprunt;
    public int getLimitEmprunt()
    {
        return limitEmprunt;
    }
    public void setLimitEmprunt(int limitEmprunt)
    {
        this.limitEmprunt = limitEmprunt;
    }

}
