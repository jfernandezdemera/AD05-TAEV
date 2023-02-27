package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {

}
