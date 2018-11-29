/**
 *
 */
package lopez.reyes.rafael.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Reyes Lopez
 *
 */
@Entity
@Table(name = "entity_example")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EntityExample {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "data")
	private Integer data;

	/**
	 * @param name
	 * @param data
	 */
	public EntityExample(String name, Integer data) {
		this.name = name;
		this.data = data;
	}

}
