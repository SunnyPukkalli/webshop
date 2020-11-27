package com.examples.webshop.cart.model;

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
@Table(name="LINE_ITEMS")
public class LineItems implements Serializable {

    private static final long serialVersionUID = 263045184016860559L;

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="PRODUCT_ID")
    private Integer productId;

    @Column(name="CART_ID")
    private Integer cartId;

    @Column(name="TOTAL_AMOUNT")
    private Double totalAmount;

    @Column(name="COUNT")
    private Integer count;

    @Column(name="IS_AVAILABLE")
    private Boolean available;


    @Override
    public String toString() {
        return "LineItems{" +
                "id=" + id +
                ", productId=" + productId +
                ", cartId=" + cartId +
                ", totalAmount=" + totalAmount +
                ", count=" + count +
                ", available=" + available +
                '}';
    }
}
