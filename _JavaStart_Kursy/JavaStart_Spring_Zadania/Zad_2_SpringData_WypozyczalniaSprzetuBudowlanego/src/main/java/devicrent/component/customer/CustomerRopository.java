package devicrent.component.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRopository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByPesel(String pesel);
}
