package mk.ukim.finki.localfix.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * Functionalities:
 * ListProblems - ALL or By User, pagination
 * AddProblem
 * ProblemDetails
 * Filters - Examples(SearchName, City, Country, ProblemType, Institution, Impact, Status)
 * EditProblem - OnlyAdmin
 */
@Controller
@RequestMapping("/problems")
public class ProblemController {
}
