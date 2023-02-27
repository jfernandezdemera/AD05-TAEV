package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.Tuition;

public interface TuitionRepository extends JpaRepository<Tuition, Integer> {

}
