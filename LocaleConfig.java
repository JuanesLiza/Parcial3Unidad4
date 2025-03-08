package com.ejemplo.pedidos.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Configuration
public class LocaleConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource(); // Especifica el archivo base de mensajes (messages.properties).
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public WebFilter localeWebFilter() {
        return (exchange, chain) -> {
            String language = exchange.getRequest().getQueryParams().getFirst("lang"); // Obtiene el valor del parámetro "lang" en la URL.
            Locale locale = (language != null) ? new Locale(language) : Locale.ENGLISH; // Si se proporciona un idioma, lo usa; de lo contrario, usa inglés por defecto.
            exchange.getAttributes().put("locale", locale); // Guarda el idioma en los atributos de la solicitud.
            return chain.filter(exchange);
        };
    }
}

