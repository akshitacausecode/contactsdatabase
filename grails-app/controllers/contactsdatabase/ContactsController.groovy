package contactsdatabase

import com.causecode.RestfulController
import com.causecode.user.User
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService

//import java.text.SimpleDateFormat
//import java.util.Date
//import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ContactsController extends RestfulController {

    SpringSecurityService springSecurityService

    static namespace = 'v1'

    ContactsController() {
        super(Contacts2)
    }

    @Override
    @Secured(['permitAll'])
    def index() {

        //User userInstance = SpringSecurityService.get(springSecurityService.principal.id)
//        User userInstance = springSecurityService.getCurrentUser()
//        [user: userInstance]
    }

    @Secured(['permitAll'])
    def addContact() {

        //[user: new Contacts2()]
    }

    @Secured(["permitAll"])
    def save() {
        //User userInstance = springSecurityService.getCurrentUser()
        //params.userInstance = userInstance
        params.putAll(request.JSON)
        def contactPresent = Contacts2.createCriteria().get {
            and {
                    //eq("userInstance", userInstance)
                    eq("email", "${params.email}")
                    eq("phoneNumber", "${params.phoneNumber}")
            }
        }
        if (contactPresent) {
            Contacts2 contactsInstance = new Contacts2(params)
            flash.error = "This Contact is already present in your account"
            //render(view: '/contacts/addContact', model: [user: contactsInstance])
            render 'already present'

        }
        else {
            //params.dob = Date.parse("yyyy-MM-dd", params.date)
            Contacts2 contactsInstance = new Contacts2(params)

            contactsInstance.save() //saves to database
            if (contactsInstance.hasErrors()) {                   //to check errors
                render "errors"
                // render(view: '/contacts/addContact', model: [user: contactsInstance])
                //return
            }
            //flash message is displayed when values are stored into database
            flash.message = "Contact details have been successfully saved!!!"
            //redirect(action: "list")

        render 'pass'

        }
    }

    @Secured(['permitAll'])
    def list() {

        def currentuser= springSecurityService.currentUser
        List contacts = Contacts2.findAllByUserInstance(currentuser)
            //[allCreatedContacts: Contacts2.list(sort:"firstName")]
        [allCreatedContacts: contacts]
    }

    @Secured(["permitAll"])
    def edit() {

        def editContact = Contacts2.get(params.id)
        [editContact: editContact]
    }

    @Secured(["permitAll"])
    def update() {

        params.putAll(request.JSON)
        if (params.id) {
            Contacts2 updateContact = Contacts2.get(params.id)
            updateContact.firstName = params.firstName
            updateContact.lastName = params.lastName
            updateContact.email = params.email
            updateContact.markData = params.markData
            updateContact.phoneNumber = params.phoneNumber
            updateContact.save(flush: true)
            if (updateContact.hasErrors()) {
                render updateContact.errors as JSON
//                [editContact: updateContact]
//                render(view: '/contacts/edit', model: [user: updateContact, editContact:updateContact])
//                return
            } else {
                def results = Contacts2.findAllById("${updateContact.id}")
                respond([result: results])
            }
        }else {
            def message = [['message' : 'please enter a valid value']]
            render message as JSON
        }
    }

    @Secured(["permitAll"])
    def show() {

        if (params.id) {
            Contacts2 showValue = Contacts2.get(params.id)
            respond([result: showValue])
        }else {
            def message = ['message': 'please give a valid parameter']
            render message as JSON
        }
//            Contacts2 contactDisplay = Contacts2.get(id)
//            return [contactDisplay: contactDisplay]
    }

    @Secured(["permitAll"])
    def delete() {

        if (params.id) {
            if (Contacts2.get(params.id)) {
                Contacts2 deleteValue = Contacts2.get(params.id)
                deleteValue.delete(flush: true)
                def message = [['result': 'value deleted']]
                render message as JSON
            }else {
                def message = ['message': 'Value not present in the database, nothing to delete']
                render message as JSON
            }
        } else {
            def message = ['message': 'please give a valid parameter']
            render message as JSON
        }
        //redirect(action: 'list')
    }

    @Secured(["permitAll"])
    def filterResult() {

        if(params.id == "1") {
            if(params.value != null) {
                List s = params.value.split(" ") //if user enters full name
                String fn = s[0]
                String ln = s[1]

                List match = Contacts2.findAllByFirstNameLikeOrLastNameLikeOrPhoneNumberLike("%${fn}%", "%${ln}%",
                        "%${params.value}%", "%${params.value}")
                render(view: '/contacts/list', model: [allCreatedContacts: match])
            }
            else {
                redirect(action: 'list')
            }
        } else {
            redirect(action: 'list')
        }
    }

    @Secured(["ROLE_USER"])
    def groupContact () {
        if (params.id == "2") {

            if (params.value != null) {
                List match = Contacts2.findAllByMarkDataLike("%${params.value}%")
                render(view: '/contacts/list', model: [allCreatedContacts: match])
            } else {
                redirect(action: 'list')
            }
        } else {
            redirect(action: 'list')
        }
    }
}
