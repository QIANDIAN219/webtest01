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
            <%String userid = (String) request.getAttribute("userid");%>
            $(function() {
                $.ajax({
                    url:'gettree?userid=<%=userid%>',
                    async:false,
                    success:function(data) {
                        $.each(data, function(index, treef) {
                            if(treef.isParent=="True") {
                                var li = $("<li><a href=\"javascript:void(0)\">"  + treef.title + "</a><ul></ul></li>");
                                $("#leftMenu>ul").append(li);
                                var startIndext = index;
                                var flag = true;
                                $.each(data, function(index, trees) {
                                    if(startIndext < index && trees.isParent=="True") {
                                        flag = false;
                                    }
                                    if(startIndext < index && flag) {
                                        var li = $("<li><a href=\"javascript:void(0)\">"  + trees.title + "</a></li>");
                                        $("#leftMenu>ul>li:last>ul").append(li);
                                    }
                                })
                            }
                        })
                    }
                })
            })
            $(document).ready(function() {
                $("#leftMenu>ul>li a").each(function() {
                    $(this).click(function() {
                        var flag = $(this).parent().children("ul").is(":visible");
                        if(flag) {
                            $(this).parent().children("ul").hide();
                        } else {
                            $(this).parent().children("ul").show();
                        }
                    })
                })
            })
        </script>
    </head>
<body>
<div id="wrapper">
    <div id="leftMenu">
        <ul>

        </ul>
    </div>
</div>
</body>
</html>
