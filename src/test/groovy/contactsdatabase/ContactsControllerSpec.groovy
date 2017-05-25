package contactsdatabase

import com.contactsdatabase.Role
import com.contactsdatabase.User
import com.contactsdatabase.UserRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovy.mock.interceptor.MockFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ContactsController)
@Mock([SpringSecurityService, Contacts2, User, Role, UserRole])
class ContactsControllerSpec extends Specification {
    void "test save"() {
        given:
        params.firstName = 'dem'
        params.lastName = 'dem'
        params.email = 'deo@gmail.com'
        params.phoneNumber = '942521286'
        params.markData = "Favourite"
        params.date = "2017-03-03"
//        def mockService = new MockFor(SpringSecurityService)
//        mockService.demand.getCurrentUser {
            User userInstance = new User(username: "himani1@gmail.com", password: "hima04")
//            return userInstance
//        }

        when:
        params.userInstance = springSecurityService.currentUser
        params.dob = Date.parse("yyyy-MM-dd", params.date)
        controller.save()

        then:
        flash.message == "Contact details have been successfully saved!!!"
        response.redirectUrl == '/contacts/list'
    }
}
