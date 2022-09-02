
package fr.m2i.apicrm.dto;


public class OrderDTO {   
     
    
    private Long id;    
  
    private String type;    
    
    private String label;    
    
    private CustomerDTO customerDTO;    
    
    private Integer numberOfDay;    
    
    private Double unitPrice;    
  
    private Double totalExcludeTaxe;    
 
    private Double totalWithTaxe;    
    
    private String status ;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String type, String label, CustomerDTO customerDTO, Integer numberOfDay, Double unitPrice, Double totalExcludeTaxe, Double totalWithTaxe, String status) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.customerDTO = customerDTO;
        this.numberOfDay = numberOfDay;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
