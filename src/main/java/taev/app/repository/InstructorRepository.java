package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
