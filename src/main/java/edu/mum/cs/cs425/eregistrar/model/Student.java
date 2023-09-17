package edu.mum.cs.cs425.eregistrar.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long studentId;

    @Column(nullable = false)
    String studentNumber;

    @Column(nullable = false)
    String firstName;

    String middleName;

    @Column(nullable = false)
    String lastName;

    double cgpa;

    @Column(nullable = false)
    Date dateOfEnrollment;

    @Column(nullable = false)
    boolean isInternational;

    public Student() {
    }

    public Student(String studentNumber, String firstName, String lastName, Date dateOfEnrollment, boolean isInternational) {
        setStudentNumber(studentNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfEnrollment(dateOfEnrollment);
        setIsInternational(isInternational);
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, Date dateOfEnrollment, boolean isInternational) {
        this(studentNumber, firstName, lastName, dateOfEnrollment, isInternational);
        setMiddleName(middleName);
        setCgpa(cgpa);
        setDateOfEnrollment(dateOfEnrollment);
    }

    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Date getDateOfEnrollment() {
        return this.dateOfEnrollment;
    }

    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public boolean getIsInternational() {
        return this.isInternational;
    }

    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }
}
