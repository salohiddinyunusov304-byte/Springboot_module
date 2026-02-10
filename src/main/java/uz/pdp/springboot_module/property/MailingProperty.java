package uz.pdp.springboot_module.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "mailing")
public record MailingProperty(String host,
                              Integer port,
                              String username,
                              String password,
                              String secretKey
) {


}
