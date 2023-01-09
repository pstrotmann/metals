package org.strotmann.metals

import java.util.List

class Kurs {
	
	String metall
	BigDecimal kursInEuroJeUnze
	BigDecimal kursInDollarJeUnze
	BigDecimal kursInEuroJeKg
	BigDecimal kursInDollarJeKg
	BigDecimal kursDollarJeEuro
	BigDecimal kursEuroJeDollar
	
	Kurs(m) {
		this.metall = m
	}

    static constraints = {
		metall (unique:true, inList:metalle)
		kursInDollarJeUnze (nullable:true)
		kursInEuroJeKg (nullable:true)
		kursInDollarJeKg (nullable:true)
		kursDollarJeEuro (nullable:true)
		kursEuroJeDollar (nullable:true)
    }
	
	String toString() {"${this.metall} ${this.kursInEuroJeUnze}"}
	
	BigDecimal getKursInEuroJeUnze() {
		kursInEuroJeUnze
	}
			
	static List getMetalle() {
		grails.util.Holders.config.metalle
	}
	
	String getMetallDE() {
		Map map = ["au":"Gold", "ag":"Silber", "pl":"Platin", "pd":"Palladium"]
		map[this.metall]
	}
	
	static String updKurse() {
				
		String antwort = null
		
		KurseHoler kh = new KurseHoler() //Metallkurse und Dollarkurs
		
		BigDecimal devKurs = kh.EuroJeDollar()
		
		metalle.each {String m ->
			Kurs kurs = Kurs.findByMetall(m)?:new Kurs(m)
			try {
				kurs.kursInDollarJeUnze = kh.DollarJeUnze(m)				
			} catch (Exception e) {
				antwort = "Fehler beim Zugriff auf die Metallkurse per Webservice. Metallkurse nicht aktualisiert."
			}
			kurs.kursInEuroJeUnze = kurs.kursInDollarJeUnze * devKurs
			kurs.kursInDollarJeKg = (kurs.kursInDollarJeUnze / 31.1034768) * 1000
			kurs.kursInEuroJeKg = (kurs.kursInEuroJeUnze / 31.1034768) * 1000
			kurs.kursEuroJeDollar = devKurs
			kurs.kursDollarJeEuro = 1/devKurs
			//Update Datenbank
			kurs.save flush:true
		}
		antwort
	}
}
