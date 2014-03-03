package com.intelligrape.direcPay.dto

class ShippingDetailDto {
    String deliveryName = "TestUser"
    String deliveryAddress = "Mumbai"
    String deliveryCity = "Mumbai"
    String deliveryState = "Maharashtra"
    int deliveryPinCode = 400234
    String deliveryCountry = "IN"
    String deliveryPhNo1 = "91"
    String deliveryPhNo2 = "022"
    String deliveryPhNo3 = "28000000"
    String deliveryMobileNo = "9920000000"

    public String getShippingDetail() {
        String shippingDetail = "${deliveryName}|${deliveryAddress }|${deliveryCity }|" +
                "${deliveryState }|${deliveryPinCode}|${deliveryCountry}|" +
                "${deliveryPhNo1 }|${deliveryPhNo2 }|${deliveryPhNo3}|" +
                "${deliveryMobileNo}"
        return shippingDetail
    }
}
