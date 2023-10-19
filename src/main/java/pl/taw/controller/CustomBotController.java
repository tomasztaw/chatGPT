package pl.taw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.taw.dto.ChatGPTRequest;
import pl.taw.dto.ChatGPTResponse;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        ChatGPTResponse chatGPTResponse = restTemplate.postForObject(apiUrl, request, ChatGPTResponse.class);
        assert chatGPTResponse != null;
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
