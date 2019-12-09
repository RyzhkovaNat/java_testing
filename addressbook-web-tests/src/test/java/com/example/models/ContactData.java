package com.example.models;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="addressbook")
public class ContactData {
    @Expose
    @Column(name="firstname")
    private String firstName;
    @Expose
    @Column(name="lastname")
    private String lastName;
    @Expose
    @Column(name="address")
    @Type(type="text")
    private String address;
    @Expose
    @Column(name="email")
    @Type(type="text")
    private String email;
    @Expose
    @Column(name="home")
    @Type(type="text")
    private String homePhone;
    @Expose
    @Column(name="work")
    @Type(type="text")
    private String workPhone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(email, that.email) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(allPhones, that.allPhones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, email, homePhone, workPhone, mobilePhone, allPhones, id);
    }

    @Expose
    @Column(name="mobile")
    @Type(type="text")
    private String mobilePhone;
    @Transient
    private String allPhones;
    @Id
    @Column(name="id")
    private int id = Integer.MAX_VALUE;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public int getId() {
        return id;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withHomePhone(String phone) {
        this.homePhone = phone;
        return this;
    }

    public ContactData withMobilePhone(String phone) {
        this.mobilePhone = phone;
        return this;
    }

    public ContactData withWorkPhone(String phone) {
        this.workPhone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
