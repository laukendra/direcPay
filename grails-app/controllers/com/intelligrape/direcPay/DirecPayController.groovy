package com.intelligrape.direcPay

import com.intelligrape.direcPay.common.Util
import com.intelligrape.direcPay.dto.BillingDetailDto
import com.intelligrape.direcPay.dto.PaymentResponseDto
import com.intelligrape.direcPay.dto.RequestParameterDto
import com.intelligrape.direcPay.dto.ShippingDetailDto

class DirecPayController {

    def index() {
        RequestParameterDto requestParameterDto = new RequestParameterDto()
        BillingDetailDto billingDetailDto = new BillingDetailDto()
        ShippingDetailDto shippingDetailDto = new ShippingDetailDto()

        String encryptRequestParameter = Util.encrypt(requestParameterDto.getRequestParameter());
        String encryptBillingDetail = Util.encrypt(billingDetailDto.getBillingDetail())
        String encryShippingDetail = Util.encrypt(shippingDetailDto.getShippingDetail());

        String merchantId = Util.getConfig("direcPay.merchantId")

        render(view: 'index', model: [requestparameter: encryptRequestParameter, billingDtls: encryptBillingDetail, shippingDtls: encryShippingDetail, merchantId: merchantId])
    }

    def payment() {
        RequestParameterDto requestParameterDto = new RequestParameterDto()
        BillingDetailDto billingDetailDto = new BillingDetailDto()
        ShippingDetailDto shippingDetailDto = new ShippingDetailDto()

        String encryptRequestParameter = Util.encrypt(requestParameterDto.getRequestParameter());
        String encryptBillingDetail = Util.encrypt(billingDetailDto.getBillingDetail())
        String encryShippingDetail = Util.encrypt(shippingDetailDto.getShippingDetail());

        String direcParUrl = Util.getConfig("direcPay.URL")
        String merchantId = Util.getConfig("direcPay.merchantId")

        redirect(url: direcParUrl, requestparameter: encryptRequestParameter, billingDtls: encryptBillingDetail, shippingDtls: encryShippingDetail, merchantId: merchantId)
    }


    def paymentSuccess() {
        println "paymentSuccess....................,\nparams: ${params.dump()},\nresponse: ${response.dump()}"
        PaymentResponseDto responseDto = PaymentResponseDto.populateDto(params.responseparams)
        render(view: 'paymentSuccess', model: [response: response, responseDto: responseDto])
    }

    def paymentFailure() {
        println "paymentFailure....................,\nparams: ${params.dump()},\nresponse: ${response.dump()}"
        PaymentResponseDto responseDto = PaymentResponseDto.populateDto(params.responseparams)
        render(view: 'paymentFailure', model: [response: response, responseDto: responseDto])
    }

}



