<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link rel="stylesheet" href="css/index.css">
        <script src="http://cdn.staticfile.org/jquery/3.6.0/jquery.js"></script>
        <script>
            // window.onload = function() {
            //     document.getElementById("username").onblur = function() {
            //         document.getElementById("username").className = "checkUsername"
            //         console.log(document.getElementById("username").value);
            //         console.log(document.getElementById("password").value);
            //     }
            // }
            // gson格式
            var student = {
                'id':'1800710324',
                'name':'lzh'
            }
            $(document).ready(function(){
                $("input[id='username']").blur(function(){
                    $(this).addClass("checkUsername");
                    // 开始检测用户名是否能用
                    xmlHttp = new XMLHttpRequest();//创建request对象
                    xmlHttp.onreadystatechange = checkUsername;  // (回调函数)服务器响应后，谁负责处理服务器响应的数据
                    xmlHttp.open("GET", "checkusername?username=" + $(this).val());  // 開啟連結
                    xmlHttp.send(null);  // 傳送請求
                })
            })
            function checkUsername() {
                if(xmlHttp.readyState == 4) {
                    if(xmlHttp.status == 200) {
                        console.log(typeof xmlHttp.responseText);   //查看类型
                        console.log(typeof eval('('+xmlHttp.responseText+')'));//不推荐使用
                        console.log(typeof JSON.parse(xmlHttp.responseText));
                        rel = JSON.parse(xmlHttp.responseText);
                        if(rel.result == "disable") {
                            $("input[id='username']").addClass("Usernamet");
                            console.log(rel.result);
                        } else if(rel.result == "enable"){
                            $("input[id='username']").addClass("Usernamef");
                            console.log(rel.result);
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <form action="login1" method="POST">
            <label for="username">用户名：</label><input type="text" class="username" name="username" id="username">
            <label for="password">密码：</label><input type="password" name="password" id="password">
            <input type="submit" value="登录">
        </form>
    </body>
</html>
