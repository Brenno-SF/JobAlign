package dev.bsf.JobAlign.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.http.HttpHeaders;

import java.util.Map;

@Service
public class ChatService {
    @Autowired
    private WebClient webClient;
    private String apiKey = System.getenv("API_KEY");

    /*
         curl "https://api.openai.com/v1/responses" \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer $OPENAI_API_KEY" \
        -d '{
            "model": "gpt-4.1",
            "input": "Write a one-sentence bedtime story about a unicorn."
        }'
     */

    public Mono<String> generateContent() {
        String prompt = "Você vai me ajudar a conseguir um emprego lendo meu currículo e criando uma carta de apresentação baseado em uma descrição de vaga";

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );


        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {

                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()) {
                        Map<String, Object> choice = choices.get(0);
                        Map<String, Object> message = (Map<String, Object>) choice.get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhuma resposta foi gerada.";
                });
    }

}

