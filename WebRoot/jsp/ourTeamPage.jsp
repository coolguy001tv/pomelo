<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!--为视口（viewport）设置 meta 属性为 user-scalable=no 可以禁用其缩放（zooming）功能。这样禁用缩放功能后，用户只能滚动屏幕，就能让你的网站看上去更像原生应用的感觉-->
    <meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta name="author" content="pomelo">
    <meta name="copyright" content="Copyright (c) 2014-2014 pomeloworkspace">
    <title>首页</title>

    <!-- Bootstrap -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body id="frontpage">
<div class="jumbotron">
    <div class="container">
        <p class="text-left"><strong>阳玄战力值：</strong></p>
        <p id="count"><strong>${power[0]}</strong></p>
        
        <p class="text-left"><strong>周礼战力值：</strong></p>
        <p id="count"><strong>${power[1]}</strong></p>
        
        <p class="text-left"><strong>丁力战力值：</strong></p>
        <p id="count"><strong>${power[2]}</strong></p>
        
        <p class="text-left"><strong>羊邵波战力值：</strong></p>
        <p id="count"><strong>${power[3]}</strong></p>
        
        <p class="text-left"><strong>李作清战力值：</strong></p>
        <p id="count"><strong>${power[4]}</strong></p>
    </div>
</div>

</body>
</html>