package contactsdatabase

import com.contactsdatabase.Role
import com.contactsdatabase.User
import com.contactsdatabase.UserRole
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */

@TestFor(SignupController)
@Mock([User, Role, UserRole])
class SignupControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    void 'test signup'() {

        given:
        params.username='hema@gmail.com'
        params.password='hema04'

        when:
        request.method='POST'
        params.checkUser= 1
        controller.save()

        then:
        response.redirectUrl == '/login/auth'
    }
}