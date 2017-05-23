package contactsdatabase

import com.contactsdatabase.Role
import com.contactsdatabase.User
import com.contactsdatabase.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class SignupController {

    def springSecurityService

    @Secured('permitAll')
    def index() {

        println(springSecurityService.isLoggedIn())
        if (springSecurityService.isLoggedIn()) {
            redirect(controller: 'Contacts', action: 'index')
        }

        println "enters signup/index"
        [user: new Contacts()]
    }

    @Secured('permitAll')
    def saving() {

        println params
        User userInstance = User.findByUsername("params.username")

        if (!userInstance) {
            userInstance = new User([username: params.username, password: params.password])
            userInstance.save()
            println params.errors

            if (userInstance.hasErrors()) {
                render(view: '/signup/index', model: [user: userInstance])
                return
            }
            println "no errors"

            Role roleUser = Role.findByAuthority('ROLE_USER')
            println roleUser
            UserRole.create(userInstance, roleUser)

            flash.message = "Welcome!\nYour username is: ${userInstance.username}" + "\n please login to continue"
            redirect(controller: 'login', action: 'auth')
            }
        }
    }
