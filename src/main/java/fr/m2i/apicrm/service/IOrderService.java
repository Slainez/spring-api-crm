
package fr.m2i.apicrm.service;

import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import java.util.List;


public interface IOrderService {
    
    List<Order> findAll() ;
    
    Order findById(Long id) throws NotFoundException ;
    
    void save(Order order) throws Exception ;    
    void update(Long id , Order order) throws Exception;
    void delete(Long id) throws Exception;
}
