package za.co.ang.voucher

import org.springframework.dao.DataIntegrityViolationException

class MerchantController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [merchantInstanceList: Merchant.list(params), merchantInstanceTotal: Merchant.count()]
    }

    def create() {
        [merchantInstance: new Merchant(params)]
    }

    def save() {
        def merchantInstance = new Merchant(params)
        if (!merchantInstance.save(flush: true)) {
            render(view: "create", model: [merchantInstance: merchantInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'merchant.label', default: 'Merchant'), merchantInstance.id])
        redirect(action: "show", id: merchantInstance.id)
    }

    def show(Long id) {
        def merchantInstance = Merchant.get(id)
        if (!merchantInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'merchant.label', default: 'Merchant'), id])
            redirect(action: "list")
            return
        }

        [merchantInstance: merchantInstance]
    }

    def edit(Long id) {
        def merchantInstance = Merchant.get(id)
        if (!merchantInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'merchant.label', default: 'Merchant'), id])
            redirect(action: "list")
            return
        }

        [merchantInstance: merchantInstance]
    }

    def update(Long id, Long version) {
        def merchantInstance = Merchant.get(id)
        if (!merchantInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'merchant.label', default: 'Merchant'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (merchantInstance.version > version) {
                merchantInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'merchant.label', default: 'Merchant')] as Object[],
                          "Another user has updated this Merchant while you were editing")
                render(view: "edit", model: [merchantInstance: merchantInstance])
                return
            }
        }

        merchantInstance.properties = params

        if (!merchantInstance.save(flush: true)) {
            render(view: "edit", model: [merchantInstance: merchantInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'merchant.label', default: 'Merchant'), merchantInstance.id])
        redirect(action: "show", id: merchantInstance.id)
    }

    def delete(Long id) {
        def merchantInstance = Merchant.get(id)
        if (!merchantInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'merchant.label', default: 'Merchant'), id])
            redirect(action: "list")
            return
        }

        try {
            merchantInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'merchant.label', default: 'Merchant'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'merchant.label', default: 'Merchant'), id])
            redirect(action: "show", id: id)
        }
    }
}
