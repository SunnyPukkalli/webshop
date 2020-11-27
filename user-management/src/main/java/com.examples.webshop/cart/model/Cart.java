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
@Table(name="CART")
public class Cart implements Serializable {

    private static final long serialVersionUID = 263045184016860559L;

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="USER_ID")
    private Integer userId;

    @Column(name="GRAND_TOTAL")
    private Double grandTotal;

    @Column(name="TOTAL_COUNT")
    private Integer totalCount;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", grandTotal=" + grandTotal +
                ", totalCount=" + totalCount +
                '}';
    }

}
