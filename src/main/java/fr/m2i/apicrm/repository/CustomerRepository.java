
package fr.m2i.apicrm.repository;

import fr.m2i.apicrm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository< Customer, Long>{
    
}
