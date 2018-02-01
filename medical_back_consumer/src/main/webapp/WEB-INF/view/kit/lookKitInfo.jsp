<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/mystyle.jsp" %>

<form id="drugForm">
	<input type="hidden"   name="kitId"  value="${kit.kitId}">
	<div class="form-group">
		<label>器械名称：</label>
		<label>${kit.kitName}</label>
	</div>
	<div class="form-group">
		<label>器械价格：</label>
		<label>${kit.kitPrice}</label>
	</div>
	<div class="form-group">
		<label>器械积分：</label>
		<label>${kit.kitGrade}</label>
	</div>
	<div class="form-group">
		<label>器械品牌：</label>
		<label>${kit.brandName}</label>
	</div>
	<div class="form-group">
		<label>器械类型：</label>
		<label>
			${kit.kitType==1?"基础外科手术器械":""}
			${kit.kitType==2?"显微外科手术器械":""}
			${kit.kitType==3?"神经外科手术器械":""}
		</label>
	</div>
	<div class="form-group">
		<label>器械状态：</label>
		<label>${kit.kitState==1? '有销售权':'无销售权'}</label>
	</div>
	<div class="form-group">
		<label>审核状态：</label>
		<label>${kit.kitShen==1? '已审核':'待审核'}</label>
	</div>
	<div class="form-group">
		<label>展示等级：</label>
		<label>
			${kit.kitShowlevel==1?"甲等":""}
			${kit.kitShowlevel==2?"乙等":""}
			${kit.kitShowlevel==3?"优等":""}
		</label>
	</div>
	<div class="form-group">
		<label>出产公司：</label>
	    <label>${kit.kitCompany}</label>
	</div>
	<div class="form-group">
		<label>添加时间：</label>
		<label>${kit.showAdddate}</label>
	</div>
	<div class="form-group">
		<label>修改时间：</label>
		<label>${kit.showupdate}</label>
	</div>
	<div class="form-group">
		<label>器械介绍：</label>
		<label>${kit.kitInfo}</label>
	</div>
	<div class="form-group">
		<label>器械点击量：</label>
		<label>${kit.kitHits}</label>
	</div>

</form>