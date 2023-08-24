package niit.com.vn.springboot08.repositories;

import niit.com.vn.springboot08.entities.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
