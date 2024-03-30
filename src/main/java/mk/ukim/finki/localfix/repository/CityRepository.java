package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
