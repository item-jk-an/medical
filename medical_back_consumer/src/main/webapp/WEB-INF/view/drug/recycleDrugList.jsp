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
            <button type="button" class="btn btn-warning">
	            <span class="glyphicon glyphicon-plane" onclick="goback()">返回</span>
            </button>
			<button type="button" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove" onclick="deleteInfo()">删除</span>
			</button>
<table id="drugTable"></table>
	<script type="text/javascript">
   //查询
     $(function (){
 		$("#drugTable").bootstrapTable({
 			 url:"<%=request.getContextPath()%>/drug/queryDrugByState.do",
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
				    {field:'drugPrice',title:'药品价格', class:'info',width:100},
                	{field:'drugHits',title:'药品点击率', class:'info',width:100},
                	{field:'drugGrade',title:'药品积分', class:'info',width:100},
                	{field:'drugCompany',title:'出产公司', class:'info',width:100},
					{field:'drugBrand',title:'药品品牌', class:'info',width:100,
						formatter:function(value,row,index){
							if(value==1){
								return "云南白药";
							}
							if(value=2){
								return "快克";
							}
							if(value=3){
								return "云白山";
							}
						}},
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
                    {field:'drugState',title:'药品状态', class:'info',width:100,
                        formatter:function(value,row,index){
                            if(value==1){
                                return "有销售权";
                            }
                            if(value=2){
                                return "无销售权";
                            }
                        }},
				    {field:'drugShen',title:'审核状态', class:'info',width:100,
                        formatter:function(value,row,index){
                            if(value==1){
                                return "已审核";
                            }
                            if(value=2){
                                return "待审核";
                            }
                        }},
				    {field:'drugShowlevel',title:'展示等级', class:'info',width:100,
                        formatter:function(value,row,index){
                            if(value==1){
                                return "甲等";
                            }
                            if(value=2){
                                return "乙等";
                            }
                            if(value=3){
                                return "优等";
                            }
                        }},

					{field:'drugAdddate',title:'生产时间', class:'info',width:100,
						formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
							var simfomat = new Date();
						simfomat.setTime(value);   //转换时间
						return  simfomat.toLocaleDateString();
						}},
				    {field:'drugUpdate',title:'修改时间', class:'info',width:100,
						formatter:function(value,row,index){//value 当前字段值  row当前行的数据  index当前行
							var simfomat = new Date();
						simfomat.setTime(value);   //转换时间
						return  simfomat.toLocaleDateString();
						}},
					{field:'drugInfo',title:'药品介绍', class:'info',width:100},
					{field:'drugInfo',title:'药品介绍', class:'info',width:100,
                        formatter:function(value,row,index){
                            return  '<input type="button" value="还原" onclick="backDrug('+row.drugId+')">'
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

   //返回页面
   function goback(){
       location.href="<%=request.getContextPath()%>/drug/toshowDrugList.do";
   }
   //还原
   function backDrug(id){
         alert(id)

       $.ajax({
           url:"<%=request.getContextPath()%>/drug/updateDrugByStates.do?drugId="+id,
           success:function(){
               location.href = location
           }
       })
   }

     //删除
     function deleteInfo(){
    	 var ids = "";
    	 if($("[name='cho']:checked").length>0){
    		 for (var i = 0; i < $("[name='cho']:checked").length; i++) {
 				ids +="," + $("[name='cho']:checked").eq(i).val();
 			}
    		ids = ids.substr(1);
    		bootbox.alert(ids)
  			$.ajax({
      		    		url:"<%=request.getContextPath()%>/drug/deleteDrugByids.do?ids="+ids,
      		    		success:function(){
      		    			bootbox.alert('删除成功');
      		    			//刷新
      		    			location.href = location
      		    		}
      		    	})
 		}else{
 			bootbox.alert("至少选择一个");	
 		}
     }
     

	    //供应商列表
	    function queryTrade(){
			 $.ajax({
				 url:"<%=request.getContextPath()%>/drug/queryTradeList.do",	
				 type:"post",
				 async:false,
				success:function (data){
					var typeHtml = '<option value="">--请选择--</option>';
					for (var j = 0; j < data.length; j++) {
						
						typeHtml += '<option value="'+data[j].trade_id+'">'+data[j].trade_name+'</option>';
					}
					
					$("#tradeId").html(typeHtml);
				},
				error:function (){
					alert("系统错误，请使用debug调试 ！！！");
				}
			 })
	    }




     </script>
</body>
</html>