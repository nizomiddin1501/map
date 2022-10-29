package uz.developers.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.map.entity.Continent;

public interface ContinentRepository extends JpaRepository<Continent,Integer> {



}
