package com.jk.drug.dao;

import com.jk.flow.model.Drug;
import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;
@Mapper
public interface DrugMapper {

    @Select({
            "<script>",
            "select count(1) from t_drug d ,t_brand b WHERE d.drug_brand = b.brand_id ",
            "<if test='drug.drugName != null and drug.drugName != &apos;&apos;'> and d.drug_name LIKE CONCAT('%',#{drug.drugName},'%')</if>",
            "<if test='drug.drugAdddatemin != null and drug.drugAdddatemin != &apos;&apos;'> and d.drug_adddate &gt;=  str_to_date(#{drug.drugAdddatemin},'%Y-%m-%d')</if>",
            "<if test='drug.drugAdddatemax != null and drug.drugAdddatemax != &apos;&apos;'> and d.drug_adddate &lt;=  str_to_date(#{drug.drugAdddatemax},'%Y-%m-%d')</if>",
            "<if test='drug.drugPricemin != null'> and d.drug_price &gt;= #{drug.drugPricemin}</if>",
            "<if test='drug.drugPricemax != null'> and d.drug_price &lt;= #{drug.drugPricemax}</if>",
            "<if test='drug.drugType != null'> and d.drug_type = #{drug.drugType}</if>",
            "</script>"
    })
    long queryCount(@Param("drug") Drug drug);

    @Select({
            "<script>",
            "select *,b.brand_name as brandName from t_drug d ,t_brand b WHERE d.drug_brand = b.brand_id ",
            "<if test='drug.drugName != null and drug.drugName != &apos;&apos;'> and d.drug_name LIKE CONCAT('%',#{drug.drugName},'%')</if>",
            "<if test='drug.drugAdddatemin != null and drug.drugAdddatemin != &apos;&apos;'> and d.drug_adddate &gt;=  str_to_date(#{drug.drugAdddatemin},'%Y-%m-%d')</if>",
            "<if test='drug.drugAdddatemax != null and drug.drugAdddatemax != &apos;&apos;'> and d.drug_adddate &lt;= str_to_date(#{drug.drugAdddatemax},'%Y-%m-%d')</if>",
            "<if test='drug.drugPricemin != null'> and d.drug_price &gt;= #{drug.drugPricemin}</if>",
            "<if test='drug.drugPricemax != null'> and d.drug_price &lt;= #{drug.drugPricemax}</if>",
            "<if test='drug.drugType != null'> and d.drug_type = #{drug.drugType}</if>",
            "limit #{start},#{endPos}",
            "</script>"
    })
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
    List<Drug> queryDrugAll(@Param("endPos") Integer pageSize, @Param("start") Integer start, @Param("drug") Drug drug);

    @Select("select *,b.brand_name AS brandName FROM t_drug d ,t_brand b WHERE d.drug_brand = b.brand_id AND d.drug_id = #{drugId}")
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
    Drug drugDialog(Integer drugId);

    @Update("update t_drug\n" +
            "      set drug_name = #{drugName},\n" +
            "      drug_brand = #{drugBrand},\n" +
            "      drug_type = #{drugType},\n" +
            "      drug_info = #{drugInfo},\n" +
            "      drug_price = #{drugPrice},\n" +
            "      drug_company = #{drugCompany},\n" +
            "      drug_update = #{drugUpdate} \n"+
            "      where drug_id = #{drugId}")
    void updateDrugInfo(Drug drug);

    @Insert("insert into t_drug (drug_name, drug_brand, drug_type, \n" +
            "       drug_info,drug_price, drug_company,drug_adddate)\n" +
            "    values (#{drugName}, #{drugBrand}, #{drugType}, \n" +
            "     #{drugInfo},#{drugPrice}, #{drugCompany},#{drugAdddate})")
    void saveDrugInfo(Drug drug);

    @Select("select count(1) from t_drug where drug_state = 2")
    long queryDrugByStateCount(@Param("drug") Drug drug);

    @Select("select * from t_drug where drug_state = 2 limit #{start},#{endPos}")
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
    List<Drug> queryDrugByState(@Param("endPos") Integer pageSize, @Param("start") Integer start, @Param("drug") Drug drug);

    @Delete({
            "<script>",
            "delete from t_drug",
            "<where>",
            "drug_id in",
            "<foreach item='item' index='index' collection='idslist' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</where>",
            "</script>"
    })
    void deleteDrugByids(@Param("idslist") List<Integer> idslist);

    @Update("update t_drug set drug_state = 2 where drug_id = #{drugId}")
    void updateDrugByState(Drug drug);
    @Update("update t_drug set drug_state = 1 where drug_id = #{drugId}")
    void updateDrugByStates(Drug drug);


    @Select("select drug_id, drug_name, drug_brand, drug_adddate, drug_update, drug_state, drug_type, drug_shen, " +
            "drug_info, drug_hits, drug_price, drug_grade, drug_showlevel, drug_company  from t_drug")
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
    List<LinkedHashMap<String,Object>> toexcel();

    @Insert({
            "<script>",
            "insert into t_drug ",
            "(drug_name, drug_brand, drug_adddate, drug_state, drug_type,",
            "drug_shen, drug_info, drug_price, drug_grade, drug_showlevel, drug_company)",
            "values",
            "<foreach item='drug' index='index' collection='drugList' separator=','>",
            "(#{drug.drugName}, #{drug.drugBrand}, #{drug.drugAdddate}, #{drug.drugState}, #{drug.drugType},",
            " #{drug.drugShen}, #{drug.drugInfo}, #{drug.drugPrice}, #{drug.drugGrade}, #{drug.drugShowlevel}, #{drug.drugCompany})",
            "</foreach>",
            "</script>"
    })
    void saveUploadExcelFiles(@Param("drugList") List<Drug> drugList);
}