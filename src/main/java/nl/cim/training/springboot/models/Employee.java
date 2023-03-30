package nl.cim.training.springboot.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID",
            nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME",
            length = 512,
            nullable = false)
    private String firstName;

    @Column(name = "MIDDLE_NAME",
            length = 512)
    private String middleName;
    @Column(name = "LAST_NAME",
            length = 512,
            nullable = false)
    private String lastName;
    @Column(name = "EMAIL",
            length = 512,
            nullable = false)
    private String email;

    @Column(name = "FUNC_GROUP",
            nullable = false)
    private Double funcGroup;
    @Column(name = "SALARY",
            nullable = false,
            precision = 6)
    private Double salary;


    @Column(name = "DOB",
            nullable = false,
            precision = 6)

    private LocalDate dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public Double getFuncGroup() {
        return funcGroup;
    }

    public void setFuncGroup(Double funcGroup) {
        this.funcGroup = funcGroup;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public Employee(String firstName, String middleName, String lastName, String email, Double funcGroup, Double salary, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.funcGroup = funcGroup;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;

    }



    public Employee(){

    }

}
