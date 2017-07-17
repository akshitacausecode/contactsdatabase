package contactsdatabase

import com.causecode.RestfulController
import com.causecode.user.User
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService

//import java.text.SimpleDateFormat
//import java.util.Date
//import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class ContactsController extends RestfulController {

    SpringSecurityService springSecurityService

    static namespace = 'v1'

    ContactsController() {
        super(Contacts2)
    }

    @Override
//    @Secured(['permitAll'])
//    def index() {
//
//        User userInstance = springSecurityService.getCurrentUser()
//        [user: userInstance]
//    }
//
//    @Secured(['permitAll'])
//    def addContact() {
//
//        [user: new Contacts2()]
//    }

    @Secured(["ROLE_USER"])
    def save() {

        User userInstance = springSecurityService.getCurrentUser()
        println userInstance
        params.userInstance = userInstance
        params.putAll(request.JSON)
        def contactPresent = Contacts2.createCriteria().get {
            and {
                    eq("userInstance", userInstance)
                    eq("email", "${params.email}")
                    eq("phoneNumber", "${params.phoneNumber}")
            }
        }
        if (contactPresent) {
            Contacts2 contactsInstance = new Contacts2(params)
            flash.error = "This Contact is already present in your account"
            //render(view: '/contacts/addContact', model: [user: contactsInstance])
            render 'this contact is already present in your account'

        } else {
            //params.dob = Date.parse("yyyy-MM-dd", params.date)
            Contacts2 contactsInstance = new Contacts2(params)
            contactsInstance.save() //saves to database
            if (contactsInstance.hasErrors()) {                   //to check errors
                render contactsInstance.errors as JSON
                // render(view: '/contacts/addContact', model: [user: contactsInstance])
                //return
            }
            //flash message is displayed when values are stored into database
            flash.message = "Contact details have been successfully saved!!!"
            //redirect(action: "list")
            render 'pass'
        }
    }

    @Secured(['ROLE_USER'])
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

    @Secured(["ROLE_USER"])
    def update() {

        params.putAll(request.JSON)
        def currentuser = springSecurityService.getCurrentUser()
        def checkContact = Contacts2.findAllByUserInstanceAndId(currentuser, params.id)
        if(checkContact) {
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

    @Secured(["ROLE_USER"])
    def show() {

        def currentuser= springSecurityService.currentUser
            def showValue = Contacts2.findAllByUserInstanceAndId(currentuser, params.id)
            //Contacts2 showValue = Contacts2.get(params.id)
            if(showValue) {
                respond([result: showValue])
            }else {
                def message = ['message': 'please give a valid parameter']
                render message as JSON
            }
//        Contacts2 contactDisplay = Contacts2.get(id)
//            return [contactDisplay: contactDisplay]
        }

    @Secured(["ROLE_USER"])
    def delete() {

        def currentuser = springSecurityService.currentUser
        println currentuser
        println params.id
            if (Contacts2.findByUserInstanceAndId(currentuser, params.id)) {
                Contacts2 deleteValue = Contacts2.findByUserInstanceAndId(currentuser, params.id)
                deleteValue.delete(flush: true)
                def message = [['result': 'value deleted']]
                render message as JSON
            }else {
                def message = ['message': 'Provide a valid data']
                render message as JSON
            }
        //redirect(action: 'list')
    }

    def filterResult() {
        params.putAll(request.JSON)

        if(params.id == "1") {
            if(params.value != null) {
                List s = params.value.split(" ") //if user enters full name
                String fn = s[0]
                String ln = s[1]
                def currentuser = springSecurityService.currentUser
                List match = Contacts2.findAllByFirstNameLikeOrLastNameLikeOrPhoneNumberLikeAndUserInstance("%${fn}%", "%${ln}%",
                        "%${params.value}%", "%${params.value}", currentuser)
                //render(view: '/contacts/list', model: [allCreatedContacts: match])
                render match as JSON
            }
            else {
                //redirect(action: 'list')
            }
        } else {
            //redirect(action: 'list')
    }

    @Secured(["ROLE_USER"])
    def groupContact () {
        if (params.id == "2") {

            if (params.value != null) {
                List match = Contacts2.findAllByMarkDataLike("%${params.value}%")
                render match as JSON
                //render(view: '/contacts/list', model: [allCreatedContacts: match])
            } else {
                render "no search result found"
                //redirect(action: 'list')
            }
        } else {
            render "no search result found"
            //redirect(action: 'list')
        }
    }
}
