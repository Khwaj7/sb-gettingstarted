package fr.khj.gettingstarted.repository;

import fr.khj.gettingstarted.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
