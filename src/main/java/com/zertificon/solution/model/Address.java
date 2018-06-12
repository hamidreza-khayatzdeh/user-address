package com.zertificon.solution.model;

import javax.persistence.*;

/**
 * Created by hamidreza on 6/12/2018.
 */
@Entity
@Table(name = "ADDRESS")
public class Address extends Auditable<String> {

    private Long id;
    private String location;
    private String phoneNo;
    private String email;
    private String postalCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "LOCATION", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "PHONE_NO", nullable = false)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Column(name = "EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (!location.equals(address.location)) return false;
        if (!phoneNo.equals(address.phoneNo)) return false;
        if (!email.equals(address.email)) return false;
        return postalCode != null ? postalCode.equals(address.postalCode) : address.postalCode == null;
    }

    @Override
    public int hashCode() {
        int result = location.hashCode();
        result = 31 * result + phoneNo.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
}
