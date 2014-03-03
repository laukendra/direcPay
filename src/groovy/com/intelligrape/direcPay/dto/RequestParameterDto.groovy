package com.intelligrape.direcPay.dto

class RequestParameterDto {
    long mid = 200904281000001
    String operatingMode = "DOM"
    String country = "IND"
    String currency = "INR"
    double amount = 10.00
    String merchantOrderNo = "test-order${System.currentTimeMillis()}"
    String otherDetails = "others"
    String successUrl = "http://localhost:8080/direcPay/paymentSuccess"
    String failureUrl = "http://localhost:8080/direcPay/paymentFailure"
    String collaborator = "TOML"

    public String getRequestParameter() {
        String requestParameter = "${this.mid}|${this.operatingMode}|${this.country}" +
                "|${this.currency}|${this.amount}|${this.merchantOrderNo}|" +
                "${this.otherDetails}|${this.successUrl}|${this.failureUrl}|" +
                "${this.collaborator}"
        return requestParameter
    }
}
