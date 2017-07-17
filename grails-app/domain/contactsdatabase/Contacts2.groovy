package contactsdatabase

import com.causecode.user.User

class Contacts2 {

    User userInstance
    String firstName
    String lastName
    String email
    String phoneNumber
    String markData
    //Date dob

    static constraints = {

        firstName (blank: false, matches: "[a-zA-Z]+")
        lastName (blank: false, matches: "[a-zA-Z]+")
        email (email: true)
        phoneNumber (blank: false, matches: "[0-9]+", size:10..13)
        //dob (blank: false, date: true)
        //dob max: new Date()
        markData(blank: false)
    }

    static mapping = {
        sort firstName: "asc"
       // dob type: 'date'

    }
}
