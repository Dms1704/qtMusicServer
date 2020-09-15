<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>囚徒音乐网站系统后台登录页面</title>
    <script src="js/jquery2.js"></script>
    <script src="layer/layer.js"></script>
    <link rel="stylesheet" href="css/login.css">
    <SCRIPT type="text/javascript">
        $(function(){
            //得到焦点
            $("#password").focus(function(){
                $("#left_hand").animate({
                    left: "150",
                    top: " -38"
                },{step: function(){
                        if(parseInt($("#left_hand").css("left"))>140){
                            $("#left_hand").attr("class","left_hand");
                        }
                    }}, 2000);
                $("#right_hand").animate({
                    right: "-64",
                    top: "-38px"
                },{step: function(){
                        if(parseInt($("#right_hand").css("right"))> -70){
                            $("#right_hand").attr("class","right_hand");
                        }
                    }}, 2000);
            });
            //失去焦点
            $("#password").blur(function(){
                $("#left_hand").attr("class","initial_left_hand");
                $("#left_hand").attr("style","left:100px;top:-12px;");
                $("#right_hand").attr("class","initial_right_hand");
                $("#right_hand").attr("style","right:-112px;top:-12px");
            });
        });
        $(function () {
            $("#login").click(function () {
                var admin_name=$("#userName").val();
                var admin_password=$("#password").val();
                if(admin_name==''){
                    $("#error").html("用户名不能为空")
                    return;
                }
                if(admin_password==''){
                    $("#error").html("密码不能为空")
                    return;
                }
                $.ajax({
                    type:"post",
                    url:"login",
                    dataType:"json",
                    data:{
                        admin_name:admin_name,
                        admin_password:admin_password,
                    },
                    success:function(result) {
                        if(result.success){
                            location.href='index.jsp?admin_name="'+admin_name+'"';
                        }else{
                            alert("用户名或密码错误")
                        }
                    }
                })
            })
        })

    </SCRIPT>
</head>
<body>
<DIV class="top_div">
</DIV>
<form action="" method="post">
    <DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
        <DIV style="width: 165px; height: 96px; position: absolute;">
            <DIV class="tou">
            </DIV>
            <DIV class="initial_left_hand" id="left_hand">
            </DIV>
            <DIV class="initial_right_hand" id="right_hand">
            </DIV>
        </DIV>
        <P style="padding: 30px 0px 10px; position: relative;">
            <SPAN class="u_logo"></SPAN>
            <INPUT id="userName" name="userName" class="ipt" type="text" placeholder="请输入用户名" value="">
        </P>
        <P style="position: relative;">
            <SPAN class="p_logo"></SPAN>
            <INPUT id="password" name="password" class="ipt"  type="password" placeholder="请输入密码" value="">
        </P>
        <DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
            <P style="margin: 0px 35px 20px 45px;">
                <SPAN style="float: left;"><a href="#">囚徒音乐欢迎您</a></SPAN>
                <span><font color="red" id="error" /></span>
                <SPAN style="float: right;">
	              <input type="submit" id="login" style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" value="登录"/>
	         </SPAN>
            </P>
        </DIV>
    </DIV>
</form>
</body>
</html>