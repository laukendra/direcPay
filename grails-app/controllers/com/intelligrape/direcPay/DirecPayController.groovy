package com.intelligrape.direcPay

import com.intelligrape.direcPay.command.PaymentRequestCommand
import com.intelligrape.direcPay.command.PaymentResponseCommand
import com.intelligrape.direcPay.common.DirecPayUtil

class DirecPayController {

    def index(PaymentRequestCommand requestCommand) {
        PaymentRequestCommand command = new PaymentRequestCommand()

        //TODO:validate requestCommand object

        String encryptRequestParameter = DirecPayUtil.encrypt(command.getRequestParameter());
        String encryptBillingDetail = DirecPayUtil.encrypt(command.getBillingDetail())
        String encryptShippingDetail = DirecPayUtil.encrypt(command.getShippingDetail());

        String direcPayURL = DirecPayUtil.getConfig("direcPay.URL")
        String merchantId = DirecPayUtil.getConfig("direcPay.merchantId")

        log.debug("payment with merchantId: ${merchantId} and direcPayURL: ${direcPayURL}")

        render(view: 'index', model: [direcPayURL: direcPayURL, requestparameter: encryptRequestParameter, billingDtls: encryptBillingDetail, shippingDtls: encryptShippingDetail, merchantId: merchantId])
    }

    def paymentSuccess() {
        log.debug("paymentSuccess.....,\nparams: ${params.dump()},\nresponse: ${response.dump()}")
        PaymentResponseCommand responseCommand = PaymentResponseCommand.populate(params.responseparams)
        render(view: 'paymentSuccess', model: [responseCommand: responseCommand])
    }

    def paymentFailure() {
        log.debug("paymentFailure.....,\nparams: ${params.dump()},\nresponse: ${response.dump()}")
        PaymentResponseCommand responseCommand = PaymentResponseCommand.populate(params.responseparams)
        render(view: 'paymentFailure', model: [responseCommand: responseCommand])
    }

}



