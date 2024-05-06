package nicholasboari.com.attusteste.repository;

import nicholasboari.com.attusteste.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    Page<Address> findAddressByPersonId(Pageable pageable, String personId);
}
