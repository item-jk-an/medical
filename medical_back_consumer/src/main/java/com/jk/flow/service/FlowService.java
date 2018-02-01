package com.jk.flow.service;

import com.jk.flow.model.*;

public interface FlowService {


    String queryFlowList(Integer pageSize, Integer start);

    //------------------------------------------------------------------------------

    String queryDrugFlow1(Integer pageSize, Integer start, Integer userId);

    String queryDrugFlow2(Integer pageSize, Integer start, Integer userId);

    String queryDrugFlow3(Integer pageSize, Integer start, Integer userId);

    Drug queryDrugFlowById(Integer drugId);

    void updateflowDrugShenById(Integer id);

    void updateflowDrugShenNOById(Integer id);

    /////////////////

    String queryKitFlow1(Integer pageSize, Integer start, Integer userId);

    String queryKitFlow2(Integer pageSize, Integer start, Integer userId);

    String queryKitFlow3(Integer pageSize, Integer start, Integer userId);

    void updateflowKitShenById(Integer id);

    void updateflowKitShenNOById(Integer id);

    Kit queryKitFlowById(Integer kitId);

    //------------------------------------------------------------------------------------

    String queryVideoFlow1(Integer pageSize, Integer start, Integer userId);

    String queryVideoFlow2(Integer pageSize, Integer start, Integer userId);

    String queryVideoFlow3(Integer pageSize, Integer start, Integer userId);

    void updateflowVideoShenById(Integer id);

    void updateflowVideoShenNOById(Integer id);

    Video queryVideoFlowById(Integer videoId);

    //--------------------------------------------


    String queryInfo1Flow1(Integer pageSize, Integer start, Integer userId);

    String queryInfo1Flow2(Integer pageSize, Integer start, Integer userId);

    String queryInfo1Flow3(Integer pageSize, Integer start, Integer userId);

    void updateflowInfo1ShenById(Integer id);

    void updateflowInfo1ShenNOById(Integer id);

    Info1 queryInfo1FlowById(Integer Info1Id);

    //------------------------------------------------------

    String queryInfo2Flow1(Integer pageSize, Integer start, Integer userId);

    String queryInfo2Flow2(Integer pageSize, Integer start, Integer userId);

    String queryInfo2Flow3(Integer pageSize, Integer start, Integer userId);

    void updateflowInfo2ShenById(Integer id);

    void updateflowInfo2ShenNOById(Integer id);

    Info2 queryInfo2FlowById(Integer Info2Id);

    //-----------------------------------------------------------------

    String querySupplierFlow1(Integer pageSize, Integer start, Integer userId);

    String querySupplierFlow2(Integer pageSize, Integer start, Integer userId);

    String querySupplierFlow3(Integer pageSize, Integer start, Integer userId);

    void updateflowSupplierShenById(Integer id);

    void updateflowSupplierShenNOById(Integer id);

    Supplier querySupplierFlowById(Integer supplierId);


}
