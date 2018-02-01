<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/mystyle.jsp" %>

<form id="drugForm">
	<input type="hidden"   name="drugId"  value="${drug.drugId}">
	<div class="form-group">
		<label>药品名称：</label>
		<label>${drug.drugName}</label>
	</div>
	<div class="form-group">
		<label>药品价格：</label>
		<label>${drug.drugPrice}</label>
	</div>
	<div class="form-group">
		<label>药品积分：</label>
		<label>${drug.drugGrade}</label>
	</div>
	<div class="form-group">
		<label>药品品牌：</label>
		<label>${drug.brandName}</label>
	</div>
	<div class="form-group">
		<label>药品类型：</label>
		<label>
			${drug.drugType==1?"中药":""}
			${drug.drugType==2?"西药":""}
			${drug.drugType==3?"草药":""}
		</label>
	</div>
	<div class="form-group">
		<label>药品状态：</label>
		<label>${drug.drugState==1? '有销售权':'无销售权'}</label>
	</div>
	<div class="form-group">
		<label>审核状态：</label>
		<label>${drug.drugShen==1? '已审核':'待审核'}</label>
	</div>
	<div class="form-group">
		<label>展示等级：</label>
		<label>
			${drug.drugShowlevel==1?"甲等":""}
			${drug.drugShowlevel==2?"乙等":""}
			${drug.drugShowlevel==3?"优等":""}
		</label>
	</div>
	<div class="form-group">
		<label>出产公司：</label>
	    <label>${drug.drugCompany}</label>
	</div>
	<div class="form-group">
		<label>添加时间：</label>
		<label>${drug.showAdddate}</label>
	</div>
	<div class="form-group">
		<label>修改时间：</label>
		<label>${drug.showupdate}</label>
	</div>
	<div class="form-group">
		<label>药品介绍：</label>
		<label>${drug.drugInfo}</label>
	</div>
	<div class="form-group">
		<label>药品点击量：</label>
		<label>${drug.drugHits}</label>
	</div>

</form>