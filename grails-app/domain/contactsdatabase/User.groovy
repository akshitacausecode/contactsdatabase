package contactsdatabase

class Contacts {

    String firstName
    String lastName
    String email
    String phoneNumber

    static constraints = {

        firstName (blank: false, matches: "[a-zA-Z]+")
        lastName (blank: false, matches: "[a-zA-Z]+")
        email (email: true, unique: true)
        phoneNumber (blank: false, unique: true, matches: "[0-9]+", size:10..13)
        dob (blank: false, date: true)
        dob max: new Date()
    }

    static mapping = {
    }
}
