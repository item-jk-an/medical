package com.jk.flow.dao;

import com.jk.flow.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FlowDao {

     @Select("select count(1) from t_flow")
    int queryFlowcount();

     @Select("select * from t_flow limit #{start},#{pageSize}")
     @Results({
             @Result(column="flow_id",property="flowId" ),
             @Result(column="flow_name",property="flowName"),
             @Result(column="role_ids", property="roleIds"),
             @Result(column="user_ids", property="userIds"),
             @Result(column="role_id_1", property="roleId1"),
             @Result(column="role_id_2", property="roleId2"),
             @Result(column="role_id_3" ,property="roleId3"),
             @Result(column="role_id_4", property="roleId4"),
             @Result(column="role_id_5", property="roleId5"),
             @Result(column="user_id_1", property="userId1"),
             @Result(column="user_id_2", property="userId2"),
             @Result(column="user_id_3" ,property="userId3"),
             @Result(column="user_id_4", property="userId4"),
             @Result(column="user_id_5", property="userId5"),
             @Result(column="flow_type", property="flowType"),
     })
     List<Flow> queryFlowlist(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

     //---------------------------------------------------------------------------------------
     //药品开始
    @Select("select count(1) from t_drug where drug_first = #{userId} and drug_shen = 1")
    int queryDrugFlowcount1(Integer userId);

    @Results({
            @Result(column="drug_id",property="drugId" ),
            @Result(column="drug_name", property="drugName"),
            @Result(column="drug_brand", property="drugBrand"),
            @Result(column="drug_adddate" ,property="drugAdddate"),
            @Result(column="drug_update" ,property="drugUpdate"),
            @Result(column="drug_state" ,property="drugState"),
            @Result(column="drug_type", property="drugType"),
            @Result(column="drug_shen" ,property="drugShen"),
            @Result(column="drug_info" ,property="drugInfo"),
            @Result(column="drug_hits" ,property="drugHits"),
            @Result(column="drug_price" ,property="drugPrice"),
            @Result(column="drug_grade" ,property="drugGrade"),
            @Result(column="drug_showlevel" ,property="drugShowlevel"),
            @Result(column="drug_company" ,property="drugCompany"),
    })
    @Select("select * from t_drug where drug_first = #{userId} and drug_shen = 1 limit #{start},#{pageSize}")
    List<Drug> queryDrugFlowlist1(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select * from t_drug where drug_id = #{drugId}")
    @Results({
            @Result(column="drug_id",property="drugId" ),
            @Result(column="drug_name", property="drugName"),
            @Result(column="drug_brand", property="drugBrand"),
            @Result(column="drug_adddate" ,property="drugAdddate"),
            @Result(column="drug_update" ,property="drugUpdate"),
            @Result(column="drug_state" ,property="drugState"),
            @Result(column="drug_type", property="drugType"),
            @Result(column="drug_shen" ,property="drugShen"),
            @Result(column="drug_info" ,property="drugInfo"),
            @Result(column="drug_hits" ,property="drugHits"),
            @Result(column="drug_price" ,property="drugPrice"),
            @Result(column="drug_grade" ,property="drugGrade"),
            @Result(column="drug_showlevel" ,property="drugShowlevel"),
            @Result(column="drug_company" ,property="drugCompany"),
    })
    Drug queryDrugFlowById(Integer drugId);

    @Update("update t_drug set drug_shen = drug_shen + 1 where drug_id = #{id}")
    void updateflowDrugShenById(Integer id);

    @Select("select count(1) from t_drug where drug_second = #{userId} and drug_shen = 2 ")
    int queryDrugFlowcount2(Integer userId);

    @Results({
            @Result(column="drug_id",property="drugId" ),
            @Result(column="drug_name", property="drugName"),
            @Result(column="drug_brand", property="drugBrand"),
            @Result(column="drug_adddate" ,property="drugAdddate"),
            @Result(column="drug_update" ,property="drugUpdate"),
            @Result(column="drug_state" ,property="drugState"),
            @Result(column="drug_type", property="drugType"),
            @Result(column="drug_shen" ,property="drugShen"),
            @Result(column="drug_info" ,property="drugInfo"),
            @Result(column="drug_hits" ,property="drugHits"),
            @Result(column="drug_price" ,property="drugPrice"),
            @Result(column="drug_grade" ,property="drugGrade"),
            @Result(column="drug_showlevel" ,property="drugShowlevel"),
            @Result(column="drug_company" ,property="drugCompany"),
    })
    @Select("select * from t_drug where drug_second = #{userId} and drug_shen = 2 limit #{start},#{pageSize}")
    List<Drug> queryDrugFlowlist2(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_drug where drug_third = #{userId} and drug_shen = 3 ")
    int queryDrugFlowcount3(Integer userId);

    @Results({
            @Result(column="drug_id",property="drugId" ),
            @Result(column="drug_name", property="drugName"),
            @Result(column="drug_brand", property="drugBrand"),
            @Result(column="drug_adddate" ,property="drugAdddate"),
            @Result(column="drug_update" ,property="drugUpdate"),
            @Result(column="drug_state" ,property="drugState"),
            @Result(column="drug_type", property="drugType"),
            @Result(column="drug_shen" ,property="drugShen"),
            @Result(column="drug_info" ,property="drugInfo"),
            @Result(column="drug_hits" ,property="drugHits"),
            @Result(column="drug_price" ,property="drugPrice"),
            @Result(column="drug_grade" ,property="drugGrade"),
            @Result(column="drug_showlevel" ,property="drugShowlevel"),
            @Result(column="drug_company" ,property="drugCompany"),
    })
    @Select("select * from t_drug where drug_third = #{userId} and drug_shen = 3 limit #{start},#{pageSize}")
    List<Drug> queryDrugFlowlist3(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Update("update t_drug set drug_shen = 0 where drug_id = #{id}")
    void updateflowDrugShenNOById(Integer id);

    //kit开始------------------------------------------------

    @Select("select count(1) from t_kit where kit_first = #{userId} and kit_shen = 1")
    int queryKitFlowcount1(Integer userId);

    @Results({
            @Result(column="kit_id" ,property="kitId" ),
            @Result(column="kit_name" ,property="kitName"),
            @Result(column="kit_type" ,property="kitType"),
            @Result(column="kit_state" ,property="kitState"),
            @Result(column="kit_brand" ,property="kitBrand"),
            @Result(column="kit_adddate" ,property="kitAdddate"),
            @Result(column="kit_update" ,property="kitUpdate"),
            @Result(column="kit_shen" ,property="kitShen"),
            @Result(column="kit_showlevel" ,property="kitShowlevel"),
            @Result(column="kit_hits" ,property="kitHits"),
            @Result(column="kit_grade" ,property="kitGrade"),
            @Result(column="kit_price" ,property="kitPrice"),
            @Result(column="kit_info" ,property="kitInfo"),
            @Result(column="kit_company" ,property="kitCompany"),
    })
    @Select("select * from t_kit where kit_first = #{userId} and kit_shen = 1 limit #{start},#{pageSize}")
    List<Kit> queryKitFlowlist1(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select * from t_kit where kit_id = #{kitId}")
    @Results({
            @Result(column="kit_id" ,property="kitId" ),
            @Result(column="kit_name" ,property="kitName"),
            @Result(column="kit_type" ,property="kitType"),
            @Result(column="kit_state" ,property="kitState"),
            @Result(column="kit_brand" ,property="kitBrand"),
            @Result(column="kit_adddate" ,property="kitAdddate"),
            @Result(column="kit_update" ,property="kitUpdate"),
            @Result(column="kit_shen" ,property="kitShen"),
            @Result(column="kit_showlevel" ,property="kitShowlevel"),
            @Result(column="kit_hits" ,property="kitHits"),
            @Result(column="kit_grade" ,property="kitGrade"),
            @Result(column="kit_price" ,property="kitPrice"),
            @Result(column="kit_info" ,property="kitInfo"),
            @Result(column="kit_company" ,property="kitCompany"),
    })
    Kit queryKitFlowById(Integer kitId);

    @Update("update t_kit set kit_shen = kit_shen + 1 where kit_id = #{id}")
    void updateflowKitShenById(Integer id);

    @Select("select count(1) from t_kit where kit_second = #{userId} and kit_shen = 2 ")
    int queryKitFlowcount2(Integer userId);

    @Results({
            @Result(column="kit_id" ,property="kitId" ),
            @Result(column="kit_name" ,property="kitName"),
            @Result(column="kit_type" ,property="kitType"),
            @Result(column="kit_state" ,property="kitState"),
            @Result(column="kit_brand" ,property="kitBrand"),
            @Result(column="kit_adddate" ,property="kitAdddate"),
            @Result(column="kit_update" ,property="kitUpdate"),
            @Result(column="kit_shen" ,property="kitShen"),
            @Result(column="kit_showlevel" ,property="kitShowlevel"),
            @Result(column="kit_hits" ,property="kitHits"),
            @Result(column="kit_grade" ,property="kitGrade"),
            @Result(column="kit_price" ,property="kitPrice"),
            @Result(column="kit_info" ,property="kitInfo"),
            @Result(column="kit_company" ,property="kitCompany"),
    })
    @Select("select * from t_kit where kit_second = #{userId} and kit_shen = 2 limit #{start},#{pageSize}")
    List<Kit> queryKitFlowlist2(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_kit where kit_third = #{userId} and kit_shen = 3 ")
    int queryKitFlowcount3(Integer userId);

    @Results({
            @Result(column="kit_id" ,property="kitId" ),
            @Result(column="kit_name" ,property="kitName"),
            @Result(column="kit_type" ,property="kitType"),
            @Result(column="kit_state" ,property="kitState"),
            @Result(column="kit_brand" ,property="kitBrand"),
            @Result(column="kit_adddate" ,property="kitAdddate"),
            @Result(column="kit_update" ,property="kitUpdate"),
            @Result(column="kit_shen" ,property="kitShen"),
            @Result(column="kit_showlevel" ,property="kitShowlevel"),
            @Result(column="kit_hits" ,property="kitHits"),
            @Result(column="kit_grade" ,property="kitGrade"),
            @Result(column="kit_price" ,property="kitPrice"),
            @Result(column="kit_info" ,property="kitInfo"),
            @Result(column="kit_company" ,property="kitCompany"),
    })
    @Select("select * from t_kit where kit_third = #{userId} and kit_shen = 3 limit #{start},#{pageSize}")
    List<Kit> queryKitFlowlist3(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Update("update t_kit set kit_shen = 0 where kit_id = #{id}")
    void updateflowKitShenNOById(Integer id);

    //------------------------------------------------------

    @Select("select count(1) from t_video_h where video_first = #{userId} and check_status = 1")
    int queryVideoFlowcount1(Integer userId);

    @Results({
            @Result(column="video_id" ,property="videoId" ),
            @Result(column="video_name" ,property="videoName"),
            @Result(column="video_img" ,property="videoImg"),
            @Result(column="video_uuid" ,property="videoUuid"),
            @Result(column="video_score" ,property="videoScore"),
            @Result(column="video_type" ,property="videoType"),
            @Result(column="video_intro" ,property="videoIntro"),
            @Result(column="video_statue" ,property="videoStatue"),
            @Result(column="upload_time" ,property="uploadTime"),
            @Result(column="click_num" ,property="clickNum"),
            @Result(column="check_status" ,property="checkStatus"),
            @Result(column="video_price" ,property="videoPrice"),
            @Result(column="video_info" ,property="videoInfo"),
            @Result(column="video_source" ,property="videoSource"),
    })
    @Select("select * from t_video_h where video_first = #{userId} and check_status = 1 limit #{start},#{pageSize}")
    List<Video> queryVideoFlowlist1(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select * from t_video_h where video_id = #{videoId}")

    @Results({
            @Result(column="video_id" ,property="videoId" ),
            @Result(column="video_name" ,property="videoName"),
            @Result(column="video_img" ,property="videoImg"),
            @Result(column="video_uuid" ,property="videoUuid"),
            @Result(column="video_score" ,property="videoScore"),
            @Result(column="video_type" ,property="videoType"),
            @Result(column="video_intro" ,property="videoIntro"),
            @Result(column="video_statue" ,property="videoStatue"),
            @Result(column="upload_time" ,property="uploadTime"),
            @Result(column="click_num" ,property="clickNum"),
            @Result(column="check_status" ,property="checkStatus"),
            @Result(column="video_price" ,property="videoPrice"),
            @Result(column="video_info" ,property="videoInfo"),
            @Result(column="video_source" ,property="videoSource"),
    })
    Video queryVideoFlowById(Integer videoId);

    @Update("update t_video_h set check_status = check_status + 1 where video_id = #{id}")
    void updateflowVideoShenById(Integer id);

    @Select("select count(1) from t_video_h where video_second = #{userId} and check_status = 2 ")
    int queryVideoFlowcount2(Integer userId);

    @Results({
            @Result(column="video_id" ,property="videoId" ),
            @Result(column="video_name" ,property="videoName"),
            @Result(column="video_img" ,property="videoImg"),
            @Result(column="video_uuid" ,property="videoUuid"),
            @Result(column="video_score" ,property="videoScore"),
            @Result(column="video_type" ,property="videoType"),
            @Result(column="video_intro" ,property="videoIntro"),
            @Result(column="video_statue" ,property="videoStatue"),
            @Result(column="upload_time" ,property="uploadTime"),
            @Result(column="click_num" ,property="clickNum"),
            @Result(column="check_status" ,property="checkStatus"),
            @Result(column="video_price" ,property="videoPrice"),
            @Result(column="video_info" ,property="videoInfo"),
            @Result(column="video_source" ,property="videoSource"),
    })
    @Select("select * from t_video_h where video_second = #{userId} and check_status = 2 limit #{start},#{pageSize}")
    List<Video> queryVideoFlowlist2(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_video_h where video_third = #{userId} and check_status = 3 ")
    int queryVideoFlowcount3(Integer userId);

    @Results({
            @Result(column="video_id" ,property="videoId" ),
            @Result(column="video_name" ,property="videoName"),
            @Result(column="video_img" ,property="videoImg"),
            @Result(column="video_uuid" ,property="videoUuid"),
            @Result(column="video_score" ,property="videoScore"),
            @Result(column="video_type" ,property="videoType"),
            @Result(column="video_intro" ,property="videoIntro"),
            @Result(column="video_statue" ,property="videoStatue"),
            @Result(column="upload_time" ,property="uploadTime"),
            @Result(column="click_num" ,property="clickNum"),
            @Result(column="check_status" ,property="checkStatus"),
            @Result(column="video_price" ,property="videoPrice"),
            @Result(column="video_info" ,property="videoInfo"),
            @Result(column="video_source" ,property="videoSource"),
    })
    @Select("select * from t_video_h where video_third = #{userId} and check_status = 3 limit #{start},#{pageSize}")
    List<Video> queryVideoFlowlist3(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Update("update t_video_h set check_status = 0 where video_id = #{id}")
    void updateflowVideoShenNOById(Integer id);

    //--------------------------------------------------------------


    @Select("select count(1) from t_info_1 where info1_first = #{userId} and check_state = 1")
    int queryInfo1Flowcount1(Integer userId);

    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_sex", property="userSex"),
            @Result(column="user_age" ,property="userAge"),
            @Result(column="user_birth" ,property="userBirth"),
            @Result(column="user_address" ,property="userAddress"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="eduction_card" ,property="eductionCard"),
            @Result(column="body_card" ,property="bodyCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="doctor_card" ,property="doctorCard"),
            @Result(column="medical_result" ,property="medicalResult"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    @Select("select * from t_info_1 where info1_first = #{userId} and check_state = 1 limit #{start},#{pageSize}")
    List<Info1> queryInfo1Flowlist1(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select * from t_info_1 where info_id = #{info1Id}")
    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_sex", property="userSex"),
            @Result(column="user_age" ,property="userAge"),
            @Result(column="user_birth" ,property="userBirth"),
            @Result(column="user_address" ,property="userAddress"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="eduction_card" ,property="eductionCard"),
            @Result(column="body_card" ,property="bodyCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="doctor_card" ,property="doctorCard"),
            @Result(column="medical_result" ,property="medicalResult"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    Info1 queryInfo1FlowById(Integer info1Id);

    @Update("update t_info_1 set check_state = check_state + 1 where info_id = #{id}")
    void updateflowInfo1ShenById(Integer id);

    @Select("select count(1) from t_info_1 where info1_second = #{userId} and check_state = 2 ")
    int queryInfo1Flowcount2(Integer userId);

    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_sex", property="userSex"),
            @Result(column="user_age" ,property="userAge"),
            @Result(column="user_birth" ,property="userBirth"),
            @Result(column="user_address" ,property="userAddress"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="eduction_card" ,property="eductionCard"),
            @Result(column="body_card" ,property="bodyCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="doctor_card" ,property="doctorCard"),
            @Result(column="medical_result" ,property="medicalResult"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    @Select("select * from t_info_1 where info1_second = #{userId} and check_state = 2 limit #{start},#{pageSize}")
    List<Info1> queryInfo1Flowlist2(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_info_1 where info1_third = #{userId} and check_state = 3 ")
    int queryInfo1Flowcount3(Integer userId);

    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_sex", property="userSex"),
            @Result(column="user_age" ,property="userAge"),
            @Result(column="user_birth" ,property="userBirth"),
            @Result(column="user_address" ,property="userAddress"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="eduction_card" ,property="eductionCard"),
            @Result(column="body_card" ,property="bodyCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="doctor_card" ,property="doctorCard"),
            @Result(column="medical_result" ,property="medicalResult"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    @Select("select * from t_info_1 where info1_third = #{userId} and check_state = 3 limit #{start},#{pageSize}")
    List<Info1> queryInfo1Flowlist3(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Update("update t_info_1 set check_state = 0 where info_id = #{id}")
    void updateflowInfo1ShenNOById(Integer id);

    //-----------------------------------------------------------------

    @Select("select count(1) from t_info_2 where info2_first = #{userId} and check_state = 1")
    int queryInfo2Flowcount1(Integer userId);

    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_address", property="userAddress"),
            @Result(column="user_logo" ,property="userLogo"),
            @Result(column="user_email" ,property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="study_direction" ,property="studyDirection"),
            @Result(column="net_url" ,property="netUrl"),
            @Result(column="user_struture" ,property="userStruture"),
            @Result(column="user_type" ,property="userType"),
            @Result(column="user_level" ,property="userLevel"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    @Select("select * from t_info_2 where info2_first = #{userId} and check_state = 1 limit #{start},#{pageSize}")
    List<Info2> queryInfo2Flowlist1(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select * from t_info_2 where info_id = #{info2Id}")
    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_address", property="userAddress"),
            @Result(column="user_logo" ,property="userLogo"),
            @Result(column="user_email" ,property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="study_direction" ,property="studyDirection"),
            @Result(column="net_url" ,property="netUrl"),
            @Result(column="user_struture" ,property="userStruture"),
            @Result(column="user_type" ,property="userType"),
            @Result(column="user_level" ,property="userLevel"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    Info2 queryInfo2FlowById(Integer info2Id);

    @Update("update t_info_2 set check_state = check_state + 1 where info_id = #{id}")
    void updateflowInfo2ShenById(Integer id);

    @Select("select count(1) from t_info_2 where info2_second = #{userId} and check_state = 2 ")
    int queryInfo2Flowcount2(Integer userId);

    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_address", property="userAddress"),
            @Result(column="user_logo" ,property="userLogo"),
            @Result(column="user_email" ,property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="study_direction" ,property="studyDirection"),
            @Result(column="net_url" ,property="netUrl"),
            @Result(column="user_struture" ,property="userStruture"),
            @Result(column="user_type" ,property="userType"),
            @Result(column="user_level" ,property="userLevel"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    @Select("select * from t_info_2 where info2_second = #{userId} and check_state = 2 limit #{start},#{pageSize}")
    List<Info2> queryInfo2Flowlist2(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_info_2 where info2_third = #{userId} and check_state = 3 ")
    int queryInfo2Flowcount3(Integer userId);

    @Results({
            @Result(column="info_id",property="infoId" ),
            @Result(column="user_name", property="userName"),
            @Result(column="user_address", property="userAddress"),
            @Result(column="user_logo" ,property="userLogo"),
            @Result(column="user_email" ,property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="user_email", property="userEmail"),
            @Result(column="user_intro" ,property="userIntro"),
            @Result(column="study_direction" ,property="studyDirection"),
            @Result(column="net_url" ,property="netUrl"),
            @Result(column="user_struture" ,property="userStruture"),
            @Result(column="user_type" ,property="userType"),
            @Result(column="user_level" ,property="userLevel"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="status_card" ,property="statusCard"),
            @Result(column="promise_book" ,property="promiseBook"),
            @Result(column="check_state" ,property="checkState"),
    })
    @Select("select * from t_info_2 where info2_third = #{userId} and check_state = 3 limit #{start},#{pageSize}")
    List<Info2> queryInfo2Flowlist3(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Update("update t_info_2 set check_state = 0 where info_id = #{id}")
    void updateflowInfo2ShenNOById(Integer id);

    //---------------------------------------------------------------------------------------------------------

    @Update("update t_supplier_l set check_status = check_status + 1 where login_id = #{id}")
    void updateflowSupplierShenById(Integer id);

    @Update("update t_supplier_l set check_status = 0 where login_id = #{id}")
    void updateflowSupplierShenNOById(Integer id);

    @Select("select count(1) from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.supplier_first = #{userId} and b.check_status = 1")
    int querySupplierFlowcount1(Integer userId);

    @Results({
            @Result(column="sup_id", property="supId" ),
            @Result(column="sup_name", property="supName"),
            @Result(column="sup_phone", property="supPhone"),
            @Result(column="sup_address", property="supAddress"),
            @Result(column="sup_creditlevel", property="supCreditlevel"),
            @Result(column="sup_info", property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update", property="supUpdate"),
            @Result(column="sup_linkman", property="supLinkman"),
            @Result(column="sup_type", property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="login_id", property="loginId"),
            @Result(column="supplier_phone", property="supplierPhone"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="promis_book" ,property="promisBook"),
            @Result(column="check_status", property="checkStatus"),
            @Result(column="body_card", property="bodyCard"),
            @Result(column="supplier_intro" ,property="supplierIntro"),
            @Result(column="supplier_id", property="supplierId"),
            @Result(column="login_account", property="loginAccount"),
            @Result(column="supplier_first" ,property="supplierFirst"),
            @Result(column="supplier_second", property="supplierSecond"),
            @Result(column="supplier_third", property="supplierThird"),
    })
    @Select("select * from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.supplier_first = #{userId} and b.check_status = 1 limit #{start},#{pageSize}")
    List<Supplier> querySupplierFlowlist1(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.supplier_second = #{userId} and b.check_status = 2")
    int querySupplierFlowcount2(Integer userId);

    @Results({
            @Result(column="sup_id", property="supId" ),
            @Result(column="sup_name", property="supName"),
            @Result(column="sup_phone", property="supPhone"),
            @Result(column="sup_address", property="supAddress"),
            @Result(column="sup_creditlevel", property="supCreditlevel"),
            @Result(column="sup_info", property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update", property="supUpdate"),
            @Result(column="sup_linkman", property="supLinkman"),
            @Result(column="sup_type", property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="login_id", property="loginId"),
            @Result(column="supplier_phone", property="supplierPhone"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="promis_book" ,property="promisBook"),
            @Result(column="check_status", property="checkStatus"),
            @Result(column="body_card", property="bodyCard"),
            @Result(column="supplier_intro" ,property="supplierIntro"),
            @Result(column="supplier_id", property="supplierId"),
            @Result(column="login_account", property="loginAccount"),
            @Result(column="supplier_first" ,property="supplierFirst"),
            @Result(column="supplier_second", property="supplierSecond"),
            @Result(column="supplier_third", property="supplierThird"),
    })
    @Select("select * from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.supplier_second = #{userId} and b.check_status = 2 limit #{start},#{pageSize}")
    List<Supplier> querySupplierFlowlist2(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Select("select count(1) from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.supplier_third = #{userId} and b.check_status = 3")
    int querySupplierFlowcount3(Integer userId);

    @Results({
            @Result(column="sup_id", property="supId" ),
            @Result(column="sup_name", property="supName"),
            @Result(column="sup_phone", property="supPhone"),
            @Result(column="sup_address", property="supAddress"),
            @Result(column="sup_creditlevel", property="supCreditlevel"),
            @Result(column="sup_info", property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update", property="supUpdate"),
            @Result(column="sup_linkman", property="supLinkman"),
            @Result(column="sup_type", property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="login_id", property="loginId"),
            @Result(column="supplier_phone", property="supplierPhone"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="promis_book" ,property="promisBook"),
            @Result(column="check_status", property="checkStatus"),
            @Result(column="body_card", property="bodyCard"),
            @Result(column="supplier_intro" ,property="supplierIntro"),
            @Result(column="supplier_id", property="supplierId"),
            @Result(column="login_account", property="loginAccount"),
            @Result(column="supplier_first" ,property="supplierFirst"),
            @Result(column="supplier_second", property="supplierSecond"),
            @Result(column="supplier_third", property="supplierThird"),
    })
    @Select("select * from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.supplier_third = #{userId} and b.check_status = 3 limit #{start},#{pageSize}")
    List<Supplier> querySupplierFlowlist3(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("userId") Integer userId);

    @Results({
            @Result(column="sup_id", property="supId" ),
            @Result(column="sup_name", property="supName"),
            @Result(column="sup_phone", property="supPhone"),
            @Result(column="sup_address", property="supAddress"),
            @Result(column="sup_creditlevel", property="supCreditlevel"),
            @Result(column="sup_info", property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update", property="supUpdate"),
            @Result(column="sup_linkman", property="supLinkman"),
            @Result(column="sup_type", property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="login_id", property="loginId"),
            @Result(column="supplier_phone", property="supplierPhone"),
            @Result(column="business_card" ,property="businessCard"),
            @Result(column="promis_book" ,property="promisBook"),
            @Result(column="check_status", property="checkStatus"),
            @Result(column="body_card", property="bodyCard"),
            @Result(column="supplier_intro" ,property="supplierIntro"),
            @Result(column="supplier_id", property="supplierId"),
            @Result(column="login_account", property="loginAccount"),
            @Result(column="supplier_first" ,property="supplierFirst"),
            @Result(column="supplier_second", property="supplierSecond"),
            @Result(column="supplier_third", property="supplierThird"),
    })
    @Select("select * from t_supplier a,t_supplier_l b where b.supplier_id = a.sup_id and b.login_id = #{supplierId}")
    Supplier querySupplierFlowById(Integer supplierId);
}
