<#include "frame.ftl">
<@frame title="石啸天的个人站" keywords="login" description="主站点">
<link href="<#assign name=pageTools.getResource("js/index/portal.css")>${name}" rel="stylesheet" type="text/css">

<script>
    function mRealy(publicData) {

        // 获取单点服务器地址
//        var loginHost = $("login-server").html();
//
//        $(".body-top-right").append(
//                "<div class='body-top-right-user'>登陆</div>" +
//                "<div class='body-top-right-userinfo hidden'>" +
//                "<div class='body-top-right-userinfo-username'></div>" +
//                "<div class='body-top-right-userinfo-logout'>退出</div>" +
//                "</div>"
//        );
//
//        if(publicData.code === 200) {
//            var username = publicData.data.username;
//            $(".body-top-right-userinfo-username").html(username + " |");
//            $(".body-top-right-userinfo").removeClass("hidden");
//            $(".body-top-right-user").addClass("hidden");
//        }
//
//
//        $(".body-top-right-user").click(function() {
//            location.href = loginHost;
//        });
//
//
//        $(".body-top-right-userinfo-logout").click(function() {
//
//            $.ajax({
//                type : "get",
//                async:false,
//                url : loginHost + "/logout",
//                dataType : "jsonp",//数据类型为jsonp
//                jsonp: "callback",//服务端用于接收callback调用的function名的参数
//                success : function(data){
//                    location.href = "/";
//                },
//                error:function(){
//                    alert('fail');
//                }
//            });
//        });



    };
</script>

<div class="app-www">

    <h1>当前位置：管理站</h1>
    <h1>${username!}</h1>

</div>

</@frame>