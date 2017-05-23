package contactsdatabase

import com.contactsdatabase.User

import java.text.SimpleDateFormat
import java.util.Date
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
class ContactsController {

    def springSecurityService

    @Secured(["ROLE_USER"])
    def index() {

        User userInstance = springSecurityService.getCurrentUser()
        println(userInstance)
        [user: userInstance]
    }

    @Secured(["ROLE_USER"])
    def addContact() {

        [user: new Contacts2()]
    }

    @Secured(["ROLE_USER"])
    def Saving() {

        Date dates = Date.parse("yyyy-MM-dd", params.date)

        Contacts2 contactsInstance = new Contacts2([userInstance: springSecurityService.currentUser.id,firstName: params.firstName,
                                    lastName: params.lastName, email: params.email, phoneNumber: params.phoneNumber,
                                    dob: dates, markData: params.markData]) //passing map

        contactsInstance.save() //saves to database

        println contactsInstance.errors

        if (contactsInstance.hasErrors()) {
            render(view: '/contacts/addContact', model: [user: contactsInstance])
            return
        }
        //flash message is displayed when values are stored into database
        flash.message = "Contact details have been successfully saved!!!"
        redirect(action : "list")
    }

    @Secured(["ROLE_USER"])
    def list() {

            [allCreatedContacts: Contacts2.list(sort:"firstName")]
    }

    @Secured(["ROLE_USER"])
    def edit() {

        def editContact = Contacts2.get(params.id)
        [editContact: editContact]
    }

    @Secured(["ROLE_USER"])
    def update() {

        println params
        Contacts2 updateContact = Contacts2.get(params.id)
        Date dates = Date.parse("yyyy-MM-dd", params.date)
        updateContact.firstName = params.firstName
        updateContact.lastName = params.lastName
        updateContact.email = params.email
        updateContact.phoneNumber = params.phoneNumber
        updateContact.dob = dates
        updateContact.save(flush: true)

        if (updateContact.hasErrors()) {
            [editContact: updateContact]
            render(view: '/contacts/edit', model: [user: updateContact, editContact:updateContact])

            return
        }
        print("+++++update ends here++++")
        redirect (action: 'show', id: params.id)
    }

    @Secured(["ROLE_USER"])
    def show() {

        Contacts2 contactDisplay = Contacts2.get(params.id)
        return [contactDisplay: contactDisplay]
    }

    @Secured(["ROLE_USER"])
    def delete() {

        Contacts2 deleteContact = Contacts2.get(params.id)
        deleteContact.delete(flush: true)
        redirect(action: 'list')
    }

    @Secured(["ROLE_USER"])
    def filterResult() {

        if(params.id == "1") {
            println params

            List s = params.value.split(" ") //if user enters full name
            String fn = s[0]
            String ln = s[1]

            List match = Contacts2.findAllByFirstNameLikeOrLastNameLikeOrPhoneNumberLike("%${fn}%", "%${ln}%",
                    "%${params.value}%", "%${params.value}")
            render(view: '/contacts/list', model: [allCreatedContacts: match])
        } else {
            redirect(action: 'list')
        }
    }

    @Secured(["ROLE_USER"])
    def groupContact () {
        if (params.id == "2") {
            println params

            List match = Contacts2.findAllByMarkDataLike("%${params.value}%")
            render(view: '/contacts/list', model: [allCreatedContacts: match])
        } else {
            redirect(action: 'list')
        }
    }
}
