package contactsdatabase

import com.contactsdatabase.Role
import com.contactsdatabase.User
import com.contactsdatabase.UserRole
import grails.plugin.springsecurity.annotation.Secured

class SignupController {

    @Secured('permitAll')
    def index() {
        println "^^^^^^^^"
    }

    @Secured('permitAll')
    def saving() {

        println params

        User userInstance = User.findByUsername("params.username")

        if (!userInstance) {
            userInstance = new User([username: params.username, password: params.password])
            userInstance.save()

            println "^^^^^+++++^^^"

            Role roleAdmin = Role.findByAuthority('ROLE_ADMIN')
            println roleAdmin
            UserRole.create(userInstance, roleAdmin)
            Role roleUser = Role.findByAuthority('ROLE_USER')
            println roleUser
            UserRole.create(userInstance, roleUser)

            redirect(controller: 'login', action: 'index')
        }
    }


}
