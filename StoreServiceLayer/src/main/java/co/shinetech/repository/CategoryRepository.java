package co.shinetech.repository;

import co.shinetech.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rodrigo on 7/3/2017.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findFirstLevel();
    List<Category> findSubCategories(Long id);
}