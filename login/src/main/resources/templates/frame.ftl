<#--公共顶部-->
<#macro frame title="" keywords="" description="">
<!DOCTYPE html>
<html>
<head lang="en">
    <mainserver style="display: none"><#assign mainserver=pageTools.getMainServerHost()>${mainserver}</mainserver>
    <meta charset="UTF-8">
    <title>${title} - 啸天</title>
    <meta name="keywords" content="${keywords}">
    <meta name="description" content="${description}">

    <#--<link rel="stylesheet" type='text/css' href="/static/style/common.css"/>-->
    <#--<script type="text/javascript" src="<#assign name=pageTools.getResource("js/jquery/jquery-1.7.min.js")>${name}"></script>-->
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.7/jquery.min.js"></script>
    <#-- 公用静态资源 -->
    <script type="text/javascript"
            src="<#assign name=pageTools.getResource("js/plat/plat.js")>${name}"
            id="plat-resources"
            env="<#assign env=pageTools.getEnv()>${env}"
            nav="false"
    ></script>


</head>
<body>
    <#nested>
</body>
</html>
</#macro>