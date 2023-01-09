package org.strotmann.metals

import grails.transaction.Transactional

@Transactional(readOnly = true)
class LagerungController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lagerung.list(params), model:[lagerungInstanceCount: Lagerung.count()]
    }

    def show(Lagerung lagerungInstance) {
        respond lagerungInstance
    }

    def create() {
        respond new Lagerung(params)
    }

    @Transactional
    def save(Lagerung lagerungInstance) {
        if (lagerungInstance == null) {
            notFound()
            return
        }

        if (lagerungInstance.hasErrors()) {
            respond lagerungInstance.errors, view:'create'
            return
        }

        lagerungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lagerung.label', default: 'Lagerung'), lagerungInstance.id])
                redirect lagerungInstance
            }
            '*' { respond lagerungInstance, [status: CREATED] }
        }
    }

    def edit(Lagerung lagerungInstance) {
        respond lagerungInstance
    }

    @Transactional
    def update(Lagerung lagerungInstance) {
        if (lagerungInstance == null) {
            notFound()
            return
        }

        if (lagerungInstance.hasErrors()) {
            respond lagerungInstance.errors, view:'edit'
            return
        }

        lagerungInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lagerung.label', default: 'Lagerung'), lagerungInstance.id])
                redirect lagerungInstance
            }
            '*'{ respond lagerungInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lagerung lagerungInstance) {

        if (lagerungInstance == null) {
            notFound()
            return
        }

        lagerungInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lagerung.label', default: 'Lagerung'), lagerungInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lagerung.label', default: 'Lagerung'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
