package com.intelligrape.direcPay

import com.intelligrape.direcPay.command.DirecPayTransactionStatus
import com.intelligrape.direcPay.command.PaymentRequestCommand
import com.intelligrape.direcPay.command.PaymentResponseCommand
import com.intelligrape.direcPay.common.DirecPayUtility

class DirecPayController {
    static allowedMethods = [index: "POST", pullPaymentDetails: "POST"]

    DirecPayService direcPayService

    /**
     * Make payment with DirecPay
     * @param command as PaymentRequestCommand
     * @return redirect on success or failure url
     */
    def index(PaymentRequestCommand command) {

        if (!command.validate()) {
            println("Validation: ${command.validate()}, Parameter: ${command.dump()}")
            render("Validation: ${command.validate()}, Parameter: ${command.dump()}")
            return
        }

        session.appSuccessURL = command.successURL
        session.appFailureURL = command.failureURL

        String encryptRequestParameter = command.getEncryptedRequestParameter()
        String encryptBillingDetail = command.getEncryptedBillingDetail()
        String encryptShippingDetail = command.getEncryptedShippingDetail()
        String encryptedStoreDetails = command.getEncryptedStoreCardDetail()

        String direcPayURL = DirecPayUtility.getConfig("direcPay.URL")
        String merchantId = DirecPayUtility.getConfig("direcPay.merchantId")
        String loadingText = DirecPayUtility.getConfig("direcPay.loadingText")

        log.debug("Payment with merchantId: ${merchantId} and direcPayURL: ${direcPayURL}")

        render(view: 'index', model: [direcPayURL: direcPayURL, requestparameter: encryptRequestParameter, billingDtls: encryptBillingDetail, shippingDtls: encryptShippingDetail, merchantId: merchantId, storeDtls: encryptedStoreDetails, loadingText: loadingText])
    }

    /*def paymentSuccess() {
        String appSuccessURL = session.appSuccessURL
        println("paymentSuccess.....,\nparams: ${params.dump()},\nresponse: ${response.dump()},\nsuccessURL: ${appSuccessURL}")
        PaymentResponseCommand responseCommand = PaymentResponseCommand.populate(params.responseparams)
        saveS2SCTransaction(responseCommand)
        redirect(url: appSuccessURL, model: [responseCommand: responseCommand])
    }

    def paymentFailure() {
        String appFailureURL = session.appFailureURL
        println("paymentFailure.....,\nparams: ${params.dump()},\nresponse: ${response.dump()},\nappFailureURL: ${appFailureURL}")
        PaymentResponseCommand responseCommand = PaymentResponseCommand.populate(params.responseparams)
        redirect(url: appFailureURL, model: [responseCommand: responseCommand])
    }*/

    def paymentSuccess() {
        log.debug("paymentSuccess.....,\nparams: ${params.dump()},\nresponse: ${response.dump()}")
        PaymentResponseCommand responseCommand = PaymentResponseCommand.populate(params.responseparams)
        saveS2SCTransaction(responseCommand)
        render(view: 'paymentSuccess', model: [responseCommand: responseCommand])
    }

    def paymentFailure() {
        log.debug("paymentFailure.....,\nparams: ${params.dump()},\nresponse: ${response.dump()}")
        PaymentResponseCommand responseCommand = PaymentResponseCommand.populate(params.responseparams)
        render(view: 'paymentFailure', model: [responseCommand: responseCommand])
    }

    //TODO: need to fix
    def pullPaymentDetails() {
//        String requestparams = "1001403000365347|${DirecPayUtility.getConfig("direcPay.merchantId")}|${DirecPayUtility.getConfig("direcPay.return.transaction.details.URL")}"
        String requestparams = "1001403000365347|${DirecPayUtility.getConfig("direcPay.merchantId")}|http://localhost:8080/DirecPayTest/returnTransactionDetail"
        println "pullPaymentDetails, requestparams: ${requestparams}"
        render(view: 'direcPayPullTransactionDetails', model: [requestparams: requestparams, loadingText: DirecPayUtility.getConfig("direcPay.loadingText"), direcPayPullTransactionDetailsURL: DirecPayUtility.getConfig("direcPay.pull.transaction.details.URL")])
    }

    //TODO: need to fix
    def paymentTransactionDetails() {
        log.debug("paymentTransactionDetails.....,\nparams: ${params.dump()},\nresponse: ${response.dump()}")
        render(view: 'paymentTransactionDetails')
    }

    /**
     * Save server to server communication transaction
     * @param command
     */
    private void saveS2SCTransaction(PaymentResponseCommand command) {
        if (!command && !command?.direcPayTransactionStatus?.equals(DirecPayTransactionStatus.SUCCESS) && !command?.direcPayTransactionStatus?.equals(DirecPayTransactionStatus.FAIL)) {
            log.debug("Save server-to-server communication transaction, direcPayReferenceId: ${command?.direcPayReferenceId}, direcPayTransactionStatus: ${command?.direcPayTransactionStatus?.name()}, merchantOrderNo: ${command?.merchantOrderNo}")
            direcPayService.save(command)
        }
    }

}




