package com.company.model.problem;

public class Debtor {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Salary salary;
    private Education education;
    private TypeOfEmployment typeOfEmployment;
    private Age age;
    private Boolean loanWasRepaid;

    public Debtor(String[] fields) {
        this(fields[0], fields[1], Gender.valueOf(fields[2]), Salary.valueOf(fields[3]), Education.valueOf(fields[4]),
                TypeOfEmployment.valueOf(fields[5]), Age.valueOf(fields[6]), fields.length > 7 ? Boolean.valueOf(fields[7]) : null);
    }

    public Debtor(String firstName, String lastName, Gender gender, Salary salary, Education education,
                  TypeOfEmployment typeOfEmployment, Age age, Boolean loanWasRepaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.salary = salary;
        this.education = education;
        this.typeOfEmployment = typeOfEmployment;
        this.age = age;
        this.loanWasRepaid = loanWasRepaid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Salary getSalary() {
        return salary;
    }

    public Education getEducation() {
        return education;
    }

    public TypeOfEmployment getTypeOfEmployment() {
        return typeOfEmployment;
    }

    public Age getAge() {
        return age;
    }

    public Boolean getLoanWasRepaid() {
        return loanWasRepaid;
    }

    public void setLoanWasRepaid(Boolean loanWasRepaid) {
        this.loanWasRepaid = loanWasRepaid;
    }

    @Override
    public String toString() {
        return "\nDebtor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", education=" + education +
                ", typeOfEmployment=" + typeOfEmployment +
                ", age=" + age +
                ", loanWasRepaid=" + loanWasRepaid +
                "}";
    }
}
