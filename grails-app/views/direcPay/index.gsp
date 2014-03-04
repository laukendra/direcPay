<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DirecPay Payment</title>
</head>

<body style="display: none">

<form id="direcPayForm" name="direcPayForm"
      action="${direcPayURL}" method="post">

    <table>
        <tr height="100%">
            <td>
                <input type="hidden" name="requestparameter" value="${requestparameter}"/>
                <input type="hidden" name="billingDtls" value="${billingDtls}"/>
                <input type="hidden" name="shippingDtls" value="${shippingDtls}"/>
                <input type="hidden" name="merchantId" value="${merchantId}"/>
                <input type="hidden" name="storeDtls" value="${storeDtls}">
                <input type="submit" id="submit" name="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>


<script language="JavaScript" type="text/javascript">
    window.onload = function () {
        document.getElementById("submit").click();
    }
</script>

</body>
</html>
