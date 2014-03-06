It's a payment integration plugin with DirecPay

===================================================
----------------------Stack------------------------
===================================================
java 1.7
grails 2.3.2
aes6.0.jar

Git:
git URL: https://github.com/laukendra/direcPay
SSH Url: git@github.com:laukendra/direcPay.git

===================================================
-------------------Config Required------------------
===================================================
direcPay.URL = "https://test.timesofmoney.com/direcpay/secure/dpMerchantPayment.jsp"
direcPay.pull.transaction.details.URL = "https://test.timesofmoney.com/direcpay/secure/dpPullMerchAtrnDtls.jsp"
direcPay.loadingText = "Loading..."

environments {
    development {
        direcPay.encryption.secretKey = "qcAHa6tt8s0l5NN7UWPVAQ=="
        direcPay.merchantId = "200904281000001"
        direcPay.success.URL = "http://localhost:8080/direcPay/paymentSuccess"
        direcPay.failure.URL = "http://localhost:8080/direcPay/paymentFailure"
        direcPay.return.transaction.details.URL = "http://localhost:8080/direcPay/paymentDetails"
    }
}