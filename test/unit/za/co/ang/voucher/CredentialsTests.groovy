package za.co.ang.voucher



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Credentials)
class CredentialsTests {

    @Test
    void invalid_password_not_alphaNumeric() {
        def cred = new Credentials(email: "john@gmail.com", password: "-bcdefg", lastName: "John", firstName: "smith")
        def savedCred = cred.save()
        assertNull(savedCred)
        assertTrue( cred.hasErrors() )
    }

    @Test
    void invalid_password_too_short() {
        def cred = new Credentials(email: "john@gmail.com", password: "cdefg", lastName: "John", firstName: "smith")
        def savedCred = cred.save()
        assertNull(savedCred)
        assertTrue( cred.hasErrors() )
    }

    //Other field validations is done by the framework, so not writing test for it.
    //But if you add you own validation please test.


}
