package taev.app.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Attributes
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "field")
	private String field;

	@Column(name = "budget")
	private Double budget;

	@ManyToMany(mappedBy = "projects")
	private Set<Instructor> instructors = new HashSet<>();

	// Getters / Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	// Constructors
	public Project(String name, String field, Double budget, Set<Instructor> instructors) {
		this.name = name;
		this.field = field;
		this.budget = budget;
		this.instructors = instructors;
	}

	public Project() {
	}

	// Methods
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", field=" + field + ", budget=" + budget + ", instructor="
				+ instructors + "]";
	}
}
