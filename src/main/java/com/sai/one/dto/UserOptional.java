package com.sai.one.dto;

import java.util.Optional;

/**
 * @author shravan
 */
public class UserOptional implements Entity {

    private Optional<Integer> id;
    private Optional<String> firstName;
    private Optional<String> lastName;
    private Optional<String> email;
    private Optional<String> password;

    public Optional<Integer> getId() {
        return id;
    }

    public void setId(Optional<Integer> id) {
        this.id = id;
    }

    public Optional<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(Optional<String> firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public Optional<String> getPassword() {
        return password;
    }

    public void setPassword(Optional<String> password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", password=" + password + "]";
    }

}