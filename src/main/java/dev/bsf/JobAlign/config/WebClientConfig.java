package dev.bsf.JobAlign.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${chatgpt.api.url}")
    private String chatUrl;

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl(chatUrl).build();

    }

}
