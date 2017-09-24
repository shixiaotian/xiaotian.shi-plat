<#include "frame.ftl">

<@frame title="单点登陆系统" keywords="login" description="用于登陆平台的登陆系统">

<#--<script type="text/javascript" src="<#assign name=pageTools.getResource("js/jquery/Particleground.js")>${name}"></script>-->
<link href="<#assign name=pageTools.getResource("css/login.css")>${name}" rel="stylesheet" type="text/css">

    <style>
        body{height:100%;background:#16a085;}
        canvas{z-index:-1;position:absolute;}
        /* 指定top颜色 */
        .body-top{background:#5cbdaa;}
    </style>
    <script>
        function mRealy(publicData) {
//            //粒子背景特效
//            $('body').particleground({
//                dotColor: '#5cbdaa',
//                lineColor: '#5cbdaa'
//            });

            // 检测是否登陆
            if(publicData.code === 200) {

                username = publicData.data.username;
                login_success(username);

            }

            $(document).keyup(function(event) {

                if (event.keyCode == 13) {
                    submit();
                }
            });

            // 提交登陆
            $("#submit_login").click(function() {

                submit();

            });

            function submit() {
                var username = $("#username").val();
                var password = $("#password").val();
                var validateCode = $("#J_codetext").val();

                $.post("/login", {username:username, password:password, captchaCode:validateCode}, function(data) {
                    if(data.code === 200) {
                        login_success(username);
                    } else {
                        alert(data.msg);
                        if(data.code ===202) {
                            createCode();
                        }
                    }
                });
            }

            // 监听验证码输入
            $('#J_codetext').bind('input propertychange', function() {

                var code = $(this).val();

                if(code.length > 3) {


                    $.post("/validateCaptchaCode",{captchaCode:code},function(data){

                        if(data.code === 200) {

                        } else {
                            $("#J_codetext").value = "";
                            $("#J_codetext").attr("placeholder", "验证码错误");
                            createCode();
                        }
                    });

                }
            });
            // 新增返回登陆按钮
            $(".body-top-right").append("<div class='body-top-right-user'>返回主页</div>");

            $(".body-top-right-user").click(function() {
                var mainserver = $("mainserver").html();
                location.href = mainserver;
            });

        }

        // 登陆成功
        function login_success(username){

            $(".user_icon").addClass("hidden");
            $(".pwd_icon").addClass("hidden");
            $(".val_icon").addClass("hidden");
            $(".submit_btn").addClass("hidden");
            $(".welcome").removeClass("hidden");
            $(".welcome-name").html(username);



            // 重定向
            setTimeout("redirectMain()",3000);

            setInterval(function() {

                var progressLength = $(".welcome-progress").html().length;
                if(progressLength > 30) {
                    $(".welcome-progress").html("");
                }
                $(".welcome-progress").append(".");
            },100);


        }

        function redirectMain() {

            var targetUrl = GetQueryString("redirect");
            if(targetUrl!=null && targetUrl.length > 0) {
                location.href=targetUrl;
            } else {

                var mainserver = $("mainserver").html();
                location.href = mainserver;
            }
        }

        function createCode() {
            $(".codeimg").empty();
            $(".codeimg").append("<img id='validateCode' src='/login-captcha-image' width='120px' height='44px' onclick='createCode()'/>")
        }

        function GetQueryString(name)
        {
            var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if(r!=null)return  unescape(r[2]); return null;
        }

    </script>

<canvas class="pg-canvas" width="1669" height="500"></canvas>
<dl class="admin_login">
    <dt>
        <strong>中二病平台</strong>
        <em>Management System</em>
    </dt>
    <dd class="user_icon">
        <input type="text" placeholder="账号" class="login_txtbx" id="username">
    </dd>
    <dd class="pwd_icon">
        <input type="password" placeholder="密码" class="login_txtbx" id="password">
    </dd>
    <dd class="val_icon">
        <div class="checkcode">
            <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
            <div class="codeimg" >
                <img id="validateCode" src="/login-captcha-image" width="120px" height="44px" onclick="createCode()"/>
            </div>

        </div>
    </dd>
    <dd>
        <input type="button" value="碾碎他们" class="submit_btn" id="submit_login">
    </dd>
    <div class="welcome hidden">
        <dd class="welcome-top" >欢迎回来</dd>
        <div class="welcome-name" ></div>
        <div class="welcome-progress"></div>
    <div>

</dl>

</@frame>