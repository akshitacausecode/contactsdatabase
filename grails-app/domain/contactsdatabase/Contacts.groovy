package contactsdatabase

class Contacts {

    String firstName
    String lastName
    String email
    String phoneNumber
    //Date dob

    static constraints = {

        firstName (blank: false, matches: "[a-zA-Z]+")
        lastName (blank: false, matches: "[a-zA-Z]+")
        email (email: true, unique: true)
        phoneNumber (blank: false, unique: true, matches: "[0-9]")
        //dob (blank: false)
    }
}
