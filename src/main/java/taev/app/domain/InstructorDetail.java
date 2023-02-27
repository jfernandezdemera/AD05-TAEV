package taev.app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Attributes
	@Column(name = "id")
	private int id;

	@Column(name = "blog")
	private String blog;

	@Column(name = "hobby")
	private String hobby;

	@OneToOne(mappedBy = "instructorDetail")
	private Instructor instructor;

	// Getters / Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	// Constructors
	public InstructorDetail(String blog, String hobby, Instructor instructor) {
		this.blog = blog;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	public InstructorDetail() {
	}

	// Methods
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", blog=" + blog + ", hobby=" + hobby + ", instructor=" + instructor
				+ "]";
	}
}
