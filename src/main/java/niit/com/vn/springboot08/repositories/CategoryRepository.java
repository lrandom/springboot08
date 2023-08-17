package niit.com.vn.springboot08.repositories;

import niit.com.vn.springboot08.domains.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>, PagingAndSortingRepository<Category, Long> {
    @Query("SELECT u from categories u")
    List<Category> myFindAll();
}
