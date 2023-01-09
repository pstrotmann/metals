package org.strotmann.metals

import grails.transaction.Transactional

@Transactional(readOnly = true)
class LagerortController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lagerort.list(params), model:[lagerortInstanceCount: Lagerort.count()]
    }

    def show(Lagerort lagerortInstance) {
		respond lagerortInstance
    }
	
	def listItems() {
		[lagerortInstance : Lagerort.get(params.id)]
	}

    def create() {
        respond new Lagerort(params)
    }

    @Transactional
    def save(Lagerort lagerortInstance) {
        if (lagerortInstance == null) {
            notFound()
            return
        }

        if (lagerortInstance.hasErrors()) {
            respond lagerortInstance.errors, view:'create'
            return
        }

        lagerortInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lagerort.label', default: 'Lagerort'), lagerortInstance.id])
                redirect lagerortInstance
            }
            '*' { respond lagerortInstance, [status: CREATED] }
        }
    }

    def edit(Lagerort lagerortInstance) {
        respond lagerortInstance
    }

    @Transactional
    def update(Lagerort lagerortInstance) {
        if (lagerortInstance == null) {
            notFound()
            return
        }

        if (lagerortInstance.hasErrors()) {
            respond lagerortInstance.errors, view:'edit'
            return
        }

        lagerortInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Lagerort.label', default: 'Lagerort'), lagerortInstance.id])
                redirect lagerortInstance
            }
            '*'{ respond lagerortInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lagerort lagerortInstance) {

        if (lagerortInstance == null) {
            notFound()
            return
        }

        lagerortInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Lagerort.label', default: 'Lagerort'), lagerortInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lagerort.label', default: 'Lagerort'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
