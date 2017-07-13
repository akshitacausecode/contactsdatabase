package contactsdatabase

import com.causecode.user.Role
import com.causecode.user.User
import com.causecode.user.UserRole
import grails.plugin.springsecurity.annotation.Secured

class SignupController {

    def springSecurityService

    @Secured('permitAll')
    def index() {

        if (springSecurityService.isLoggedIn()) {
            redirect(controller: 'Contacts', action: 'index')
        }
        [user: new Contacts2()]
    }

    @Secured('permitAll')
    def save() {

        User userInstance = User.findByUsername("params.username")

        if (!userInstance) {
            userInstance = new User([username: params.username, password: params.password])
            userInstance.save()

            if (userInstance.hasErrors()) {
                render(view: '/signup/index', model: [user: userInstance])
                return
            }

            Role roleUser = Role.findByAuthority('ROLE_USER')
            UserRole.create(userInstance, roleUser)

            flash.message = "Welcome!\nYour username is: ${userInstance.username}" + "\n please login to continue"
            redirect(controller: 'login', action: 'auth')
            }
        }
    }
