<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Account</title>
    <jsp:include page="/WEB-INF/views/client/head.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/client/header.jsp"/>
<style>
    .green {
        color: green;
    }

    .red    {
        color: red;
    }
</style>

<div class="grow">
    <div class="container">
        <h2>Account application</h2>
    </div>
</div>

<!-- All categories -->
<div class="container">

    <div class="row admin-page">
       <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                <table class="table table-striped">
                    <tr>
                        <th>Account Balance</th>
                        <td>${account.accountBalance}</td>
                        <th>
                            <a href="deposit" title="">
                                <button class="btn btn-success" type="submit">Deposit</button>
                            </a>
                            <a href="withdraw" title="">
                                <button class="btn btn-danger" type="submit">Withdraw</button>
                            </a>
                        </th>
                    </tr>
                </table>
                                                                                                                                        <br><br><br>
           <table class="table table-striped">
               <tr>
                   <th>Date</th>
                   <th>Amount</th>
                   <th>Description</th>
                   <th>Available Balance</th>
                   <th>Status</th>

               </tr>

               <c:forEach items="${transactions}" var="transaction">
                   <c:choose>
                   <c:when test="${transaction.description == 'Deposit'}">
                   <tr>
                       <td class="green">${transaction.date}</td>
                       <td class="green">${transaction.amount}</td>
                       <td class="green">${transaction.description}</td>
                       <td class="green">${transaction.availableBalance}</td>
                       <td class="green">${transaction.status}</td>
                   </tr>
                   </c:when>
                   <c:otherwise>
                   <td class="red">${transaction.date}</td>
                   <td class="red">${transaction.amount}</td>
                   <td class="red">${transaction.description}</td>
                   <td class="red">${transaction.availableBalance}</td>
                   <td class="red">${transaction.status}</td>
                   </c:otherwise>
              </c:choose>
               </c:forEach>
           </table>

        </div>
    </div>
</div>
</body>
</html>

