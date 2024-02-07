package br.com.exemplo.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Demo API",
        version = "v1.0.0",
        description = "Sistema demonstrativo de teste",
        contact = @Contact(
            name = "Rogério Silva",
            email = "rogeriosilva60@gmail.com",
            url = "https://github.com/rogerioSilva60"
        ),
        license = @License(
            name = "Apache 2.0", url = "http://springdoc.org"
        )
    )
)
public class OpenApiConfig {

}
