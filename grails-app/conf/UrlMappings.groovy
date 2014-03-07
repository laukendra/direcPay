class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.${format})?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'direcPay', action: 'index')
        "/pullPaymentDetails"(controller: 'direcPay', action: 'pullPaymentDetails')
        "/paymentDetails"(controller: 'direcPay', action: 'paymentTransactionDetails')

        "500"(view: '/error')
    }
}
