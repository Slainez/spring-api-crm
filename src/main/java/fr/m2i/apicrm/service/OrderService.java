
package fr.m2i.apicrm.service;

import fr.m2i.apicrm.dto.OrderMapper;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.repository.OrderRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    
     private final OrderRepository  repoOrder ;

    @Autowired
    public OrderService(OrderRepository repoOrder) {
        this.repoOrder = repoOrder;
    }

    @Override
    public List<Order> findAll() {
        return repoOrder.findAll();
    }

    @Override
    public Order findById(Long id) throws NotFoundException {
        return repoOrder.findById(id).orElseThrow(()-> new NotFoundException("Order not found"));
    }

    @Override
    public void save(Order order) throws Exception {
        repoOrder.save(order);
    }

    @Override
    public void update(Long id, Order order) throws Exception {
        Order toUpdate = repoOrder.findById(id).orElseThrow(()-> new NotFoundException("Order not found"));
        
        OrderMapper.copy(toUpdate, order);
        
        repoOrder.save(toUpdate);
    }

    @Override
    public void delete(Long id) throws Exception {
       repoOrder.deleteById(id);
    }
 
    
}
