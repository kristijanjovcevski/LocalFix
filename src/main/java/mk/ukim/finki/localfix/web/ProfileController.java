package mk.ukim.finki.localfix.web;

import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.localfix.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final PersonService personService;

    public ProfileController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    String getProfilePage(@RequestParam(required = false) String msg,
                          @RequestParam(required = false) String color,
                          Model model, HttpServletRequest request){
        String username = request.getRemoteUser();
        Person loggedPerson = personService.findByUsername(username);
        model.addAttribute("person", username);
        model.addAttribute("user", loggedPerson);
        if(msg != null && !msg.isEmpty()) {
            model.addAttribute("color", color);
            model.addAttribute("msg", msg);
        }
        return "profile";
    }

    @PostMapping
    String changePassword(@RequestParam String newPass, @RequestParam String confirmPass, HttpServletRequest request){
        try{
            String username = request.getRemoteUser();
            personService.changePass(username, newPass, confirmPass);
        }catch (PasswordsDoNotMatchException exception){
            return "redirect:/profile?color=red&msg=" + exception.getMessage();
        }
        return "redirect:/profile?color=green&msg=Successfully updated password";
    }

    @PostMapping("/delete")
    String deleteProfile(HttpServletRequest request){
        String username = request.getRemoteUser();
        personService.deleteProfile(username);
        return "redirect:/person/login";
    }
}
