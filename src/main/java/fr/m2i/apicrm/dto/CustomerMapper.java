
package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;


public class CustomerMapper {
    
   public  static CustomerDTO buildCustomerDTO(Customer customer){
        
       CustomerDTO customerDTO = new CustomerDTO() ;
       
       customerDTO.setId(customer.getId() );
       customerDTO.setLastname(customer.getLastname());
       customerDTO.setFirstname(customer.getFirstname());
       customerDTO.setCompany(customer.getCompany());
       customerDTO.setMail(customer.getMail());
       customerDTO.setPhone(customer.getPhone());
       customerDTO.setAddress(customer.getAddress());
       customerDTO.setZipCode(customer.getZipCode());
       customerDTO.setCity(customer.getCity());
       customerDTO.setCountry(customer.getCountry());
       
       if(customer.getState()){
           customerDTO.setState("ACTIF");
       }else{
           customerDTO.setState("INACTIF");
       }
                     
        return   customerDTO ;                       
    } 
    
    
   public static Customer buildCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        
       customer.setId(customerDTO.getId());
       customer.setLastname(customerDTO.getLastname());
       customer.setFirstname(customerDTO.getFirstname());
       customer.setCompany(customerDTO.getCompany());
       customer.setMail(customerDTO.getMail());
       customer.setPhone(customerDTO.getPhone());
       customer.setAddress(customerDTO.getAddress());
       customer.setZipCode(customerDTO.getZipCode());
       customer.setCity(customerDTO.getCity());
       customer.setCountry(customerDTO.getCountry());
       
       if("ACTIF".equals(customerDTO.getState() ) ){
           customer.setState(true);
       }else{
           customer.setState(false);
       }
           
       
       return customer ;
    }
    
    
    public static Customer copy(Customer customer , Customer content){
        
       customer.setId(content.getId());
       customer.setLastname(content.getLastname());
       customer.setFirstname(content.getFirstname());
       customer.setCompany(content.getCompany());
       customer.setMail(content.getMail());
       customer.setPhone(content.getPhone());
       customer.setAddress(content.getAddress());
       customer.setZipCode(content.getZipCode());
       customer.setCity(content.getCity());
       customer.setCountry(content.getCountry());
       customer.setState(content.getState());
       
       
       return customer ;
    }
}
