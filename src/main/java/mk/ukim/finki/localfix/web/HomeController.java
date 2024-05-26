package mk.ukim.finki.localfix.web;

import mk.ukim.finki.localfix.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String Home(Model model, HttpServletRequest request){
        String username = request.getRemoteUser();
        model.addAttribute("person",username);
        return "about-us";
    }
}
