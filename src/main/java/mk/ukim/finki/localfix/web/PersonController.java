package mk.ukim.finki.localfix.web;

import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.exceptions.*;
import mk.ukim.finki.localfix.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/***
 * Functionalities:
 * Register
 * Login
 * Logout
 * Profile???
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/register")
    public String getRegisterPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        if(username != null){
            return "logout";
        }
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password,
                           @RequestParam String confirmPassword, @RequestParam(defaultValue = "false") Boolean agree) {
        try{
            if(!agree){
                throw new TermsOfServiceException();
            }
            this.personService.register(username, email, password, confirmPassword);
            return "redirect:/person/login";
        } catch (TermsOfServiceException | InvalidArgumentsException | PasswordsDoNotMatchException |
        UsernameAlreadyExistsException | EmailAlreadyExistsException exception) {
            return "redirect:/person/register?error=" + exception.getMessage();
        }
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        String username = request.getRemoteUser();
        if(username != null){
            model.addAttribute("person",username);
            return "logout";
        }
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model) {
        try{
            Person person = personService.login(username, password);
            request.getSession().setAttribute("person", person);
            return "redirect:/problems";
        }catch (InvalidUserCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

}
