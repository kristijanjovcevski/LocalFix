package mk.ukim.finki.localfix.web;

import mk.ukim.finki.localfix.model.*;
import mk.ukim.finki.localfix.model.enums.Impact;
import mk.ukim.finki.localfix.model.enums.Status;
import mk.ukim.finki.localfix.repository.ProblemAdministratorRepository;
import mk.ukim.finki.localfix.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/***
 * Functionalities:
 * ListProblems - ALL or By User, pagination
 * AddProblem
 * ProblemDetails
 * Filters - Examples(SearchName, City, Country, ProblemType, Institution, Impact, Status)
 * EditProblem - OnlyAdmin
 */
@Controller
public class ProblemController {

    private final ProblemService problemService;
    private final InstitutionService institutionService;
    private final UserService userService;
    private final CityService cityService;
    private final ProblemAdministratorRepository problemAdministratorRepository;


    public ProblemController(ProblemService problemService,
                             InstitutionService institutionService,
                             UserService userService,
                             CityService cityService,
                             ProblemAdministratorRepository problemAdministratorRepository
                             ) {

        this.problemService = problemService;
        this.institutionService = institutionService;
        this.userService = userService;
        this.cityService = cityService;
        this.problemAdministratorRepository = problemAdministratorRepository;
    }


    /*ListProblems - ALL or By User, pagination*/
    @GetMapping("/problems")
    public String listProblemsPage(Model model, @RequestParam(required = false) Long cityId){

        List<Problem> problemList = new ArrayList<>();
        List<City> cityList = this.cityService.listAllCities();

        User reportedBy;

        if (cityId == null) {
             reportedBy = this.userService.findUserById(1L);

            if (reportedBy != null) {
                problemList = reportedBy.getProblems();
            }
            else {
                // listing all problems published by administrators
                List<Problem_Administrator> problemAdministratorList= 
                        this.problemAdministratorRepository.findAll();
                for (Problem_Administrator p : problemAdministratorList){
                    if (p != null) {
                        Problem problem = this.problemService
                                .findProblemById(p.getProblem().getId());

                        problemList.add(problem);
                    }
                }
            }
        }

        /*Filters - Examples(City, Status)*/

        else{
            reportedBy = this.userService.findUserById(1L);
            problemList = this.problemService.listAllProblemsByCityIdAndStatus(cityId,Status.SOLVED) ;
        }
        model.addAttribute("reportedBy",reportedBy);
        model.addAttribute("problems", problemList);
        model.addAttribute("cities", cityList);

        return "list-problems";
    }

    /*AddProblem*/
    @GetMapping ("/problem/add")
    public String addProblemPage(Model model){

        model.addAttribute("status",Status.values());

        model.addAttribute("impact", Impact.values());

        model.addAttribute("institutions", this.institutionService.listAllInstitutions());

        model.addAttribute("cities", this.cityService.listAllCities());

        return "add-problem";
    }
    @PostMapping("/problem/add")
    public String createProblem(@RequestParam String title, @RequestParam String description,
                                @RequestParam("image") MultipartFile file, @RequestParam Long institutionId,
                                @RequestParam Impact impact,
                                @RequestParam Long cityId,@RequestParam String address
                                ){


        byte [] photo = this.problemService.readImageBytes(file);


        this.problemService.saveProblem(title, description, photo, institutionId,cityId,impact,address);


        return "redirect:/problems";
    }

    /*ProblemDetails*/
    @GetMapping("/problem/detailed/view/{id}")
    public String detailedView(@PathVariable Long id, Model model){

        Problem problem = this.problemService.findProblemById(id);
        User reportedBy = this.userService.findUserById(1L);

        byte [] imageData = problem.getPhoto();

        String base64Image = Base64.getEncoder().encodeToString(imageData);

        model.addAttribute("problem", problem);
        model.addAttribute("reportedBy", reportedBy);
        model.addAttribute("image",base64Image);
        return "detail-view-problem";
    }



    /*** EditProblem - OnlyAdmin
    *  Edit problem mapping is located
     *  in AdministratorController
    * */
    @PostMapping("/problem/add/{id}")
    public String updateProblem(@PathVariable Long id,@RequestParam String title,
                                @RequestParam String address,
                                @RequestParam(required = false,name = "image") MultipartFile file,
                                @RequestParam String description,
                                @RequestParam Status status,
                                @RequestParam Impact impact,
                                @RequestParam Long institutionId){

        byte [] photo = this.problemService.readImageBytes(file);
        this.problemService.editProblem(id,title,address,photo,description,status,impact,institutionId);

        return "redirect:/problems";

    }

}
