package grails3rest

class Employee {

    String firstName
    String lastName
    String email
    Long mobile
    String state
    String city
    String country

    Employee(String firstName, String lastName, Long mobile, String email, String city, String state, String country) {

        this.firstName = firstName
        this.lastName = lastName
        this.mobile = mobile
        this.email =email
        this.state =state
        this.city =city
        this.country =country
    }

    static constraints = {

    }
}
