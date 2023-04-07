package repository;

import model.ExpEdu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpEduRepository extends JpaRepository<ExpEdu, Long> {

}
