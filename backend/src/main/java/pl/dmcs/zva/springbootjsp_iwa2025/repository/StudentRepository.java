package pl.dmcs.zva.springbootjsp_iwa2025.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.zva.springbootjsp_iwa2025.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);
}

