import com.causecode.user.Role
import com.causecode.user.User
import com.causecode.user.UserRole

class BootStrap {

    def init = { servletContext ->

        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        def user = new User(username: 'demoa@gmail.com', password: 'demo').save(flush: true)

        UserRole.create user, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }
    }
    def destroy = {
    }
}
