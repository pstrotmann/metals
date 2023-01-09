package org.strotmann.metals

import java.util.List;

class Item {
	
	String bezeichnung
	BigDecimal gewicht
	String gewEinheit
	String metall
	BigDecimal sammlerwert // €
	BigDecimal kursInEuroJeUnze // z.Z. Sammlerwerterfassung
	BigDecimal umlaufwert // € 
	BigDecimal feingehalt // 1/1000
	
    static constraints = {
		gewEinheit (inList:gewEinheiten)
		metall (inList:metalle)
		sammlerwert (nullable:true)
		kursInEuroJeUnze (nullable:true)
		umlaufwert (nullable:true)
		feingehalt (nullable:true, scale:3)
    }
	
	static hasMany = [lagerungen:Lagerung]
	
	String toString() {"${this.bezeichnung} ${this.gewicht} ${this.gewEinheit} ${this.metall}"}
	
	BigDecimal getMetallgewicht() {
		def BigDecimal unzen, ges = 0
		if (gewEinheit == "oz")
			unzen = this.gewicht
		else
			unzen = this.gewicht / unzeInGr
			
		if (this.feingehalt)
			unzen * feingehalt
		else
			unzen
			
		unzen
	}
	
	BigDecimal getMetallwert() {
		def BigDecimal unzen
				
		String s = "from Kurs as k where k.metall = '${this.metall}'"
		Kurs kurs = Kurs.find (s)
				
		feingehalt ? metallgewicht * feingehalt *  kurs.kursInEuroJeUnze : metallgewicht * kurs.kursInEuroJeUnze 
	}
	
	BigDecimal getMetallwertGesamt() {
		BigDecimal ges = 0
		this.lagerungen.each {Lagerung l ->
			ges = ges + l.anzahl * this.metallwert
		}
		ges
	}
	
	BigDecimal metallwertLager(Long lId) {
		BigDecimal ges = 0
		this.lagerungen.each {Lagerung l ->
			if (l.lagerort.id == lId)
				ges = ges + l.anzahl * this.metallwert
		}
		ges
	}
	
	BigDecimal getUmlaufwertGesamt() {
		BigDecimal ges = 0
		this.lagerungen.each {Lagerung l ->
			if (this.umlaufwert)
				ges = ges + l.anzahl * this.umlaufwert
		}
		ges
	}
	
	BigDecimal getUnzeInGr() {
		31.1034768
	}
	
	Integer getAnzahlGesamt() {
		int anz = 0
		this.lagerungen.each {Lagerung l ->
			anz = anz + l.anzahl
		}
		anz
	}
	
	Integer anzahlLager(Long lId) {
		int anz = 0
		this.lagerungen.each {Lagerung l ->
			if (l.lagerort.id == lId)
				anz = anz + l.anzahl
		}
		anz
	}
	
	List <Geschenk> getGeschenke() {
		List <Geschenk> ge =[]
		Geschenk.findAll().each {Geschenk g ->
			if (g.item.id == this.id)
				ge << g			
		}
		ge.empty?null:ge
	}
	
	static BigDecimal getMetallwertSum() {
		BigDecimal ges = 0
		Item.findAll("from Item").each {Item item ->
			ges = ges + item.metallwertGesamt			
		}
		ges
	}
	
	static BigDecimal metallwertSum(String metal) {
		BigDecimal ges = 0
		Item.findAll("from Item").each {Item item ->
			if (item.metall == metal)
				ges = ges + item.metallwertGesamt
		}
		ges
	}
	
	static BigDecimal metallgewichtOzSum(String metal) {
		BigDecimal unzen = 0
		Item.findAll("from Item").each {Item item ->
			if (item.metall == metal)
				if (item.gewEinheit == "oz")
					unzen += item.gewicht * item.anzahlGesamt
				else
					unzen += (item.gewicht * item.anzahlGesamt) / item.unzeInGr
		}
		unzen
	}
	
	static BigDecimal metallgewichtGrSum(String metal) {
		BigDecimal unzen = 0
		Item.findAll("from Item").each {Item item ->
			if (item.metall == metal)
				if (item.gewEinheit == "gr")
					unzen += item.gewicht * item.anzahlGesamt
				else
					unzen += item.gewicht * item.anzahlGesamt * item.unzeInGr
		}
		unzen
	}
	
	static List <Item> listItems(String metal) {
		List is  = []
		String s = "from Item as i where i.metall = '${metal}'"
		Item.findAll(s).each {Item i -> is << i}
		is
	}
	
	static List getMetalle() {
		grails.util.Holders.config.metalle
	}
	
	static List getGewEinheiten() {
		grails.util.Holders.config.gewEinheiten
	}
}
