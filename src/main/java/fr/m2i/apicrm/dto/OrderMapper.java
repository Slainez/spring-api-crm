
package fr.m2i.apicrm.dto;

import static fr.m2i.apicrm.dto.CustomerMapper.buildCustomer;
import static fr.m2i.apicrm.dto.CustomerMapper.buildCustomerDTO;
import fr.m2i.apicrm.model.Order;


public class OrderMapper {
    
    public static OrderDTO buildOrderDTO(Order order){
        
        OrderDTO orderDTO = new OrderDTO() ;
        
        orderDTO.setId(order.getId());
        orderDTO.setType(order.getType());
        orderDTO.setLabel(order.getLabel());
        orderDTO.setCustomerDTO(buildCustomerDTO(order.getCustomer()));
        orderDTO.setNumberOfDay(order.getNumberOfDay());
        orderDTO.setUnitPrice(order.getUnitPrice());
        orderDTO.setTotalExcludeTaxe(order.getTotalExcludeTaxe());
        orderDTO.setTotalWithTaxe(order.getTotalWithTaxe());
        
        
        if("CANCELED".equals(order.getStatus())){
            orderDTO.setStatus("CANCELED");
        }else if("OPTION".equals(order.getStatus())){
            
             orderDTO.setStatus("OPTION");
        }else{
             orderDTO.setStatus("CONFIRMED");
        }
      
        return orderDTO ;
        
    }
    
    public static Order buildOrder(OrderDTO orderDTO){
        
        Order order = new Order() ;
        
        order.setId(orderDTO.getId());
        
        order.setType(orderDTO.getType());
        
        order.setLabel(orderDTO.getLabel());
        
        order.setCustomer(buildCustomer(orderDTO.getCustomerDTO()));
        
        order.setNumberOfDay(orderDTO.getNumberOfDay());
        order.setUnitPrice(orderDTO.getUnitPrice());
        order.setTotalExcludeTaxe(orderDTO.getTotalExcludeTaxe());
        order.setTotalWithTaxe(orderDTO.getTotalWithTaxe());
        
        
        if("CANCELED".equals(order.getStatus())){
            orderDTO.setStatus("CANCELED");
        }else if("OPTION".equals(order.getStatus())){
            
             orderDTO.setStatus("OPTION");
        }else{
             orderDTO.setStatus("CONFIRMED");
        }
      
        return order ;
        
    }
    
    public static Order copy(Order order , Order content){
        
        if(content == null){
            return new Order();
        }
        
        if(content.getId() != null ){
            order.setId(content.getId());
        }
        
        if(content.getType() != null ){
            order.setType(content.getType());
        }
        
        if(content.getLabel () != null ){
            order.setLabel(content.getLabel());
        }
        
        if(content.getCustomer() != null ){
            order.setCustomer(content.getCustomer());
        }
        
        if(content.getNumberOfDay()!= null ){
            order.setNumberOfDay(content.getNumberOfDay());
        } 
        
        if(content.getUnitPrice() != null ){
            order.setUnitPrice(content.getUnitPrice());
        }
        
        if(content.getTotalExcludeTaxe() != null ){
            order.setTotalExcludeTaxe(content.getTotalExcludeTaxe());
        }
        
        if(content.getTotalWithTaxe() != null ){
            order.setTotalWithTaxe(content.getTotalWithTaxe());
        }
        
        if(content.getStatus() != null ){
            order.setStatus(content.getStatus());
        }
        
        
        return order ;
    }
    
}
