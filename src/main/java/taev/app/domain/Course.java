package taev.app.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Attributes
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "credits")
	private String credits;

	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@ManyToMany(mappedBy = "courses")
	private Set<Student> student = new HashSet<>();;

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

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	// Constructors
	public Course(String name, String credits, Instructor instructor, Set<Student> student) {
		this.name = name;
		this.credits = credits;
		this.instructor = instructor;
		this.student = student;
	}

	public Course() {
	}

	// Methods
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + ", instructor=" + instructor
				+ ", student=" + student + "]";
	}
}
