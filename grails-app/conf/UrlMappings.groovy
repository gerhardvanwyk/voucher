class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

        "/"(view: "/index")
//		"/merchant"(view:"/voucher/login")
//        "/merchant/new"(view:"/voucher/merchant/new")
		"500"(view:'/error')
	}
}
