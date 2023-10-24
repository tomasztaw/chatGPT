/**
 * Created by tomasz_taw
 * Date: 24.10.2023
 * Time: 21:53
 * Project Name: chatGPT
 * Description:
 */
package pl.taw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/word")
public class WordController {

    @GetMapping("/input")
    public String inputPage() {
        return "inputPage";
    }

    @PostMapping("/generate")
    public String generateWord(@RequestParam("word") String word, Model model) {
        // Tutaj możesz wygenerować opis słowa na podstawie wartości word
        String description = "To jest opis słowa: " + word;
        model.addAttribute("description", description);
        return "resultPage";
    }
}
