package com.jk.flow.controller;

import com.jk.admin.pojo.Admin;
import com.jk.flow.model.*;
import com.jk.flow.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("flow")
public class FlowController {

	@Autowired
	private FlowService flowService;

	@RequestMapping("toflowList")
	public String toflowList(){

		return "/flow/flow/flowList";
	}

	@RequestMapping("queryFlowList")
	@ResponseBody
	public String queryFlowList(Integer pageSize,Integer start){

		return flowService.queryFlowList(pageSize,start);
	}

	@RequestMapping("tosave")
	public String tosave(){

		return "/flow/flow/save";
	}

	//----------------------------------------------------------------------------------------------
	@RequestMapping("toDrugFlow")
	public String toDrugFlow(){

		return "/flow/drug/drugList";
	}

	//查看药品审核
	@RequestMapping("queryDrugFlow")
	@ResponseBody
	public String queryDrugFlow(Integer pageSize, Integer start, HttpServletRequest request){

		Admin admin = (Admin)request.getSession().getAttribute("sessionUser");
		Integer userId = admin.getAdminId();
		Short shenLv = admin.getAdminLv();
		String value = "";
		if(shenLv == 1) {
			value = flowService.queryDrugFlow1(pageSize, start, userId);
		}
		if(shenLv == 2) {
			value = flowService.queryDrugFlow2(pageSize, start, userId);
		}
		if(shenLv == 3) {
			value = flowService.queryDrugFlow3(pageSize, start, userId);
		}
		return value;
	}

	//审核通过 +1
	@RequestMapping("updateflowDrugShenById")
	@ResponseBody
	public void updateflowDrugShenById(Integer id){

		flowService.updateflowDrugShenById(id);
	}



	//审核不通过
	@RequestMapping("updateflowDrugShenNOById")
	@ResponseBody
	public void updateflowDrugShenNOById(Integer id){

		flowService.updateflowDrugShenNOById(id);
	}


	//查看药品详情
	@RequestMapping("queryDrugFlowById")
	public ModelAndView queryDrugFlowById(Integer drugId){
		ModelAndView mv = new ModelAndView();
		Drug drug = flowService.queryDrugFlowById(drugId);
		mv.addObject("drug",drug);
		mv.setViewName("/flow/drug/lookDrugInfo");
		return mv;
	}


	//--------------------------------------------------------
	//kit开始

	@RequestMapping("toKitFlow")
	public String toKitFlow(){

		return "/flow/kit/kitList";
	}

	//查看kit审核
	@RequestMapping("queryKitFlow")
	@ResponseBody
	public String queryKitFlow(Integer pageSize, Integer start, HttpServletRequest request){

		Admin admin = (Admin)request.getSession().getAttribute("sessionUser");
		Integer userId = admin.getAdminId();
		Short shenLv = admin.getAdminLv();
		String value = "";
		if(shenLv == 1) {
			value = flowService.queryKitFlow1(pageSize, start, userId);
		}
		if(shenLv == 2) {
			value = flowService.queryKitFlow2(pageSize, start, userId);
		}
		if(shenLv == 3) {
			value = flowService.queryKitFlow3(pageSize, start, userId);
		}
		return value;
	}

	//审核通过 +1
	@RequestMapping("updateflowKitShenById")
	@ResponseBody
	public void updateflowKitShenById(Integer id){

		flowService.updateflowKitShenById(id);
	}



	//审核不通过
	@RequestMapping("updateflowKitShenNOById")
	@ResponseBody
	public void updateflowKitShenNOById(Integer id){

		flowService.updateflowKitShenNOById(id);
	}


	//查看kit详情
	@RequestMapping("queryKitFlowById")
	public ModelAndView queryKitFlowById(Integer kitId){
		ModelAndView mv = new ModelAndView();
		Kit kit = flowService.queryKitFlowById(kitId);
		mv.addObject("kit",kit);
		mv.setViewName("/flow/kit/lookKitInfo");
		return mv;
	}

	//---------------------------------------------------------------------------------


	@RequestMapping("toVideoFlow")
	public String toVideoFlow(){

		return "/flow/video/videoList";
	}

	//查看video审核
	@RequestMapping("queryVideoFlow")
	@ResponseBody
	public String queryVideoFlow(Integer pageSize, Integer start, HttpServletRequest request){

		Admin admin = (Admin)request.getSession().getAttribute("sessionUser");
		Integer userId = admin.getAdminId();
		Short shenLv = admin.getAdminLv();
		String value = "";
		if(shenLv == 1) {
			value = flowService.queryVideoFlow1(pageSize, start, userId);
		}
		if(shenLv == 2) {
			value = flowService.queryVideoFlow2(pageSize, start, userId);
		}
		if(shenLv == 3) {
			value = flowService.queryVideoFlow3(pageSize, start, userId);
		}
		return value;
	}

	//审核通过 +1
	@RequestMapping("updateflowVideoShenById")
	@ResponseBody
	public void updateflowVideoShenById(Integer id){

		flowService.updateflowVideoShenById(id);
	}



	//审核不通过
	@RequestMapping("updateflowVideoShenNOById")
	@ResponseBody
	public void updateflowVideoShenNOById(Integer id){

		flowService.updateflowVideoShenNOById(id);
	}


