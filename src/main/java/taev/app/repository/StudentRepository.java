package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
