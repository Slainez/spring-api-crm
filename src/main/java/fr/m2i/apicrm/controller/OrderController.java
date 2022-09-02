
package fr.m2i.apicrm.controller;

import fr.m2i.apicrm.dto.OrderDTO;
import static fr.m2i.apicrm.dto.OrderMapper.buildOrder;
import static fr.m2i.apicrm.dto.OrderMapper.buildOrderDTO;
import fr.m2i.apicrm.exception.NotFoundException;
import fr.m2i.apicrm.model.Order;
import fr.m2i.apicrm.service.IOrderService;
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
public class OrderController {
    
    private IOrderService orderService ;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }
    
    @GetMapping(value="v1/orders" ,  produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrders(){
        
        return new ResponseEntity<>(orderService.findAll(),HttpStatus.OK);
        
    }
    
    @GetMapping(value="v1/orders/{id}" ,  produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrdersById(@PathVariable("id") Long id){
        Order founded = new Order();
        try{
            founded = orderService.findById(id);
        }catch (NotFoundException nfe){
            return new ResponseEntity<>(new NotFoundException("Order was not found !") , HttpStatus.NOT_FOUND);
        }
        
        OrderDTO orderDTO = buildOrderDTO(founded);
        
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
        
    }
    
    
    @PostMapping(value="v1/orders" , consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO){
        
        
        Order order = new Order();
        
        order = buildOrder(orderDTO);
        
        
        try{
            
            orderService.save(order);
            
        }catch(Exception e){
            return new ResponseEntity<>(new Exception("An error has occured !") , HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>("Order succesfully created", HttpStatus.CREATED) ;
    }
    
    
     @PutMapping(value="v1/orders/{id}" , consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Object> modifyOrder(@PathVariable("id") Long id ,  @RequestBody OrderDTO orderDTO){
         
         Order order = new Order();
         order = buildOrder(orderDTO);
         order.setId(id);
        
         try{
             orderService.update(id, order);
             
         }catch(Exception e){
             
            return new ResponseEntity<>(new Exception("An error has occured !") + "Error Not Found" , HttpStatus.NOT_FOUND); 
         }
         
      return new ResponseEntity<>("Order succesfully modified", HttpStatus.NO_CONTENT) ;   
    }
     
     @DeleteMapping("v1/orders/{id}" )
     public ResponseEntity<Object> deleteOrder(@PathVariable("id") Long id  ){
          try{
            
            orderService.delete(id);
            
        } catch(Exception e){
            
             return new ResponseEntity<>("An error has occured during the modification. Process aborted..", HttpStatus.BAD_REQUEST) ;
        }
        
        
        return new ResponseEntity<>("Order succesfully deleted", HttpStatus.NO_CONTENT) ;
     }
}
