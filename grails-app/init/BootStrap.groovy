import com.contactsdatabase.Role
import com.contactsdatabase.User
import com.contactsdatabase.UserRole

class BootStrap {

    def init = { servletContext ->

        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        def user = new User(username: 'demo@gmail.com', password: 'demo').save(flush: true)

        UserRole.create user, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    def destroy = {
    }
}
