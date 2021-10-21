package com.student.entity;


import javax.persistence.*;

//If you don't specify the name of the table them JPA will automatically add the name of the table by giving it the class name
//And the if not specify the field name as the column name them JPA will automatically add the name of the column depending on the name of the field
@Entity
@Table(name = "students")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long ID;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        //The default constructor
        public Student() {

        }

        //The constructor
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //The getter and setter methods
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
