import com.contactsdatabase.Role
import com.contactsdatabase.User
import com.contactsdatabase.UserRole

class BootStrap {

    def init = { servletContext ->

        List<String> roles = ["ROLE_ADMIN", "ROLE_USER"]
        roles.each { roleName ->
            Role.findOrSaveByAuthority(roleName)
        }

        User userInstance = User.findByUsername("admin")
        if(!userInstance) {
            userInstance = new User([username: "admin", password: "admin"])
            userInstance.save()
            Role roleAdmin = Role.findByAuthority('ROLE_ADMIN')
            println roleAdmin
            UserRole.create(userInstance, roleAdmin)
            Role roleUser = Role.findByAuthority('ROLE_USER')
            println roleUser
            UserRole.create(userInstance, roleUser)
        }

    }
    def destroy = {
    }
}
