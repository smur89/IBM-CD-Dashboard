class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "team", action: "checkState")
        //"/"(view:"/index")  //default Grails page, list of controllers.
        "500"(view:'/error')
	}
}
