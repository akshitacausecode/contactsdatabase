package contactsdatabase

import java.text.SimpleDateFormat
import java.util.Date
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
class ContactsController {

    @Secured(["ROLE_USER"])
    def index() {

        //[user: new Contacts()]
    }

    @Secured(["ROLE_USER"])
    def addContact() {

        [user: new Contacts()]
    }

    @Secured(["ROLE_USER"])
    def Saving() {

        Date dates = Date.parse("yyyy-MM-dd", params.date)
        Contacts contactsInstance = new Contacts([firstName: params.firstName, lastName: params.lastName, email:
        params.email, phoneNumber: params.phoneNumber, dob: dates]) //passing map

        contactsInstance.save() //saves to database

        println contactsInstance.errors

        if (contactsInstance.hasErrors()) {
            render(view: '/contacts/index', model: [user: contactsInstance])
            return
        }
        //flash message is displayed when values are stored into database
        flash.message = "Contact details have been successfully saved!!!"
        redirect(action : "list")
    }

    @Secured(["ROLE_USER"])
    def list() {

        //to list contacts in ascending order
        [allCreatedContacts: Contacts.list(sort:"firstName")]
    }

    @Secured(["ROLE_USER"])
    def edit() {

        def editContact = Contacts.get(params.id)

        /*if (editContact.hasErrors()) {
            render(view: '/contacts/edit', model: [user: editContact])
            return
        }*/

        [editContact: editContact]
    }

    @Secured(["ROLE_USER"])
    def update() {

        println params

        Contacts updateContact = Contacts.get(params.id)
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

        Contacts contactDisplay = Contacts.get(params.id)
        return [contactDisplay: contactDisplay]
    }

    @Secured(["ROLE_USER"])
    def delete() {

        Contacts deleteContact = Contacts.get(params.id)
        deleteContact.delete(flush: true)
        redirect(action: 'list')
    }
}
