package niit.com.vn.springboot08.repositories;

import niit.com.vn.springboot08.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
