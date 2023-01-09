package org.strotmann.metals

class Lagerung {
	
	static belongsTo = [item:Item]
	Lagerort lagerort
	Integer anzahl
	
    static constraints = {
    }
	
	String toString() {"${this.anzahl} gelagert in ${this.lagerort}"}	
	
}
