<%@ page import="cn.edu.guet.bean.User" %>
<%@ page import="cn.edu.guet.bean.Role" %>
<%@ page import="cn.edu.guet.bean.Tree" %><%--
  Created by IntelliJ IDEA.
  User: Lanzh
  Date: 2021/6/20
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
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
                            System.out.println("m=" + m + "n=" + n + tree.getTitle());
                        } else {
                            n++;
                            System.out.println("m=" + m + "n=" + n + tree.getTitle());
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
                <a href="#">导入培养方案与成绩</a>
                <ul>
                    <li><a href="#">导入培养方案</a></li>
                    <li><a href="#">导入培养成绩</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
