<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/common/mystyle.jsp"></jsp:include>
<html>
<head>
	<style>
		*
		{
			margin: 0;
			padding: 0;
		}
		/*蓝色按钮,绝对定位*/
		.blueButton
		{
			position: absolute;
			display: block;
			width: 100px;
			height: 40px;
			background-color: #00b3ee;
			color: #fff;
			text-decoration: none;
			text-align: center;
			font:normal normal normal 16px/40px 'Microsoft YaHei';
			cursor: pointer;
			border-radius: 4px;
		}
		.blueButton:hover
		{
			text-decoration: none;
		}
		/*自定义上传,位置大小都和a完全一样,而且完全透明*/
		.myFileUpload
		{
			position: absolute;
			display: block;
			width: 100px;
			height: 40px;
			opacity: 0;
		}
		/*显示上传文件夹名的Div*/
		.show
		{
			position: absolute;
			top:40px;
			width: 100%;
			height: 30px;
			font:normal normal normal 14px/30px 'Microsoft YaHei';
		}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <br>
	<!--  条件查询的 form  表单  -->
	 <form id="pro_from" class="form-inline">
		 <div class="form-group">
			 <label>药品类型：</label>
			 <select  id="drugType" class="form-control">
				 <option value="">请选择</option>
				 <option value="1" >中药</option>
				 <option value="2" >西药</option>
				 <option value="3" >草药</option>
			 </select>
		 </div>
         <br>
         <div class="form-group">
             <label>药品名称：</label> <input type="text" class="form-control" id="drugName" placeholder="药品名称">
         </div>
		<br>
         <div class="form-group">
             <label>药品价格：</label>
             <input type="number" class="form-control"  id="drugPricemin" placeholder="药品价格" >至
             <input type="number" class="form-control"  id="drugPricemax" placeholder="药品价格" >
         </div>
         <br>
		<div class="form-group">
			<label>生产日期：</label> <input
				class="form-control " id="minTime"
				onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'maxTime\')}'})" />至 <input
				class="form-control " id="maxTime"
				onfocus="WdatePicker({minDate:'#F{$dp.$D(\'minTime\')}'})" /><br />
		</div>
         <br><br>

		<button type="button" class="btn btn-warning" onclick="searchDrug()">搜索</button>
		<button type="button" class="btn btn-danger" onclick="reset()">重置</button>
	</form>
    <br><br>


	<div class="btn-group">

	<%--	<input id="lefile" type="file" style="display:none">
        <input class="form-control" id="photoCover" class="input-large" type="text" style="height:30px;">
		<a class="btn" onclick="$('input[id=lefile]').click();">Browse</a><br>--%>
	<%--	<div>
		<a href='javascript:void(0);' class="blueButton">选择文件</a>
		<input type="file" class="myFileUpload" />
		<div class="show"></div>
		</div>--%>
		<form id="importExcelForm" action="<%=request.getContextPath()%>/drug/importexcel.do" enctype="multipart/form-data" method="post">
		<div class="form-group">
			<input class="form-control"  name="excle"  type="file" multiple/>
			<button type="submit" class="btn btn-primary">导入Excel数据</button>
		</div>
	</form>

		<button type="button" class="btn btn-warning" onclick="exportdatatoexcelDrug()">
			<span class="glyphicon glyphicon-plane">导出Excel文档</span>
		</button>

	</div>


		<%--<div class="btn-group">
			<button type="button" class="btn btn-warning" onclick="saveInfo()">
				<span class="glyphicon glyphicon-plane">新增</span>
			</button>
			<button type="button" class="btn btn-success"
				onclick="updateInfo()">
				<span class="glyphicon glyphicon-edit">修改</span>
			</button>
			<button type="button" class="btn btn-danger">
			<span class="glyphicon glyphicon-remove" onclick="deleteInfo()">删除</span>
		</button>
			<button type="button" class="btn btn-primary">
				<span class="glyphicon glyphicon-scissors" onclick="recycleInfo()">回收站</span>
			</button>
		</div>
	</div>--%>

    <table id="DrugTable"></table>
	<script type="text/javascript">


//-------------------------------------------------------------------------------------------------------------------------------------------


//导出excel
	function exportdatatoexcelDrug(){
		var data =$("#DrugTable").serialize();
		location.href="<%=request.getContextPath()%>/drug/toexcel.do?"+data;
	}


    /*
	*发送ajax请求获取jsp页面内容
	*/
    function getJspHtml(urlStr){
        var  jspHtml = "";
        //	async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
        //注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
        $.ajax({
            url:urlStr,
            type:'post',
            //同步的ajax
            async:false,
            success:function(data){
                //alert(data);//data--addProduct.jsp页面内容
                jspHtml = data;
            },
            error:function(){
                bootbox.alert("ajax失败");
            }
        });
        return jspHtml;
    }

    //模态窗口
    function  dialog(HTMLurl,submitUrl,title){
        var dialog = bootbox.dialog({
            title: title,
            message: getJspHtml(HTMLurl),   //调用方法
            buttons:{
                "save":{
                    label: '保存信息',
                    //自定义样式
                    className: "btn-success",
                    callback: function() {
                        $.ajax({
                            url:submitUrl,
                            type:'post',
                            data:$("#drugForm").serialize(),
                            success:function(data){
                                bootbox.alert("保存成功");
                                location.href=location;
                            },
                            error:function(){
                                bootbox.alert("保存失败");
                            }
                        });
                    }
                },
                "unSave":{
                    label: '取消',
                    //自定义样式
                    className: "btn-info",
                    callback: function() {
                        // return false;  //dialog不关闭
                    }
                }
            }
        });
    }

    //新增
    function saveInfo(){
        dialog("<%=request.getContextPath()%>/drug/drugDialog.do","<%=request.getContextPath()%>/drug/drugSubmit.do","新增药品信息");
    }

    //修改
    function updateInfo(){
        if($("[name='cho']:checked").length==1){
            var id=$("[name='cho']:checked")[0].value;
            dialog("<%=request.getContextPath()%>/drug/drugDialog.do?drugId="+id,"<%=request.getContextPath()%>/drug/drugSubmit.do","修改药品信息");
        }else{
            bootbox.alert("只能修改一个");
        }
    }
	//回收站
	function recycleInfo(){
		location.href="<%=request.getContextPath()%>/drug/torecycleDrugList.do";
	}
