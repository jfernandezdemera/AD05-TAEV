package taev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import taev.app.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