	//查看video详情
	@RequestMapping("queryVideoFlowById")
	public ModelAndView queryVideoFlowById(Integer videoId){
		ModelAndView mv = new ModelAndView();
		Video video = flowService.queryVideoFlowById(videoId);
		mv.addObject("video",video);
		mv.setViewName("/flow/video/lookVideoInfo");
		return mv;
	}

	//----------------------------------------------------------------------------

	@RequestMapping("toInfo1Flow")
	public String toInfo1Flow(){

		return "/flow/info1/info1List";
	}

	//查看info1审核
	@RequestMapping("queryInfo1Flow")
	@ResponseBody
	public String queryInfo1Flow(Integer pageSize, Integer start, HttpServletRequest request){

		Admin admin = (Admin)request.getSession().getAttribute("sessionUser");
		Integer userId = admin.getAdminId();
		Short shenLv = admin.getAdminLv();
		String value = "";
		if(shenLv == 1) {
			value = flowService.queryInfo1Flow1(pageSize, start, userId);
		}
		if(shenLv == 2) {
			value = flowService.queryInfo1Flow2(pageSize, start, userId);
		}
		if(shenLv == 3) {
			value = flowService.queryInfo1Flow3(pageSize, start, userId);
		}
		return value;
	}

	//审核通过 +1
	@RequestMapping("updateflowInfo1ShenById")
	@ResponseBody
	public void updateflowInfo1ShenById(Integer id){

		flowService.updateflowInfo1ShenById(id);
	}



	//审核不通过
	@RequestMapping("updateflowInfo1ShenNOById")
	@ResponseBody
	public void updateflowInfo1ShenNOById(Integer id){

		flowService.updateflowInfo1ShenNOById(id);
	}


	//查看info1详情
	@RequestMapping("queryInfo1FlowById")
	public ModelAndView queryInfo1FlowById(Integer info1Id){
		ModelAndView mv = new ModelAndView();
		Info1 info1 = flowService.queryInfo1FlowById(info1Id);
		mv.addObject("info1",info1);
		mv.setViewName("/flow/info1/lookInfo1Info");
		return mv;
	}

	//----------------------------------------------------------------------------------------------


	@RequestMapping("toInfo2Flow")
	public String toInfo2Flow(){

		return "/flow/info2/info2List";
	}

	//查看info2审核
	@RequestMapping("queryInfo2Flow")
	@ResponseBody
	public String queryInfo2Flow(Integer pageSize, Integer start, HttpServletRequest request){

		Admin admin = (Admin)request.getSession().getAttribute("sessionUser");
		Integer userId = admin.getAdminId();
		Short shenLv = admin.getAdminLv();
		String value = "";
		if(shenLv == 1) {
			value = flowService.queryInfo2Flow1(pageSize, start, userId);
		}
		if(shenLv == 2) {
			value = flowService.queryInfo2Flow2(pageSize, start, userId);
		}
		if(shenLv == 3) {
			value = flowService.queryInfo2Flow3(pageSize, start, userId);
		}
		return value;
	}

	//审核通过 +1
	@RequestMapping("updateflowInfo2ShenById")
	@ResponseBody
	public void updateflowInfo2ShenById(Integer id){

		flowService.updateflowInfo2ShenById(id);
	}



	//审核不通过
	@RequestMapping("updateflowInfo2ShenNOById")
	@ResponseBody
	public void updateflowInfo2ShenNOById(Integer id){

		flowService.updateflowInfo2ShenNOById(id);
	}


	//查看info2详情
	@RequestMapping("queryInfo2FlowById")
	public ModelAndView queryInfo2FlowById(Integer info2Id){
		ModelAndView mv = new ModelAndView();
		Info2 info2 = flowService.queryInfo2FlowById(info2Id);
		mv.addObject("info2",info2);
		mv.setViewName("/flow/info2/lookInfo2Info");
		return mv;
	}

	//---------------------------------------------------------------------------


    @RequestMapping("toSupplierFlow")
    public String toSupplierFlow(){

        return "/flow/supplier/supplierList";
    }

    //查看供应商审核
    @RequestMapping("querySupplierFlow")
    @ResponseBody
    public String querySupplierFlow(Integer pageSize, Integer start, HttpServletRequest request){

		Admin admin = (Admin)request.getSession().getAttribute("sessionUser");
		Integer userId = admin.getAdminId();
		Short shenLv = admin.getAdminLv();
        String value = "";
        if(shenLv == 1) {
            value = flowService.querySupplierFlow1(pageSize, start, userId);
        }
        if(shenLv == 2) {
            value = flowService.querySupplierFlow2(pageSize, start, userId);
        }
        if(shenLv == 3) {
            value = flowService.querySupplierFlow3(pageSize, start, userId);
        }
        return value;
    }

    //审核通过 +1
    @RequestMapping("updateflowSupplierShenById")
    @ResponseBody
    public void updateflowSupplierShenById(Integer id){

		flowService.updateflowSupplierShenById(id);
    }



    //审核不通过
    @RequestMapping("updateflowSupplierShenNOById")
    @ResponseBody
    public void updateflowSupplierShenNOById(Integer id){

		flowService.updateflowSupplierShenNOById(id);
    }


    //查看供应商详情
    @RequestMapping("querySupplierFlowById")
    public ModelAndView querySupplierFlowById(Integer supplierId){
        ModelAndView mv = new ModelAndView();
        Supplier supplier = flowService.querySupplierFlowById(supplierId);
        mv.addObject("supplier",supplier);
        mv.setViewName("/flow/supplier/lookSupplierInfo");
        return mv;
    }




}
