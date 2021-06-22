<%--
  Created by IntelliJ IDEA.
  User: Lanzh
  Date: 2021/6/22
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="css/leftMenu.css">
        <script src="http://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
        <script>
            $(function() {
                $.ajax({
                    url:'gettree',
                    success:function(data) {
                        console.log(data);
                    }
                })
            })
        </script>
    </head>
<body>

</body>
</html>
