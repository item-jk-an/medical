package com.jk.kit.dao;

import com.jk.flow.model.Kit;
import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface KitMapper {

    @Select({
            "<script>",
            "select count(1) from t_kit k , t_brand b WHERE k.kit_brand = b.brand_id ",
            "<if test='kit.kitName != null and kit.kitName != &apos;&apos;'> and k.kit_name LIKE CONCAT('%',#{kit.kitName},'%')</if>",
            "<if test='kit.kitAdddatemin != null and kit.kitAdddatemin != &apos;&apos;'> and k.kit_adddate &gt;=  str_to_date(#{kit.kitAdddatemin},'%Y-%m-%d')</if>",
            "<if test='kit.kitAdddatemax != null and kit.kitAdddatemax != &apos;&apos;'> and k.kit_adddate &lt;=  str_to_date(#{kit.kitAdddatemax},'%Y-%m-%d')</if>",
            "<if test='kit.kitPricemin != null'> and k.kit_price &gt;= #{kit.kitPricemin}</if>",
            "<if test='kit.kitPricemax != null'> and k.kit_price &lt;= #{kit.kitPricemax}</if>",
            "<if test='kit.kitType != null'> and k.kit_type = #{kit.kitType}</if>",
            "</script>"
    })
    long queryKitCount(@Param("kit") Kit kit);

    @Select({
            "<script>",
            "select  *,b.brand_name  AS brandName FROM  t_kit k , t_brand b WHERE k.kit_brand = b.brand_id ",
            "<if test='kit.kitName != null and kit.kitName != &apos;&apos;'> and k.kit_name LIKE CONCAT('%',#{kit.kitName},'%')</if>",
            "<if test='kit.kitAdddatemin != null and kit.kitAdddatemin != &apos;&apos;'> and k.kit_adddate &gt;=  str_to_date(#{kit.kitAdddatemin},'%Y-%m-%d')</if>",
            "<if test='kit.kitAdddatemax != null and kit.kitAdddatemax != &apos;&apos;'> and k.kit_adddate &lt;=  str_to_date(#{kit.kitAdddatemax},'%Y-%m-%d')</if>",
            "<if test='kit.kitPricemin != null'> and k.kit_price &gt;= #{kit.kitPricemin}</if>",
            "<if test='kit.kitPricemax != null'> and k.kit_price &lt;= #{kit.kitPricemax}</if>",
            "<if test='kit.kitType != null'> and k.kit_type = #{kit.kitType}</if>",
            "limit #{start},#{endPos}",
            "</script>"
    })
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
    List<Kit> queryKitAll(@Param("endPos") Integer pageSize, @Param("start") Integer start, @Param("kit") Kit kit);

    @Select("select *,b.brand_name  AS brandName FROM t_kit k , t_brand b WHERE k.kit_brand = b.brand_id and kit_id  = #{id}")
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
    Kit queryKitById(Integer id);

    @Select("select kit_id,kit_name,kit_type,kit_state,kit_brand,kit_adddate,kit_update,kit_shen,kit_showlevel," +
            "kit_hits,kit_grade,kit_price,kit_info,kit_company FROM t_kit")
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
    List<LinkedHashMap<String, Object>> toexcel();
    @Insert({
            "<script>",
            "insert into t_kit ",
            "(kit_name, kit_type, kit_state,kit_brand, kit_info, kit_adddate,",
            "kit_shen, kit_showlevel, kit_grade, kit_price, kit_company)",
            "values",
            "<foreach item='kit' index='index' collection='kitList' separator=','>",
            "(#{kit.kitName}, #{kit.kitType}, #{kit.kitState}, #{kit.kitBrand}, #{kit.kitInfo}, #{kit.kitAdddate},",
            " #{kit.kitShen}, #{kit.kitShowlevel}, #{kit.kitGrade}, #{kit.kitPrice}, #{kit.kitCompany})",
            "</foreach>",
            "</script>"
    })
    void saveUploadExcelFiles(@Param("kitList") List<Kit> kitList);
}