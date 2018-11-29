/**
 *
 */
package lopez.reyes.rafael.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lopez.reyes.rafael.model.EntityExample;
import lopez.reyes.rafael.repository.EntityExampleRepository;

/**
 * @author Rafael Reyes Lopez
 *
 */
@Service
public class EntityExampleService {

	@Autowired
	private EntityExampleRepository repository;

	public List<EntityExample> exampleMethod(String name) {

		final List<EntityExample> entityExampleList = new ArrayList<EntityExample>();
		EntityExample entityExample;
		for (int i = 0; i < 10; i++) {

			entityExample = new EntityExample(name, i);
			entityExampleList.add(entityExample);
		}

		repository.saveAll(entityExampleList);

		return entityExampleList;

	}

}
