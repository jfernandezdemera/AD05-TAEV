package taev.app.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "university")
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Attributes
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Embedded
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "university_id")
	private List<Student> students = new ArrayList<>();

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// Constructors
	public University(int id, String name, Address address, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.students = students;
	}

	public University() {
	}

	// Methods
	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", address=" + address + ", students=" + students + "]";
	}
}
