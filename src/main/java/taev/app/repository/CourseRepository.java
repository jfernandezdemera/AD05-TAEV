package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
