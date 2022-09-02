
package fr.m2i.apicrm.dto;


public class CustomerDTO {
   
    private Long id;  
    
    private String lastname;    
  
    private String firstname;    
   
    private String company;    
   
    private String mail;    
    
    private String phone;    
   
    private String address;    
    
    private String zipCode;    
    
    private String city;    
    
    private String country;    
   
    private String state;
    
//    @Column(name="orders")
//    private List orders;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String lastname, String firstname, String company, String mail, String phone, String address, String zipCode, String city, String country, String state) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.company = company;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.state = state;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
