package com.examples.webshop.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 8343759915060442142L;

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="ADDRESS_LINE1")
    private String line1;

    @Column(name="ADDRESS_LINE2")
    private String line2;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="POSTAL_CODE")
    private Integer postalCode;

    @Column(name="IS_BILLING")
    private Boolean billing;

    @Column(name="IS_SHIPPING")
    private Boolean shipping;

    @Column(name="USER_ID")
    private Integer userId;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode=" + postalCode +
                ", billing=" + billing +
                ", shipping=" + shipping +
                '}';
    }
}
