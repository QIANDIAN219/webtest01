<%@ page import="cn.edu.guet.bean.User" %>
<%@ page import="cn.edu.guet.bean.Role" %>
<%@ page import="cn.edu.guet.bean.Tree" %><%--
  Created by IntelliJ IDEA.
  User: Lanzh
  Date: 2021/6/20
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="css/leftMenu.css">
        <script src="http://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
        <script src="js/leftMenu.js"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="leftMenu">
                <ul>
                    <%
                        User user = (User) request.getAttribute("user");
                        String[][] title = new String[10][10];
                        boolean flag = false;
                        int m = 0, n = 0;
                        for(Role role : user.getRoleList()) {
                            for(Tree tree : role.getTreeList()) {
                                if (tree.getIsParent().equals("True")) {
                                    m++;
                                    n=0;
                                } else {
                                    n++;
                                }
                                title[m][n] = tree.getTitle();
                            }
                        }
                    %>
                    <%
                        for(int i = 1; i < title.length; i++) {
                            if(title[i][0] != null) {
                    %>
                                <li>
                                <a href="#"><%=title[i][0]%></a>
                                    <ul>
                    <%
                                    for(int j = 1; j < title[i].length; j++) {
                                        if(title[i][j] != null) {
                    %>
                                            <li><a href="#"><%=title[i][j]%></a></li>
                    <%
                                        }
                                    }
                    %>
                                    </ul>
                                </li>
                    <%
                            }
                        }
                    %>
                    <li>
                        <a href="#">------------</a>
                        <ul>
                            <li><a href="#">------------</a></li>
                            <li><a href="#">------------</a></li>
                        </ul>
                    </li>

                    <c:forEach items="${user.roleList[0].treeList}" var="tree" varStatus="status">
                        <c:choose>
                            <c:when test="${tree.isParent eq true}">
                                <c:set var="eixtId" value="${user.roleList[0].treeList.size()}"></c:set>
                                <li>
                                    <a href="javascript:void(0)">${tree.title}</a>
                                    <ul>
                                        <c:forEach items="${user.roleList[0].treeList}" var="trees" varStatus="statuss" begin="${status.index+1}">
                                            <c:if test="${trees.isParent eq true}">
                                                <c:set var="eixtId" value="${statuss.index}"></c:set>
                                            </c:if>
                                            <c:if test="${statuss.index < eixtId}">
                                                <li><a href="javascript:void(0)">${trees.title}</a></li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:when>
                        </c:choose>
                    </c:forEach>


                </ul>
            </div>
        </div>
    </body>
</html>
