<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!-- 引入bootstrap样式 -->
    <link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/js/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/js/addTabs/addTabs.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/js/treeview/bootstrap-treeview.min.css" rel="stylesheet"/>
    <!-- 引入bootstrap表格的样式 -->
    <link href="<%=request.getContextPath()%>/js/table/bootstrap-table.min.css" rel="stylesheet"/>
    <!-- 引入jQuery的js -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
    <!-- 引入bootstrap的js -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/js/bootstrap.min.js"></script>
    <!-- 引入bootstrap的bootbox的js -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootbox/bootbox.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/addTabs/addTabs.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/treeview/bootstrap-treeview.min.js"></script>
    <!-- 引入bootstrap表格的js -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/table/bootstrap-table.min.js"></script>
    <!-- 引入bootstrap表格语言的js -->
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/table/locale/bootstrap-table-zh-CN.js"></script>
    <style type="text/css">
        body {padding-top:55px;}
    </style>
</head>
<body>
<!--导航条  -->
<nav class="navbar navbar-blues navbar-fixed-top">
    <!--定义在容器顶部  -->
    <div class="container-fluid">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <!-- Brand and toggle get grouped for better mobile display -->
        <!-- 头部信息 -->
        <div class="navbar-header">
            <a class="navbar-brand glyphicon glyphicon-globe" href="#" id="menu-toggle">&nbsp;河北电力大学</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active "><a href="#" class="glyphicon glyphicon-shopping-cart">&nbsp;学校主页 <span class="sr-only">(current)</span></a></li>
                <li><a href="#" class="glyphicon glyphicon-grain">&nbsp;教师团队</a></li>
                <li><a href="#" class="glyphicon glyphicon-sunglasses">&nbsp;学生管理</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle glyphicon glyphicon-text-color" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">学院管理
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#" class="glyphicon glyphicon-cloud">商学院</a></li>
                        <li><a href="#" class="glyphicon glyphicon-th">电力学院</a></li>
                        <li><a href="#" class="glyphicon glyphicon-info-sign">外语学院</a></li>
                        <li><a href="#" class="glyphicon glyphicon-cloud-upload">计算机学院</a></li>
                        <li><a href="#" class="glyphicon glyphicon-cloud-download">工程学院</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>

            <!-- 右边的    导航 按钮 -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.jsp">登录</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- ============================导航结束==================================-->
<!--=========栅格布局 ==============-->
<div class="row">
    <div class="col-md-3">
        <!-- tree 的插件 -->
        <div id="treeDiv"></div>
    </div>

    <div class="col-md-9">
        <!--   选项卡    -->
        <!-- Nav tabs -->
        <ul id="tabs" class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active">
                <a href="#home" aria-controls="home" role="tab" data-toggle="tab">欢迎</a></li>
        </ul>
        <!-- 选项卡  内容 -->
        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" style="" class="tab-pane active " id="home">
                <div class="panel panel-primary">
                    <div class="panel-heading">今日工作</div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                    </div>
                    <div class="panel-footer">
                        Panel Footer
                    </div>
                </div>
                <div class="panel panel-primary">
                    <div class="panel-heading">未完工作</div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
                    </div>
                    <div class="panel-footer">
                        Panel Footer
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $.addtabs({iframeHeight:570});
    $.ajax({
        url:"<%=request.getContextPath()%>/login/queryPowerTreeInfo.do",
        dataType:"text",
        success:function(data){
            var tree = eval("("+data+")")
            //渲染树插件 treeview()
            $("#treeDiv").treeview({
                //data属性 树节点信息 json数组
                data: tree,
                //tree默认展开的节点级别默认为2
                levels: 0,
                //含有子节点的图标
                collapseIcon:'glyphicon glyphicon-star-empty',
                //没有子节点的图标
                emptyIcon:'glyphicon glyphicon-usd',
                //背景颜色
                //backColor: 'green'
                //是否显示复选框
                showCheckbox:true,
                //是否允许选中多个节点
                //multiSelect:true,
                //启用节点的超链接功能默认为false,节点需指定href属性
                enableLinks:true,
                //事件当节点选中时
                onNodeSelected:function(event,node){
                    //动态向 nav-tabs 导航标签添加tab选项卡
                    //addTabs方法  add() 添加tab  close()关闭tab  closeAll() 关闭全部tab
                    if(null !=  node.url){

                        $.addtabs.add({
                            id:node.id,
                            title:node.text,
                            url:node.url,
                        })
                    }
                }
            })

        }

    })

</script>
</body>
</html>