class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.${format})?" {
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/index")

        "/"(controller: 'direcPay', action: 'index')
        "/paymentSuccess"(controller: 'direcPay', action: 'paymentSuccess')
        "/paymentFailure"(controller: 'direcPay', action: 'paymentFailure')

        "500"(view: '/error')
    }
}
