<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/common/mystyle.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form id="drugForm">
	<input type="hidden"   name="drugId"  value="${drug.drugId}">
	<div class="form-group">
		<label>药品名称</label>
		<input type="text" class="form-control" value="${drug.drugName}"  name="drugName"  id="drugName" placeholder="药品名称">
	</div>
	<div class="form-group">
		<label>药品价格</label>
		<input type="number" name="drugPrice" value="${drug.drugPrice}" class="form-control" placeholder="药品价格" />
	</div>
	<div class="form-group">
		<label>药品品牌</label>
		<select  name="drugBrand" id="drugBrand" class="form-control">
			<option value="">请选择</option>
			<option value="1" ${drug.drugBrand==1?"selected":""}>云南白药</option>
			<option value="2" ${drug.drugBrand==2?"selected":""}>快克</option>
			<option value="3" ${drug.drugBrand==3?"selected":""}>云白山</option>
		</select>
	</div>
	<div class="form-group">
		<label>药品类型</label>
		<select  name="drugType" id="drugType" class="form-control">
			<option value="">请选择</option>
			<option value="1" ${drug.drugType==1?"selected":""}>中药</option>
			<option value="2" ${drug.drugType==2?"selected":""}>西药</option>
			<option value="3" ${drug.drugType==3?"selected":""}>草药</option>
		</select>
	</div>
	<div class="form-group">
		<label>出产公司</label>
		<input type="text" class="form-control" value="${drug.drugCompany}"  name="drugCompany"  id="drugCompany" placeholder="出产公司">
	</div>
	<div class="form-group">
		<label>药品介绍</label>
		<textarea class="form-control"   name="drugInfo" cols="10" rows="10">${drug.drugInfo}</textarea>
	</div>
</form>