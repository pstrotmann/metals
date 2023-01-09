package org.strotmann.metals

import grails.transaction.Transactional

@Transactional(readOnly = true)
class GeschenkController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		params.max = Math.min(max ?: 100, 1000)
        respond params.id?Geschenk.geschenke(params.id):Geschenk.list(params), model:[geschenkSumme:Geschenk.summe(params.id),geschenkInstanceCount: Geschenk.count()]
	}

    def show(Geschenk geschenkInstance) {
        respond geschenkInstance
    }

    def create() {
        respond new Geschenk(params)
    }

    @Transactional
    def save(Geschenk geschenkInstance) {
        if (geschenkInstance == null) {
            notFound()
            return
        }

        if (geschenkInstance.hasErrors()) {
            respond geschenkInstance.errors, view:'create'
            return
        }

        geschenkInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'geschenk.label', default: 'Geschenk'), geschenkInstance.id])
                redirect geschenkInstance
            }
            '*' { respond geschenkInstance, [status: CREATED] }
        }
    }

    def edit(Geschenk geschenkInstance) {
        respond geschenkInstance
    }

    @Transactional
    def update(Geschenk geschenkInstance) {
        if (geschenkInstance == null) {
            notFound()
            return
        }

        if (geschenkInstance.hasErrors()) {
            respond geschenkInstance.errors, view:'edit'
            return
        }

        geschenkInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Geschenk.label', default: 'Geschenk'), geschenkInstance.id])
                redirect geschenkInstance
            }
            '*'{ respond geschenkInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Geschenk geschenkInstance) {

        if (geschenkInstance == null) {
            notFound()
            return
        }

        geschenkInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Geschenk.label', default: 'Geschenk'), geschenkInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'geschenk.label', default: 'Geschenk'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
