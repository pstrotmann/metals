package org.strotmann.metals

class Geschenk {
	
	static belongsTo = [item:Item]
	String empfaenger
	Date datum
	String anlass

    static constraints = {
		datum (nullable:true)
		anlass (nullable:true)
    }
	
	String toString() {"${this.empfaenger} ${this.anlass} ${this.datum?this.datum.getDateString():""}"}
	
	static List <Geschenk> geschenke(String empf) {
		List <Geschenk> ge =[]
		Geschenk.findAll().each {Geschenk g ->
			if (empf == null || empf == g.empfaenger)
				ge << g
		}
		ge
	}
	
	static BigDecimal summe(String empf) {
		BigDecimal s = 0
		Geschenk.findAll().each {Geschenk g ->
			if (empf == null || empf == g.empfaenger)
				s += g.item.metallwert
		}
		s
	}
}
