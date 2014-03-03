package com.intelligrape.direcPay.dto

class BillingDetailDto {
    String customerName = "TestUser"
    String customerAddress = "Mumbai"
    String customerCity = "Mumbai"
    String customerState = "Maharashtra"
    int customerPinCode = 400001
    String customerCountry = "IN"
    String customerPhoneNo1 = "91"
    String customerPhoneNo2 = "022"
    String customerPhoneNo3 = "28000000"
    String customerMobileNo = "9820000000"
    String customerEmailId = "testuser@gmail.com"
    String otherNotes = "test transaction for direcpay"

    public String getBillingDetail() {
        String billingDetail = "${customerName}|${customerAddress}|${customerCity}|" +
                "${customerState}|${customerPinCode}|${customerCountry}|" +
                "${customerPhoneNo1}|${customerPhoneNo2}|${customerPhoneNo3}|" +
                "${customerMobileNo}|$customerEmailId}|${otherNotes}"
        return billingDetail
    }
}
