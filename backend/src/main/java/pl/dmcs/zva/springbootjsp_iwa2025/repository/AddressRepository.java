package pl.dmcs.zva.springbootjsp_iwa2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.zva.springbootjsp_iwa2025.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{
Address findById(long id);
}
