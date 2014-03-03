package com.intelligrape.direcPay.dto

import com.intelligrape.direcPay.common.Util

class PaymentResponseDto {
    String direcPayReferenceId
    String responseFlag
    String country
    String currency
    String otherDetails
    String merchantOrderNo
    double postingAmount

    /**
     *
     * @param inputString as a | separated string (1000001xxxxxxxxx|SUCCESS/FAIL|IND|INR|details|orderno|100|)
     * @return
     */
    public static PaymentResponseDto populateDto(String responseString) {
        PaymentResponseDto dto = new PaymentResponseDto()
        String[] array = Util.splitString(responseString)
        if (array) {
            dto.direcPayReferenceId = array[0]
            dto.responseFlag = array[1]
            dto.country = array[2]
            dto.currency = array[3]
            dto.otherDetails = array[4]
            dto.merchantOrderNo = array[5]
            dto.postingAmount = array[6] as double
        }
        return dto
    }

}
