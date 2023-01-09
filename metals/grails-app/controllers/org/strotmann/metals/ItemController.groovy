package org.strotmann.metals

import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		Map map = ["au":"Gold", "ag":"Silber", "pl":"Platin", "pd":"Palladium"]
        params.max = Math.min(max ?: 100, 1000)
        if (params.metall)
			respond Item.listItems(params.metall),
			model:[	itemInstanceMetall: map[params.metall],
				 	itemInstanceCount: Item.count(),
					itemInstanceSumme: Item.metallwertSum(params.metall),
					itemInstanceGewOzSumme: Item.metallgewichtOzSum(params.metall),
					itemInstanceGewGrSumme: Item.metallgewichtGrSum(params.metall)]
			
		else
			respond Item.list(params), model:[itemInstanceCount: Item.count(), itemInstanceSumme: Item.metallwertSum]
    }
	
    def show(Item itemInstance) {
        respond itemInstance
    }

    def create() {
		respond new Item(params)
    }

    @Transactional
    def save(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'create'
            return
        }		

        itemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), itemInstance.id])
                redirect itemInstance
            }
            '*' { respond itemInstance, [status: CREATED] }
        }
    }

    def edit(Item itemInstance) {
		respond itemInstance
    }

    @Transactional
    def update(Item itemInstance) {
		if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'edit'
            return
        }
		
        itemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect itemInstance
            }
            '*'{ respond itemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Item itemInstance) {

        if (itemInstance == null) {
            notFound()
            return
        }

        itemInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	
	def unzenGesWert() {
		String antwort = Kurs.updKurse()
		if (antwort)
			render antwort
		else
			render Item.metallwertSum.toString().replace('.',',')
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
