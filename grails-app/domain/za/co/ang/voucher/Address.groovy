package za.co.ang.voucher

class Address {

    //GROM -- relationships

    static optionals = { client merchant}

    def Client client

    def Merchant merchant

    static belongsTo = [Merchant, Client]

    static constraints = {
        city(blank: false)
        area(blank: false)
        addressLine1(blank: false, max: "200")
        addressLine2(blank: false, max: "200" )
    }

    String city

    String area

    String addressLine1

    String addressLine2

}
