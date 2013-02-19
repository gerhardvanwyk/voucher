package za.co.ang.voucher



import org.junit.*
import grails.test.mixin.*

@TestFor(MerchantController)
@Mock(Merchant)
class MerchantControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/merchant/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.merchantInstanceList.size() == 0
        assert model.merchantInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.merchantInstance != null
    }

    void testSave() {
        controller.save()

        assert model.merchantInstance != null
        assert view == '/merchant/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/merchant/show/1'
        assert controller.flash.message != null
        assert Merchant.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/merchant/list'

        populateValidParams(params)
        def merchant = new Merchant(params)

        assert merchant.save() != null

        params.id = merchant.id

        def model = controller.show()

        assert model.merchantInstance == merchant
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/merchant/list'

        populateValidParams(params)
        def merchant = new Merchant(params)

        assert merchant.save() != null

        params.id = merchant.id

        def model = controller.edit()

        assert model.merchantInstance == merchant
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/merchant/list'

        response.reset()

        populateValidParams(params)
        def merchant = new Merchant(params)

        assert merchant.save() != null

        // test invalid parameters in update
        params.id = merchant.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/merchant/edit"
        assert model.merchantInstance != null

        merchant.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/merchant/show/$merchant.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        merchant.clearErrors()

        populateValidParams(params)
        params.id = merchant.id
        params.version = -1
        controller.update()

        assert view == "/merchant/edit"
        assert model.merchantInstance != null
        assert model.merchantInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/merchant/list'

        response.reset()

        populateValidParams(params)
        def merchant = new Merchant(params)

        assert merchant.save() != null
        assert Merchant.count() == 1

        params.id = merchant.id

        controller.delete()

        assert Merchant.count() == 0
        assert Merchant.get(merchant.id) == null
        assert response.redirectedUrl == '/merchant/list'
    }
}
