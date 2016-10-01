package contactsdatabase

import java.text.SimpleDateFormat
import java.util.Date
class ContactsController {

    def index() {

        [user: new Contacts()]
    }
    def Saving() {

        println ">>>>>>>>>"
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
}
