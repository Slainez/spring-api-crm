
package fr.m2i.apicrm.model;

import javax.persistence.*;


@Entity
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="type")
    private String type;
    
    @Column(name="label")
    private String label;
    
    @ManyToOne
    @JoinColumn(name = "customer_id " , nullable=false)
    private Customer customer;
    
    @Column(name="number_of_day")
    private Integer numberOfDay;
    
    @Column(name="unit_price")
    private Double unitPrice;
    
    @Column(name="total_exclude_taxe")
    private Double totalExcludeTaxe;
    
    @Column(name="total_with_taxe")
    private Double totalWithTaxe;
    
    @Enumerated(EnumType.STRING)
    @Column(name="status" , columnDefinition="ENUM('CANCELED','OPTION','CONFIRMED')")
    private Status status ;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    
}
