package za.co.ang.voucher

class Credentials {

    //GROM -- relationships

    static optionals = { client merchant}

    def Client client

    def Merchant merchant

    static belongsTo = [Merchant, Client]

    //-------------------------------

    static constraints = {
        //Only Alpha Numeric and between 6 & 100 characters
        password(matches:/[\w\d]+/, length:6..100)
        email(email:true, unique: true)
        lastName(blank: false)
        firstName(blank: false)
        userName(blank: false)
    }

    String email

    String userName

    String password

    String lastName

    String firstName


}
