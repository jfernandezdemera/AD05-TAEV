package taev.app.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import taev.app.domain.Address;
import taev.app.domain.Course;
import taev.app.domain.Instructor;
import taev.app.domain.InstructorDetail;
import taev.app.domain.Project;
import taev.app.domain.Student;
import taev.app.domain.Tuition;
import taev.app.domain.University;
import taev.app.repository.CourseRepository;
import taev.app.repository.InstructorRepository;
import taev.app.repository.ProjectRepository;
import taev.app.repository.StudentRepository;
import taev.app.repository.TuitionRepository;
import taev.app.repository.UniversityRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	@Autowired
	CourseRepository courseRepository;	

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	TuitionRepository tuitionRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UniversityRepository universityRepository;

	@Autowired
	InstructorRepository instructorRepository;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// Creamos un curso
		Course course = new Course();
		course.setName("Programación");
		course.setCredits("185");
		courseRepository.save(course);
		
		// creamos una direccion
		Address address = new Address("calle1", "calle2", "Sestao", "48910");
		
		// creamos una matricula
		Tuition tuition = new Tuition();
		tuition.setFee(200.0);
		tuitionRepository.save(tuition);
		
		// creamos un estudiante
		Student student = new Student();
		student.setFirstName("estudiante1");
		student.setLastName("apellido1");
		student.setBirthDate(LocalDate.parse("1984-02-03"));
		student.setEmail("estudiante1.apellido1@gmail.com");
		student.getPhones().add("666666666");
		student.setTuition(tuition);
		student.setAddress(address);
		student.getCourses().add(course);
		studentRepository.save(student);
		
		// creamos una universidad
		University university = new University();
		university.setAddress(address);
		university.setName("UPV");
		university.getStudents().add(student);
		universityRepository.save(university);

		// 1- Crea un nuevo instructor y añádele un curso ya creado.
		// Creamos un curso
		Course course2 = new Course();
		course2.setName("Matemáticas aplicadas");
		course2.setCredits("200");
		courseRepository.save(course2);
		Instructor instructor = new Instructor();
		instructor.setFirstName("profesor");
		instructor.setLastName("bacterio");
		instructor.setAddress(address);
		instructor.setEmail("profesor.bacterio@gmail.com");
		// agregamos curso
		instructor.getCourses().add(course2);
		instructorRepository.save(instructor);
		
		// 2- Crea un nuevo objeto Instructor, pero esta vez junto con el objeto Instructor_detail
		Instructor instructor2 = new Instructor();
		instructor2.setAddress(address);
		instructor2.setEmail("instructor2@gmail.com");
		instructor2.setFirstName("instructor");
		instructor2.setLastName("2");
		// creamos un detalle de instructor
		InstructorDetail instructorDetail = new InstructorDetail();
		instructorDetail.setBlog("www.miblog.com");
		instructorDetail.setHobby("running");
		// agregamos detalle de instructor
		instructor2.setInstructorDetail(instructorDetail);
		instructorRepository.save(instructor2);
		
		// 3- Crea un nuevo objeto Project y guárdalo en la BD.
		// creamos un proyecto
		Project project = new Project();
		project.setBudget(200.0);
		project.setField("field1");
		project.setName("name1");
		projectRepository.save(project);
		// creamos un nuevo instructor
		Instructor instructor3 = new Instructor();
		instructor3.setAddress(address);
		instructor3.setEmail("instructor3@gmail.com");
		instructor3.setFirstName("instructor");
		instructor3.setLastName("3");
		// agregamos el proyecto
		instructor3.getProjects().add(project);
		instructorRepository.save(instructor3);	
	}
}
