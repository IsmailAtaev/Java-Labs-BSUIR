
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<h2>Пример использования вывода на данных</h2>
    <div>При использовании "out" контекст указывается в формате requestScope.youreObj"</div>
    <c:out value="${requestScope.simpleOutput.text}"/>
    <hr />

    <sql:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
                       url = "jdbc:mysql://localhost:3306"
                   user = "root"  password = "admin123"/>

    <div>При использовании "set" контекст указывается в формате scope="request"</div>
    <c:set var="operations" scope="request" value="${operations}" />
    <hr/>

    <h2>Пример использования цикла:</h2>
    <c:forEach items="${operations}" var="operation">
        <c:out value="${operation}"/><br />
    </c:forEach>
    <hr />


    <h2>Пример использования условного оператора:</h2>
    <c:if test="${requestScope.condition eq true}">
        <div>Сработал условный оператор</div>
    </c:if>

    <c:set var = "string1" value = "This is first String."/>
    <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
    <c:set var = "string3" value = "${fn:join(string2, '-')}" />
    <p>Final String : ${string3}</p>


        <c:set var = "theString" value = "I am a test String 123"/>

        <c:if test = "${fn:endsWith(theString, '123')}">
        <p>123<p>
            </c:if>

            <c:if test = "${fn:endsWith(theString, 'TEST')}">
        <p> TEST<body>
            </c:if>


    </body>
</html>
