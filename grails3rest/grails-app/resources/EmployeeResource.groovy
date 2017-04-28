import com.jft.praveen.EmployeeWS
import grails.converters.JSON
import grails.converters.XML
import grails3rest.Employee
import grails3rest.EmployeeService
import org.apache.catalina.connector.Response

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces

@Path('/api/employee')
class EmployeeResource {
    EmployeeService employeeService

    @GET
    @Produces(['application/json'])
    String getEmployees() {
        return employeeService.getEmployee() as JSON
    }

    @POST
    @Path('/update')
    @Consumes(['application/json'])
    @Produces(['application/json'])
    String updateEmployee(EmployeeWS employee) {
        Employee oldEmployee = employeeService.showEmployee(employee.id)
        Employee emp = employeeService.updateEmployee(employee.populateEmployee(oldEmployee))
        if (emp != null) {
            emp as JSON
        } else {
            return Response.SC_NOT_FOUND
        }
    }

    @DELETE
    @Path('/delete/{id}')
    @Produces(['application/json'])
    int deleteEmployees(@PathParam("id") long id) {
        int status = employeeService.deleteEmployee(id)
        return status
    }

    @GET
    @Path('/show/{id}')
    @Produces(['application/json'])
    String showEmployee(@PathParam("id") long id) {
        Employee employee = employeeService.showEmployee(id)
        if (employee != null) {
           return employeeService.showEmployee(id) as JSON
        } else {
            Response.SC_NOT_FOUND
        }
    }

    @POST
    @Path('/create')
    @Consumes(['application/json'])
    @Produces(['application/json'])
    String createEmployee(Employee employee) {
        employeeService.addEmployee(employee)
        return employee as JSON
    }
}