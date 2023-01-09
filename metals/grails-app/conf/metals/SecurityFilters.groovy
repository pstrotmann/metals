package metals

class SecurityFilters {

    def filters = {
        loginCheck(controller: 'user', action: 'login', invert: true) {
		    before = {
				String actName = actionName?:" "
                if (!session.user && actionName != "login" && !actName.startsWith("unze")) {
					redirect(controller: "user", action: "login")
                }
            }
        }
    }
}
