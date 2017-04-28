package grails3rest

import com.sun.org.apache.regexp.internal.RE
import grails.converters.JSON
import grails.transaction.Transactional
import org.apache.catalina.connector.Response
import org.springframework.security.access.annotation.Secured

@Transactional
class EmployeeService {

    List<Employee> getEmployee() {
        return Employee.list()
    }

    def addEmployee(Employee employee){
        employee.save()
        return employee
    }
    def updateEmployee(Employee employee) {
        println "employee Id==${employee.id}"
        employee.save(flush:true)
        return employee
    }
    int deleteEmployee(long id) {
        Employee employee = Employee.get(id)
        if (employee != null) {
            employee.delete()
            Response.SC_OK
        } else {
            Response.SC_NOT_FOUND
        }

    }

    Employee showEmployee(Long id) {
        Employee employee = Employee.findById(id)
        return employee
    }
}
