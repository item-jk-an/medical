<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/mystyle.jsp" %>

<form id="drugForm">
	<input type="hidden"   name="supId"  value="${supplier.supId}">
	<div class="form-group">
		<label>供应商名称：</label>
		<label>${supplier.supName}</label>
	</div>
	<div class="form-group">
		<label>联系人：</label>
		<label>${supplier.supLinkman}</label>
	</div>
	<div class="form-group">
		<label>供应商电话：</label>
		<label>${supplier.supPhone}</label>
	</div>
	<div class="form-group">
		<label>供应商地址：</label>
		<label>${supplier.supAddress}</label>
	</div>
	<div class="form-group">
		<label>代理的品牌：</label>
		<label>${supplier.brandName}</label>
	</div>
	<div class="form-group">
		<label>供应商类型：</label>
		<label>${supplier.supType==1?"私家企业":"国有企业"}</label>
	</div>
	<div class="form-group">
		<label>审核状态：</label>
		<label>${supplier.supCheckstate==1? '已审核':'待审核'}</label>
	</div>
	<div class="form-group">
		<label>信誉等级：</label>
		<label>
			${supplier.supCreditlevel==1?"Aaa级":""}
			${supplier.supCreditlevel==2?"Aa级":""}
			${supplier.supCreditlevel==3?"A级":""}
		</label>
	</div>
	<div class="form-group">
		<label>添加时间：</label>
		<label>${supplier.showAdddate}</label>
	</div>
	<div class="form-group">
		<label>修改时间：</label>
		<label>${supplier.showupdate}</label>
	</div>
	<div class="form-group">
		<label>经营范围：</label>
		<label>	${supplier.supFrame}</label>
	</div>
	<div class="form-group">
		<label>供应商介绍：</label>
		<label>${supplier.supInfo}</label>
	</div>
	<div class="form-group">
		<label>供应商点击量：</label>
		<label>${supplier.supKits}</label>
	</div>
</form>