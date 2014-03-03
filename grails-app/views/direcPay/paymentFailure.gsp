<html>

<head>
    <title>DirecPay Failure Response</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="kickstart"/>
    <g:set var="layout_nomainmenu" value="${true}" scope="request"/>
    <g:set var="layout_nosecondarymenu" value="${true}" scope="request"/>
</head>

<body>
<h1 style="background-color: red">DirecPay Failure Response</h1>

<p style="background-color: #e3e5e9"><strong>response:</strong>${response.dump()}</p>

<p style="background-color: #e3e5e9"><strong>params:</strong>${params.dump()}</p>

<p style="background-color: #e3e5e9"><strong>responseDto:</strong>${responseDto.dump()}</p>
</body>
</html>