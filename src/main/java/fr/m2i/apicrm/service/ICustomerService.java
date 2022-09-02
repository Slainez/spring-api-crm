
package fr.m2i.apicrm.service;


import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Customer;
import java.util.List;


public interface ICustomerService {
    
    List<Customer> findAll() ;
    
    Customer findById(Long id) throws NotFoundException ;
    
    void save(Customer customer) throws Exception ;    
    void update(Long id , Customer customer) throws Exception;
    void delete(Long id) throws Exception;
    
}
