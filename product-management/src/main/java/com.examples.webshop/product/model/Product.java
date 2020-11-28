package com.examples.webshop.product.model;

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
@Table(name="PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 8429895232221464470L;

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    @Column(name="BRAND")
    private String brand;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="UNIT_PRICE")
    private Double unitPrice;

    @Column(name="QUANTITY")
    private Integer quantity;

    @Column(name="IS_ACTIVE")
    private Boolean active;

    @Column(name="CATEGORY_ID")
    private Integer categoryId;

    @Column(name="SUPPLIER_ID")
    private Integer supplierId;

    @Column(name="PURCHASES")
    private Integer purchases;

    @Column(name="VIEWS")
    private Integer views;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", active=" + active +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                ", purchases=" + purchases +
                ", views=" + views +
                '}';
    }
}
