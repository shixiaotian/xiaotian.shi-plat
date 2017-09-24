<#--公共顶部-->
<#macro frame title="" keywords="" description="">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${title} - 啸天</title>
    <meta name="keywords" content="${keywords}">
    <meta name="description" content="${description}">

    <#-- 如果拿不到jquery文件，请使用本地静态资源服务器获取 -->
    <#--<script type="text/javascript" src="<#assign name=pageTools.getResource("js/jquery/jquery-1.7.min.js")>${name}"></script>-->
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.7/jquery.min.js"></script>
    <#-- 公用静态资源 -->
    <script type="text/javascript"
            src="<#assign platJsUrl=pageTools.getResource('js/plat/plat.js')>${platJsUrl}"
            id="plat-resources"
            env="<#assign env=pageTools.getEnv()>${env}"
            nav="true"
            userinfo="true"
    ></script>


</head>
<body>
    <#nested>
</body>
</html>
</#macro>