//---------------------------------------------------------------------------------------------------------------------------------------------------
    //条件查询
        function searchDrug(){
            $("#DrugTable").bootstrapTable('refresh',
                {query: {
                        "drugName":$("#drugName").val(),
                        "drugType":$("#drugType").val(),
                        "drugAdddatemin":$("#minTime").val(),
                        "drugAdddatemax":$("#maxTime").val(),
                        "drugPricemin":$("#drugPricemin").val(),
                        "drugPricemax":$("#drugPricemax").val(),
                    }}
            );
        }

        //查询
     $(function (){
 		$("#DrugTable").bootstrapTable({
 			 url:"<%=request.getContextPath()%>/drug/queryDrugAll.do",
 			 method:"post",
 			 striped: true,  	// 斑马线效果     默认false 
 			 //只允许选中一行
 			 singleSelect:true,
 			 //选中行是不选中复选框或者单选按钮
 			 clickToSelect:true,
 			 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
 			 cardView: false,                    //是否显示详细视图
 			 uniqueId: "drugId",                 //每一行的唯一标识，一般为主键列
 			 showColumns: true,                  //是否显示所有的列
 			 showRefresh: true,                  //是否显示刷新按钮
 			 minimumCountColumns: 2,     //  最少留两列
 			 detailView: false,                  //是否显示父子表
 			 //发送到服务器的数据编码类型  
 			contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
 			toolbar:'#tabToolBar',   //  工具定义位置
 			columns:[
  			     	{field:'drugId',title:'ID',width:50,class:"info",
 						formatter:function(value,row,index){   //  格式化  当前单元格内容
 							return "<input type='checkbox' value="+value+" name='cho'/>";
 						}
 					},
					{field:'drugName',title:'药品名称', class:'info',width:100},
					{field:'brandName',title:'药品品牌', class:'info',width:100},
					{field:'drugType',title:'药品类型', class:'info',width:100,
						formatter:function(value,row,index){
							if(value==1){
								return "中药";
							}
							if(value=2){
								return "西药";
							}
							if(value=3){
								return "草药";
							}
						}},
					{field:'drugPrice',title:'药品价格', class:'info',width:100},
                    {field:'drugHits',title:'药品点击率', class:'info',width:100},
					{field:'drugAdddate',title:'生产日期', class:'info',width:100,
						formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
							var simfomat = new Date();
						simfomat.setTime(value);   //转换时间
						return  simfomat.toLocaleDateString();
						}},
					{field:'drugInfo',title:'药品介绍', class:'info',width:100},
                    {field:'asd',title:'操作', class:'info',width:100,
                        formatter:function(value,row,index){
                            var look = '<button type="button" class="btn btn-primary" onclick="lookdrug('+row.drugId+')">查看</button>'+
                                '<button type="button" class="btn btn-success" onclick="shendrug('+row.drugId+')">审核</button>'
                            return look;
                        }},
				 ],

				 //传递参数（*）
				 queryParams: function(params) {
						var whereParams = {
								/*
									分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）
								*/
								"pageSize":params.limit,
								"start":params.offset,
                                "drugName":$("#drugName").val(),
                                "drugType":$("#drugType").val(),
                                "drugAdddatemin":$("#minTime").val(),
                                "drugAdddatemax":$("#maxTime").val(),
                                "drugPricemin":$("#drugPricemin").val(),
                                "drugPricemax":$("#drugPricemax").val(),
						}
						 return whereParams;
					 },
					 //前台--排序字段
					 //sortName:'proPrice',
					 //sortOrder:'desc',
					 //前台--搜索框
					 search:true,
					 //启动回车键做搜索功能
					 searchOnEnterKey:true,
					//分页方式   后台请求的分页方式
					 sidePagination:'server',
					 pagination: true,                   //是否显示分页（*）
					 pageNum: 1,                       //每页的记录行数（*）
					 pageSize: 3,                       //每页的记录行数（*）
					 pageList: [3, 6, 9,12],        //可供选择的每页的行数（*）
 		});
 	})
 	
//--------------------------------------------------------------------------------------------------------------------------------------------------
     //删除
     function deleteDrug(id){
  			$.ajax({
      		    		url:"<%=request.getContextPath()%>/drug/updateDrugByState.do?drugId="+id,
      		    		success:function(){
      		    			bootbox.alert('删除成功');
      		    			//刷新
      		    			location.href = location;
      		    		}
      		    	})
     }

        //查看
        function  lookdrug(id){
            var dialog = bootbox.dialog({
                title:'查看药品详细信息',
                message: getJspHtml("<%=request.getContextPath()%>/drug/tolookDrugInfo.do?drugId="+id),   //调用方法
                buttons:{

                    "unSave":{
                        label: '取消',
                        //自定义样式
                        className: "btn-info",
                        callback: function() {
                            // return false;  //dialog不关闭
                        }
                    }
                }
            });
        }
     </script>
</body>
</html>
<script>
    $(document).ready(function()
    {
        $(".myFileUpload").change(function()
        {
            var arrs=$(this).val().split('\\');
            var filename=arrs[arrs.length-1];
            $(".show").html(filename);
        });
    });
</script>