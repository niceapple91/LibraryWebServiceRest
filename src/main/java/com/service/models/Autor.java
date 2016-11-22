package com.service.models;

/**
 * Created by Olha_Pidhorna on 7/20/2016.
 */
public class Autor {

    private String firstName;
    private String lastName;
    private int id;

    @Override
    public String toString() {
        return "Autor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Autor() {

    }

    public Autor(String firstName, String lastName, int id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}
