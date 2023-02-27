package taev.app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tuition")
public class Tuition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Attributes
	@Column(name = "id")
	private int id;

	@Column(name = "fee")
	private Double fee;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	// Getters / Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// Constructors
	public Tuition(Double fee, Student student) {
		super();
		this.fee = fee;
		this.student = student;
	}

	public Tuition() {
	}

	// Methods
	@Override
	public String toString() {
		return "Tuition [id=" + id + ", fee=" + fee + ", student=" + student + "]";
	}
}
