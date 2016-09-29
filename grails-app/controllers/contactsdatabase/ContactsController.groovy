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
        params.email, phoneNumber: params.phoneNumber, dob: dates])
        println params.firstName
        println "@@@@@@@@@@@@"
        println params
        println "###########"
        println dates
        println contactsInstance.firstName

        contactsInstance.save()
        println contactsInstance.errors
        if (contactsInstance.hasErrors()) {
            render(view: 'index', model: [user: contactsInstance])
            return
        }

        println contactsInstance.phoneNumber;
        redirect(action : "list" )
    }

    def list() {

        [allCreatedContacts: Contacts.list(sort:"firstName")]
    }
}
