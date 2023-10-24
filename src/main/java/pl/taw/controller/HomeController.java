/**
 * Created by tomasz_taw
 * Date: 24.10.2023
 * Time: 21:39
 * Project Name: chatGPT
 * Description:
 */
package pl.taw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String homePage() {
        return "homePage";
    }
}
