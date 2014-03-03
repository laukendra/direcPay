<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DirecPay</title>
</head>

<body>

<p><strong>requestparameter:</strong>${requestparameter}</p>

<p><strong>billingDtls:</strong>${billingDtls}</p>

<p><strong>shippingDtls:</strong>${shippingDtls}</p>

<p><strong>merchantId:</strong>${merchantId}</p>

<form name="submitParams" action="https://test.timesofmoney.com/direcpay/secure/dpMerchantPayment.jsp" method="post">

    <table border="0" cellspacing="1" cellpadding="3" width="100%" align="center" height="100%">
        <tr height="100%">
            <td>
                <input type="hidden" name="requestparameter" value="${requestparameter}">
                <input type="hidden" name="billingDtls" value="${billingDtls}">
                <input type="hidden" name="shippingDtls" value="${shippingDtls}">
                <input type="hidden" name="merchantId" value="${merchantId}">
                <input type="submit" name="submit" value="Submit">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
