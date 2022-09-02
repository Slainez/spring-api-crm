
package fr.m2i.apicrm.service;


import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.repository.CustomerRepository;
import static fr.m2i.apicrm.dto.CustomerMapper.copy;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    
    private final CustomerRepository  repoCustomer ;

    @Autowired
    public CustomerService(CustomerRepository repoCustomer) {
        this.repoCustomer = repoCustomer;
    }

    @Override
    public List<Customer> findAll() {
       return repoCustomer.findAll();
    }

    @Override
    public Customer findById(Long id) {
        
     return repoCustomer.findById(id).orElseThrow(()-> new NotFoundException("Customer with id : " + id + " was not found."));
     
    }

    @Override
    public void save(Customer customer) throws Exception{
        
               
        repoCustomer.save(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        
       Customer toUpdate = repoCustomer.findById(id).orElseThrow( ()-> new NotFoundException("Customer with id : " + id + " was not found."));
       
       copy(toUpdate , customer);
       
       repoCustomer.save(toUpdate);
    }

    @Override
    public void delete(Long id) {
        repoCustomer.deleteById(id);
    }
    
    
    
}
