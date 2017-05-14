package contactsdatabase

import java.text.SimpleDateFormat
import java.util.Date
class ContactsController {

    def index() {

        [user: new Contacts()]
    }
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

    def list() {

        //to list contacts in ascending order
        [allCreatedContacts: Contacts.list(sort:"firstName")]
    }

    def edit() {

        def editContact = Contacts.get(params.id)

        if (editContact.hasErrors()) {
            render(view: '/contacts/edit', model: [editContact: editContact])
            return
        }

        [editContact: editContact]
    }

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

        print("+++++update ends here++++")

        redirect (action: 'show', id: params.id)
    }

    def show() {

        Contacts contactDisplay = Contacts.get(params.id)
        return [contactDisplay: contactDisplay]
    }

    def delete() {

        Contacts deleteContact = Contacts.get(params.id)
        deleteContact.delete(flush: true)
        redirect(action: 'list')
    }
}
