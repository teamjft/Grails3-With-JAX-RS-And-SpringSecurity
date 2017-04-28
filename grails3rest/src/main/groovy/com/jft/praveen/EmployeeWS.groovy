package com.jft.praveen

import grails3rest.Employee

class EmployeeWS {
    Long id
    String firstName
    String lastName
    String email
    Long mobile
    String state
    String city
    String country

    EmployeeWS() {
    }

    Employee populateEmployee(Employee employee) {
        employee.firstName = this.firstName
        employee.lastName = this.lastName
        employee.email = this.email

        employee.mobile = this.mobile
        employee.state = this.state
        employee.city = this.city
        employee.country = this.country
        return employee
    }
}
