package contactsdatabase

class ContactsController {

    def index() {

        [user: new Contacts()]
    }
    def Saving() {

        println ">>>>>>>>>"
        Contacts contactsInstance = new Contacts([firstName: params.firstName, lastName: params.lastName, email:
        params.email, phoneNumber: params.phoneNumber])
        println params.firstName
        println contactsInstance.firstName;

        contactsInstance.save()
        if (contactsInstance.hasErrors()) {
            render(view: 'index', model: [user: contactsInstance])
            return
        }

        println contactsInstance.phoneNumber;
        redirect(action : "list" )
    }
    def list() {

    }
}
