package com.jk.flow.service;

import com.alibaba.fastjson.JSONObject;
import com.jk.flow.dao.FlowDao;
import com.jk.flow.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("flowService")
public class FlowServiceImpl implements FlowService {

	@Autowired
	private FlowDao flowDao;


	@Override
	public String queryFlowList(Integer pageSize, Integer start) {
		int count = flowDao.queryFlowcount();
		List<Flow> list = flowDao.queryFlowlist(start,pageSize);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	//------------------------------------------------------------------------------------------
	@Override
	public String queryDrugFlow1(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryDrugFlowcount1(userId);
		List<Drug> list = flowDao.queryDrugFlowlist1(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryDrugFlow2(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryDrugFlowcount2(userId);
		List<Drug> list = flowDao.queryDrugFlowlist2(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryDrugFlow3(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryDrugFlowcount3(userId);
		List<Drug> list = flowDao.queryDrugFlowlist3(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public Drug queryDrugFlowById(Integer drugId) {
		return flowDao.queryDrugFlowById(drugId);
	}

	@Override
	public void updateflowDrugShenById(Integer id) {
		flowDao.updateflowDrugShenById(id);
	}

	@Override
	public void updateflowDrugShenNOById(Integer id) {
		flowDao.updateflowDrugShenNOById(id);
	}

	//---------------------------------------------------------------------------------------------------------

	@Override
	public String queryKitFlow1(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryKitFlowcount1(userId);
		List<Kit> list = flowDao.queryKitFlowlist1(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryKitFlow2(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryKitFlowcount2(userId);
		List<Kit> list = flowDao.queryKitFlowlist2(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryKitFlow3(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryKitFlowcount3(userId);
		List<Kit> list = flowDao.queryKitFlowlist3(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public Kit queryKitFlowById(Integer kitId) {
		return flowDao.queryKitFlowById(kitId);
	}

	@Override
	public void updateflowKitShenById(Integer id) {
		flowDao.updateflowKitShenById(id);
	}

	@Override
	public void updateflowKitShenNOById(Integer id) {
		flowDao.updateflowKitShenNOById(id);
	}

	//----------------------------------------------------------

	@Override
	public String queryVideoFlow1(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryVideoFlowcount1(userId);
		List<Video> list = flowDao.queryVideoFlowlist1(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryVideoFlow2(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryVideoFlowcount2(userId);
		List<Video> list = flowDao.queryVideoFlowlist2(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryVideoFlow3(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryVideoFlowcount3(userId);
		List<Video> list = flowDao.queryVideoFlowlist3(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public Video queryVideoFlowById(Integer videoId) {
		return flowDao.queryVideoFlowById(videoId);
	}

	@Override
	public void updateflowVideoShenById(Integer id) {
		flowDao.updateflowVideoShenById(id);
	}

	@Override
	public void updateflowVideoShenNOById(Integer id) {
		flowDao.updateflowVideoShenNOById(id);
	}

	//---------------------------------------------------------------------------------

	@Override
	public String queryInfo1Flow1(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryInfo1Flowcount1(userId);
		List<Info1> list = flowDao.queryInfo1Flowlist1(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryInfo1Flow2(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryInfo1Flowcount2(userId);
		List<Info1> list = flowDao.queryInfo1Flowlist2(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryInfo1Flow3(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryInfo1Flowcount3(userId);
		List<Info1> list = flowDao.queryInfo1Flowlist3(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public Info1 queryInfo1FlowById(Integer Info1Id) {
		return flowDao.queryInfo1FlowById(Info1Id);
	}

	@Override
	public void updateflowInfo1ShenById(Integer id) {
		flowDao.updateflowInfo1ShenById(id);
	}

	@Override
	public void updateflowInfo1ShenNOById(Integer id) {
		flowDao.updateflowInfo1ShenNOById(id);
	}

	//-------------------------------------------------------------------------------

	@Override
	public String queryInfo2Flow1(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryInfo2Flowcount1(userId);
		List<Info2> list = flowDao.queryInfo2Flowlist1(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryInfo2Flow2(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryInfo2Flowcount2(userId);
		List<Info2> list = flowDao.queryInfo2Flowlist2(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String queryInfo2Flow3(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.queryInfo2Flowcount3(userId);
		List<Info2> list = flowDao.queryInfo2Flowlist3(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public Info2 queryInfo2FlowById(Integer Info2Id) {
		return flowDao.queryInfo2FlowById(Info2Id);
	}

	@Override
	public void updateflowInfo2ShenById(Integer id) {
		flowDao.updateflowInfo2ShenById(id);
	}

	@Override
	public void updateflowInfo2ShenNOById(Integer id) {
		flowDao.updateflowInfo2ShenNOById(id);
	}

	//----------------------------------------------------------------------------------------



	//------------------------------------------------------------------------------------------
	@Override
	public String querySupplierFlow1(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.querySupplierFlowcount1(userId);
		List<Supplier> list = flowDao.querySupplierFlowlist1(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String querySupplierFlow2(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.querySupplierFlowcount2(userId);
		List<Supplier> list = flowDao.querySupplierFlowlist2(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public String querySupplierFlow3(Integer pageSize, Integer start ,Integer userId) {
		int count = flowDao.querySupplierFlowcount3(userId);
		List<Supplier> list = flowDao.querySupplierFlowlist3(start,pageSize,userId);
		JSONObject json=new JSONObject();
		json.put("total", count);
		json.put("rows", list);

		return json.toString();
	}

	@Override
	public Supplier querySupplierFlowById(Integer supplierId) {
		return flowDao.querySupplierFlowById(supplierId);
	}

	@Override
	public void updateflowSupplierShenById(Integer id) {
		flowDao.updateflowSupplierShenById(id);
	}

	@Override
	public void updateflowSupplierShenNOById(Integer id) {
		flowDao.updateflowSupplierShenNOById(id);
	}
}
