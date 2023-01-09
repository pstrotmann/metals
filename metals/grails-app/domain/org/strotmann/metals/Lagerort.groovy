package org.strotmann.metals

class Lagerort {
	
	String location
	String subLocation
	BigDecimal kostenProJahr	

    static constraints = {
		subLocation  (unique:['location'])
		kostenProJahr (nullable:true)
	}	
	
	String toString() {"${this.location} ${this.subLocation}"}
	
	List <Item> getItems() {
		List is  = []
		String s = "from Lagerung as l where l.lagerort.id = ${this.id}"
		Lagerung.findAll (s).each
		 {Lagerung l -> is << l.item}
		is
	}
	
	BigDecimal getSumme(){
		BigDecimal s = 0
		Lagerung.findAll ("from Lagerung as l where l.lagerort.id = ${this.id}").each {
			Lagerung l -> s = s + l.item.metallwertLager(l.lagerort.id)}
		s
		}		
}
