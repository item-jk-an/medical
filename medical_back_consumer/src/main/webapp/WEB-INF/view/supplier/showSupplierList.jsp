<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/common/mystyle.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
		<!--  条件查询的 form  表单  -->
		<form id="pro_from" class="form-inline">
			<div class="form-group">
				<label>信誉等级：</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<select  id="supCreditlevel" class="form-control">
					<option value="">请选择</option>
					<option value="1" >Aaa级</option>
					<option value="2" >Aa级</option>
					<option value="3" >A级</option>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label>供应商名称：</label>
				<input type="text" class="form-control" id="supName" placeholder="供应商名称">
			</div>
			<br>
			<div class="form-group">
				<label>供应商地址：</label>
				<input type="text" class="form-control" id="supAddress" placeholder="供应商地址">
			</div>
			<br>
			<div class="form-group">
				<label>创建日期：</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<input
					class="form-control " id="minTime"
					onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'maxTime\')}'})" />至 <input
					class="form-control " id="maxTime"
					onfocus="WdatePicker({minDate:'#F{$dp.$D(\'minTime\')}'})" /><br />
			</div>
			<br><br>
			<button type="button" class="btn btn-warning" onclick="searchSupplier()">搜索</button>
			<button type="button" class="btn btn-danger" onclick="reset()">重置</button>
		</form>
		<br><br>
		<div class="btn-group">
			<form id="importExcelForm" action="<%=request.getContextPath()%>/supplier/importexcel.do" enctype="multipart/form-data" method="post">
				<div class="form-group">
					<input class="form-control"  name="excle"  type="file" multiple/>
					<button type="submit" class="btn btn-primary">导入Excel数据</button>
				</div>
			</form>
			<button type="button" class="btn btn-warning" onclick="importdatatoexcelSupplier()">
				<span class="glyphicon glyphicon-plane">导出Excel文档</span>
			</button>
		</div>
		<table id="supplierTable"></table>
        <script type="text/javascript">


//-------------------------------------------------------------------------------------------------------------------------------------------

	//导出excel
	function importdatatoexcelSupplier(){
		var data =$("#supplierTable").serialize();
		location.href="<%=request.getContextPath()%>/supplier/toexcel.do?"+data;
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
		//查看
		function  looksupplier(id){
			var dialog = bootbox.dialog({
				title:'查看供应商详细信息',
				message: getJspHtml("<%=request.getContextPath()%>/supplier/querySupplierById.do?id="+id),   //调用方法
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
//---------------------------------------------------------------------------------------------------------------------------------------------------
    //条件查询
        function searchSupplier(){
            $("#supplierTable").bootstrapTable('refresh',
                {query: {
                        "supCreditlevel":$("#supCreditlevel").val(),
                        "supName":$("#supName").val(),
                        "supAddress":$("#supAddress").val(),
                        "supAdddatemin":$("#minTime").val(),
                        "supAdddatemax":$("#maxTime").val(),
                    }}
            );
        }

        //查询
     $(function (){
 		$("#supplierTable").bootstrapTable({
 			 url:"<%=request.getContextPath()%>/supplier/querySupplierAll.do",
 			 method:"post",
 			 striped: true,  	// 斑马线效果     默认false 
 			 //只允许选中一行
 			 singleSelect:true,
 			 //选中行是不选中复选框或者单选按钮
 			 clickToSelect:true,
 			 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
 			 cardView: false,                    //是否显示详细视图
 			 uniqueId: "supId",                 //每一行的唯一标识，一般为主键列
 			 showColumns: true,                  //是否显示所有的列
 			 showRefresh: true,                  //是否显示刷新按钮
 			 minimumCountColumns: 2,     //  最少留两列
 			 detailView: false,                  //是否显示父子表
 			 //发送到服务器的数据编码类型  
 			contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
 			toolbar:'#tabToolBar',   //  工具定义位置
 			columns:[
  			     	{field:'supId',title:'ID',width:50,class:"info",
 						formatter:function(value,row,index){   //  格式化  当前单元格内容
 							return "<input type='checkbox' value="+value+" name='cho'/>";
 						}
 					},
					{field:'supName',title:'供应商名称', class:'info',width:100},
					{field:'supLinkman',title:'供应商联系人', class:'info',width:100},
					{field:'supPhone',title:'联系电话', class:'info',width:100},
					{field:'supAddress',title:'供应商地址', class:'info',width:100},
                    {field:'brandName',title:'代理的品牌', class:'info',width:100},
				    {field:'supCreditlevel',title:'信誉等级', class:'info',width:100,
                    formatter:function(value,row,index){
                        if(value==1){
                            return "Aaa级";
                        }
                        if(value=2){
                            return "Aa级";
                        }
                        if(value=3){
                            return "A级";
                        }
                    }},
					{field:'supAdddate',title:'创建时间', class:'info',width:100,
						formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
							var simfomat = new Date();
						simfomat.setTime(value);   //转换时间
						return  simfomat.toLocaleDateString();
						}},
					{field:'supInfo',title:'器械介绍', class:'info',width:100},
                    {field:'asd',title:'操作', class:'info',width:100,
                        formatter:function(value,row,index){
                            var look = '<button type="button" class="btn btn-primary" onclick="looksupplier('+row.supId+')">查看</button>'+
                                       '<button type="button" class="btn btn-success" onclick="shensupplier('+row.supId+')">审核</button>'
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
								"supCreditlevel":$("#supCreditlevel").val(),
								"supName":$("#supName").val(),
								"supAddress":$("#supAddress").val(),
								"showAdddatemin":$("#minTime").val(),
								"showAdddatemax":$("#maxTime").val(),
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
     </script>
</body>
</html>