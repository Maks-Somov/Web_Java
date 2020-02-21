<%@ page import="main.model.ContactType" %>
<%@ page import="main.storage.XMLFileStorage" %>
<%@ page import="main.web.HtmlUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Maks
  Date: 21.02.2020
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>list resume</title>
</head>
<section>
    <table>
        <tr>
            <td colspan="5" style="text-align: right"><a href="/Resume?action=create"><img src="img/add.png">Add resume</a> </td>
        </tr>
        <tr>
            <td>
                <table border="1" cellpadding="8" cellspacing="0" style="margin: auto">
                    <tr>
                        <th>Имя</th>
                        <th>Проживание</th>
                        <th>Email</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                        <%
//                            request.setAttribute("resumeList", WebAppConfig.get().getStorage().getAllSorted());
                            request.setAttribute("resumeList", new XMLFileStorage("D:\\Web_Java\\file_storage"));
                        %>
                        <c:forEach items="${resumes}" var="resume">
                            <jsp:useBean id="resume" type="main.model.Resume"/>
                    <tr>
                        <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                        <td><%=HtmlUtil.getContact(resume, ContactType.MAIL)%></td>
                        <td><a href="resume?uuid=${resume.uuid}&action=delete"><img src="img/delete.png"></a></td>
                        <td><a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></td>
                    </tr>
                    </c:forEach>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</section>
</section>

<body>

</body>
</html>
