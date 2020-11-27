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
@Table(name="USER")
public class User implements Serializable {

    private static final long serialVersionUID = 734261697948189191L;

    @Id
    @Column(name="ID")
    private Integer id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="CONTACT_NUMBER")
    private String contactNumber;

    @Column(name="ROLE")
    private String role;

    @Column(name="ENABLED")
    private Boolean enabled;

    @Column(name="PASSWORD")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", role='" + role + '\'' +
                ", enabled=" + enabled +
                ", password='*****' "+
                '}';
    }
}
