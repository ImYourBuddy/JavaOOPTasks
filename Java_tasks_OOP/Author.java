package com.mycompany.firsttask.library;

import java.util.Objects;

/**
 * This class describe the author of the book for Book class
 */
public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        boolean nameEquals = (name == null && author.name == null)
                || (name != null && name.equals(author.name));
        boolean emailEquals = (email == null && author.email == null)
                || (email != null && email.equals(author.email));
        boolean genderEquals = (gender == author.gender);
        return nameEquals && emailEquals && genderEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (email == null ? 0 : email.hashCode());
        result = 31 * result + (int) gender;
        return result;
    }
}
