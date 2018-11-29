/**
 *
 */
package lopez.reyes.rafael.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lopez.reyes.rafael.model.EntityExample;

/**
 * @author Rafael Reyes Lopez
 *
 */
@Repository
public interface EntityExampleRepository extends CrudRepository<EntityExample, Long> {
}
