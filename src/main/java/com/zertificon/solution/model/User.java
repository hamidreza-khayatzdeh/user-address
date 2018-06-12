package com.zertificon.solution.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hamidreza on 6/12/2018.
 */
@Entity
@Table(name = "USER")
public class User extends Auditable<String> {

    public enum Status {
        ACTIVATED('a'),
        DEACTIVATED('d');

        private Character value;

        Status(Character val) {
            this.value = val;
        }

        public Character value() {
            return this.value;
        }
    }

    private Long id;
    private String firstName;
    private String lastName;
    private Status status;
    private Set<Address> addresses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany
    @JoinTable(name = "USER_ADDRESS_REL",
            joinColumns = {@JoinColumn(name = "USER_ID_FK")},
            inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID_FK")}
    )
    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Column(name = "STATUS", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @PrePersist
    private void onPreInsert() {
        this.status = Status.ACTIVATED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        return status == user.status;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
