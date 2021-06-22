<%@ page import="cn.edu.guet.bean.User" %>
<%@ page import="cn.edu.guet.bean.Role" %>
<%@ page import="cn.edu.guet.bean.Tree" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lanzh
  Date: 2021/6/20
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%List<Tree> treeList = (List<Tree>) request.getAttribute("treeList");%>
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
                        for(int i = 0; i < treeList.size(); i++) {
                            if(treeList.get(i).getIsParent().equals("True")) {
                    %>
                    <li>
                        <a href="#"><%=treeList.get(i).getTitle()%></a>
                        <ul>
                            <%
                                for(int j = i + 1; j < treeList.size(); j++) {
                                    if(treeList.get(j).getIsParent().equals("True")) {
                                        break;
                                    }
                            %>
                            <li><a href="#"><%=treeList.get(j).getTitle()%></a></li>
                            <%
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

                    <c:forEach items="${treeList}" var="tree" varStatus="status">
                        <c:choose>
                            <c:when test="${tree.isParent eq true}">
                                <c:set var="eixtId" value="${treeList.size()}"></c:set>
                                <li>
                                    <a href="javascript:void(0)">${tree.title}</a>
                                    <ul>
                                        <c:forEach items="${treeList}" var="trees" varStatus="statuss" begin="${status.index+1}">
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
                    <li>
                        <a href="#">------------</a>
                        <ul>
                            <li><a href="#">------------</a></li>
                            <li><a href="#">------------</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
