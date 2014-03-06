// configuration for plugin testing - will not be included in the plugin zip

log4j = {
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%c{2} %m%n')
    }

    error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
            'org.codehaus.groovy.grails.web.pages', //  GSP
            'org.codehaus.groovy.grails.web.sitemesh', //  layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping', // URL mapping
            'org.codehaus.groovy.grails.commons', // core / classloading
            'org.codehaus.groovy.grails.plugins', // plugins
            'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
}

direcPay.URL = "https://test.timesofmoney.com/direcpay/secure/dpMerchantPayment.jsp"
direcPay.pull.transaction.details.URL = "https://test.timesofmoney.com/direcpay/secure/dpPullMerchAtrnDtls.jsp"
direcPay.return.transaction.details.URL = "http://localhost:8080/direcPay/paymentDetails"
direcPay.loadingText = "Loading..."
direcPay.operatingMode = "DOM"

environments {
    development {
        direcPay.encryption.secretKey = "qcAHa6tt8s0l5NN7UWPVAQ=="
        direcPay.merchantId = "200904281000001"
        direcPay.collaborator = "TOML"
    }
    test {
        direcPay.encryption.secretKey = "qcAHa6tt8s0l5NN7UWPVAQ=="
        direcPay.merchantId = "200904281000001"
        direcPay.collaborator = "TOML"
    }
    staging {
        direcPay.collaborator = "DirecPay"
    }
    production {
        direcPay.collaborator = "DirecPay"
    }
}
