
package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.CustomerDTO;
import static fr.m2i.apicrm.dto.CustomerMapper.buildCustomer;
import static fr.m2i.apicrm.dto.CustomerMapper.buildCustomerDTO;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.service.ICustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    private ICustomerService customerService ;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }
    
    @GetMapping(value ="/v1/customers" , produces=MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<Object> getCustomersList() {
        
        List<Customer> customersList = customerService.findAll();
        
        if(customersList.isEmpty()){
            return new ResponseEntity<>("No customers in database", HttpStatus.NOT_FOUND) ;
        }
        
        List<CustomerDTO> dtosCustomersList = new ArrayList();
        
        for(Customer customer : customersList){
            dtosCustomersList.add(buildCustomerDTO(customer));
        }
        
        return new ResponseEntity<>(dtosCustomersList, HttpStatus.OK) ;
    } 
    
    @GetMapping(value ="/v1/customers/{id}" , produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id){
        
        Customer customer = new Customer();
        
        try{
            
           customer = customerService.findById(id); 
           
        }catch (NotFoundException nfe){
           
            return new ResponseEntity<>("Customer with id " + id + " was not found", HttpStatus.NOT_FOUND) ;
        }
        
        CustomerDTO customerDto = buildCustomerDTO(customer) ;
         
        return new ResponseEntity<>(customerDto, HttpStatus.OK) ;
                
    }
    
    @PostMapping(value ="/v1/customers" , consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody CustomerDTO customerDTO) {
        
        Customer customer = new Customer () ;
        customer = buildCustomer(customerDTO);
                
        try{
            
            customerService.save(customer);
            
        } catch(Exception e){
            
            return new ResponseEntity<>("An error has occured during the creation. Process aborted..", HttpStatus.BAD_REQUEST) ;
            
        }
        
        
        return new ResponseEntity<>("Customer succesfully created", HttpStatus.CREATED) ;
    }
    
    @PutMapping(value="v1/customers/{id}" , consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> update(@PathVariable("id") Long id ,@RequestBody CustomerDTO customerDTO) {
        
        Customer customer = new Customer () ;
        customer = buildCustomer(customerDTO);
        customer.setId(id);
                
        try{
            
            customerService.update(id ,customer);
            
        } catch(Exception e){
            
              return new ResponseEntity<>("An error has occured during the modification. Process aborted..", HttpStatus.NOT_MODIFIED) ;
        }
        
        
        return new ResponseEntity<>("Customer succesfully created", HttpStatus.NO_CONTENT) ;
        
    }
    
     @DeleteMapping("v1/customers/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id ) {
                
        try{
            
            customerService.delete(id);
            
        } catch(Exception e){
            
             return new ResponseEntity<>("An error has occured during the modification. Process aborted..", HttpStatus.BAD_REQUEST) ;
        }
        
        
        return new ResponseEntity<>("Customer succesfully deleted", HttpStatus.NO_CONTENT) ;
    }
    
    
}
