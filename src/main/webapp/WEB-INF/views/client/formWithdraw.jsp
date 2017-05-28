<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Новая категория</title>
    <jsp:include page="/WEB-INF/views/client/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/client/header.jsp"/>

<div class="grow">
    <div class="container">
        <h2>Withdraw</h2>
    </div>
</div>

<!-- Add category -->
<div class="container">
    <div class="row admin-page">
        <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
            <form enctype="multipart/form-data" action="save_withdraw" method="post">
                <table class="table">
                    <tr>
                        <th>Withdraw amount:</th>
                        <td>
                            <input class="input-order" type="text" name="amount"
                                   placeholder=""
                                   minlength="1" maxlength="5" required>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <button class="btn btn-success" type="submit">OK</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    </section>
</div>
</body>
</html>

