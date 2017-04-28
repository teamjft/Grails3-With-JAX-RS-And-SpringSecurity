package grails3rest

import com.grails3rest.security.Role
import com.grails3rest.security.User
import com.grails3rest.security.UserRole

class BootStrap {

    def init = { servletContext ->
        10.times {
            new Employee("Name${it}", "Last${it}", 908989894, "email@mail.com", "city",  "state", "country").save()
        }
        if (!Role.findAllByAuthority('ROLE_ADMIN')) {
            ['ROLE_ADMIN', 'ROLE_USER'].each {
                Role.findByAuthority(it) ?: new Role(authority: it).save(flush: true, failOnError: true)
            }
        }
        if (!Role.findAllByAuthority('ROLE_USER')) {
            ['ROLE_ADMIN', 'ROLE_USER'].each {
                Role.findByAuthority(it) ?: new Role(authority: it).save(flush: true, failOnError: true)
            }
        }
        //create some default user with role ROLE_ADMIN, ROLE_USER
        if(User.count == 0) {
            // User with admin role
            User admin = new User(username: 'admin', email: 'admin@testapp.com', password: 'password', activated: true, enabled: true).save(flush: true, failOnError: true)
            // User with User role ;)
            User user = new User(username: 'praveen', email: 'user@testapp.com', password: 'password', activated: true, enabled: true).save(flush: true, failOnError: true)
            new UserRole(user: admin, role: Role.findByAuthority('ROLE_ADMIN')).save(flush: true, failOnError: true)
            new UserRole(user: user, role: Role.findByAuthority('ROLE_USER')).save(flush: true, failOnError: true)
        }

        User user =  User.findByUsername("admin")
        UserRole userRole= UserRole.findByUser(user);
        println userRole
    }
    def destroy = {
    }
}
