package pl.dmcs.zva.springbootjsp_iwa2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.zva.springbootjsp_iwa2025.model.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
Team findById(long id);
}
