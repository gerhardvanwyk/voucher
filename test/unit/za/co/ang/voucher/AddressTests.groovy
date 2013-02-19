package za.co.ang.voucher



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressTests {

    @Test
    void valid_address() {
       def address = new Address(city: "Cape Town", area: "Somerset", addressLine1: "hadd", addressLine2: "addde")
    }
}
