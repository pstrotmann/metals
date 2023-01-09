package org.strotmann.metals

class User {

    String name
	String passwort

    static constraints = {
		name(unique:true)
		passwort()
    }
}
