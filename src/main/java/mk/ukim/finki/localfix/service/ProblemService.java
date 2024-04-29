package mk.ukim.finki.localfix.service;


import mk.ukim.finki.localfix.model.City;
import mk.ukim.finki.localfix.model.Problem;

import mk.ukim.finki.localfix.model.enums.Impact;
import mk.ukim.finki.localfix.model.enums.Status;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface ProblemService {

    List<Problem> listAllProblems();

    Problem findProblemById(Long id);

    //pri sozdavanje na problemot se dodeluva korisnikot reportedBy vo ovoj metod
    Optional<Problem> saveProblem(String title, String description, byte[] photo,
                                    Long institutionId, Long cityId,Impact impact,String address);

    /* reportedBy user atributot nema da moze da se menuva toj avtomatski dodeluva pri kreiranje na problemot
    od strana na najaveniot korisnik */
    Optional<Problem> editProblem(Long id,String title,String address,byte [] photo, String description, Status status,
                                  Impact impact,
                                  Long institutionId);


    void deleteProblemById(Long id);

    List<Problem> listAllProblemsByCityIdAndStatus(Long id,Status status) ;
    byte [] readImageBytes(MultipartFile file);

}
