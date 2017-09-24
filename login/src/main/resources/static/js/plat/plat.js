// 此文件最好修改成纯js，在jquery之前体验更好，笔者js功底不行，不敢献丑

$(function (){

    // 获取当前环境
    var env = $("#plat-resources").attr("env");
    // 是否需要导航
    var needNav =  $("#plat-resources").attr("nav");
    // 是否显示个人信息
    var needUserInfo = $("#plat-resources").attr("userinfo");
    // 获取静态服务地址
    var logginServerUrl = getSpileUrl(env);
    // 最前面插入标签

    // 加载公共资源页面
    //

    var publicDoc =
        "<style>" +
            "*{padding:0;margin:0;font-family:'微软雅黑';}" +
            "body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,th,td,p,pre,form,input,textarea,fieldset,blockquote{padding: 0;margin: 0;}" +
            ".body-top {width: 100%;height: 100px;color: white;background: black;}" +
            ".body-top-left {height: 100%;width: 270px; float: left;}" +
            ".body-top-left-top {height: 70px;width: 270px;font-size: 50px;padding-left: 10px;line-height: 70px;}" +
            ".body-top-left-bottom {height: 30px;width: 270px;font-size: 15px;line-height: 30px;text-align: right;}" +
            ".body-top-mid {float: left;}" +
            ".body-top-right {float: right;margin-right: 40px; width: 400px;margin-top: 10px;}" +
            ".body-top-right-count {text-align: right;margin: 5px;font-size: 20px;}" +
            ".hidden {display: none}" +
            "div{cursor:default}" +
        "</style>" +
        "<div class='body-top'>" +
            "<div class='body-top-left'>" +
                "<div class='body-top-left-top'>xiaotian.shi</div>" +
                "<div class='body-top-left-bottom'>欢迎来到石啸天的个人网站</div>" +
            "</div>" +
            "<div class='body-top-mid'></div>" +
                "<div class='body-top-right'>" +
                    "<div class='body-top-right-count'></div>" +
                    "<div class='body-top-right-user hidden'>登陆</div>" +
                    "<div class='body-top-right-userinfo hidden'>" +
                    "<div class='body-top-right-userinfo-username'></div>" +
                    "<div class='body-top-right-userinfo-logout'>退出</div>" +
                "</div>" +
            "</div>" +
        "</div>" +
        "<style>" +
            ".body-nav {top: 100px;left: 0px;width: 200px;bottom:0; height:100%;position: absolute;color: white;background: #2e68aa;padding-top: 20px;}" +
            ".body-nav-item {height: 20px;font-size: 20px;padding-left: 40px;padding-top: 10px;padding-bottom: 10px;}" +
            ".body-nav-item:hover{background: #1e508a}" +
            ".current {background:#5387c3}" +
        "</style>" +
        "<div class='body-nav hidden'>" +

        "</div>"
        ;

    $("body").prepend(publicDoc);


    $.ajax({
        type : "get",
        async:false,
        url : logginServerUrl + "/cloudInfo",
        dataType : "jsonp",//数据类型为jsonp
        jsonp: "callback",//服务端用于接收callback调用的function名的参数
        success : function(data){
            var indexAccessCount = data.data.indexAccessCount;
            $(".body-top-right-count").html("访问量：" + indexAccessCount);

            if(data.code === 200 && "true" === needUserInfo) {
                $(".body-top-right-userinfo-username").html(data.data.username + " |");
                $(".body-top-right-userinfo").removeClass("hidden");
                $(".body-top-right-user").addClass("hidden");

                $(".body-top-right-user").click(function() {
                    location.href = loginHost;
                });

            }


            if(data.code === 200 && "true" === needNav) {

                var navlist = data.data.nav;
                if(navlist.length > 0) {

                    var navStr = "";
                    for(var i = 0 ; i < navlist.length ; i++) {

                        var url =navlist[i].url;

                        var nowUrl = window.location.href;

                        var current = "";
                        if(nowUrl.indexOf(url) > -1) {
                            current = "current";
                        }

                        navStr = navStr + "<div class='body-nav-item "+ current +"' url='" + url + "'>" + navlist[i].name + "</div>";

                    }
                    $(".body-nav").html(navStr);
                    $(".body-nav").removeClass("hidden");

                    $(".body-nav-item").click(function(){

                        var url = $(this).attr("url");
                        location=url;
                    })
                }
            }

            mRealy(data);
        },
        error:function(){
            alert('fail');
        }
    });


    $(".body-top-right-userinfo-logout").click(function() {

        $.ajax({
            type : "get",
            async:false,
            url : logginServerUrl + "/logout",
            dataType : "jsonp",//数据类型为jsonp
            jsonp: "callback",//服务端用于接收callback调用的function名的参数
            success : function(data){
                location.href = "/";
            },
            error:function(){
                alert('fail');
            }
        });
    });
    // 绑定高度
    $(".body-nav").height(document.documentElement.clientHeight);

});

// 默认http
// 如何组装，需要根据自己应用的域名来决定
function getSpileUrl(env) {

    var p = "http";
    var s = ":8081";
    if(typeof(env) == "undefined" || env === "product") {
        env="";
        // 暂时没有https环境
        // p = "https";
        s = "";
    }

    return p + "://login.xiaotian" + env + ".shi" + s;

}