package com.jk.supplier.dao;

import com.jk.supplier.pojo.Supplier;
import org.apache.ibatis.annotations.*;

import java.util.LinkedHashMap;
import java.util.List;
@Mapper
public interface SupplierMapper {
    @Select({
            "<script>",
            "select count(1) from t_supplier u ,t_brand b WHERE u.sup_brand  = b.brand_id ",
            "<if test='supplier.supName != null and supplier.supName != &apos;&apos;'> and u.sup_name LIKE CONCAT('%',#{supplier.supName},'%')</if>",
            "<if test='supplier.supAddress != null and supplier.supAddress != &apos;&apos;'> and u.sup_address LIKE CONCAT('%',#{supplier.supAddress},'%')</if>",
            "<if test='supplier.supAdddatemin != null and supplier.supAdddatemin != &apos;&apos;'> and u.sup_adddate &gt;=  str_to_date(#{supplier.supAdddatemin},'%Y-%m-%d')</if>",
            "<if test='supplier.supAdddatemax != null and supplier.supAdddatemax != &apos;&apos;'> and u.sup_adddate &lt;=  str_to_date(#{supplier.supAdddatemax},'%Y-%m-%d')</if>",
            "<if test='supplier.supCreditlevel != null'> and u.sup_creditlevel = #{supplier.supCreditlevel}</if>",
            "</script>"
    })
    long querySupplierCount(@Param("supplier") Supplier supplier);

    @Select({
            "<script>",
            "select *,b.brand_name  as brandName  from t_supplier u ,t_brand b WHERE u.sup_brand  = b.brand_id ",
            "<if test='supplier.supName != null and supplier.supName != &apos;&apos;'> and u.sup_name LIKE CONCAT('%',#{supplier.supName},'%')</if>",
            "<if test='supplier.supAddress != null and supplier.supAddress != &apos;&apos;'> and u.sup_address LIKE CONCAT('%',#{supplier.supAddress},'%')</if>",
            "<if test='supplier.supAdddatemin != null and supplier.supAdddatemin != &apos;&apos;'> and u.sup_adddate &gt;=  str_to_date(#{supplier.supAdddatemin},'%Y-%m-%d')</if>",
            "<if test='supplier.supAdddatemax != null and supplier.supAdddatemax != &apos;&apos;'> and u.sup_adddate &lt;=  str_to_date(#{supplier.supAdddatemax},'%Y-%m-%d')</if>",
            "<if test='supplier.supCreditlevel != null'> and u.sup_creditlevel = #{supplier.supCreditlevel}</if>",
            "limit #{start},#{endPos}",
            "</script>"
    })
    @Results({
            @Result(column="sup_id" ,property="supId"),
            @Result(column="sup_name" ,property="supName"),
            @Result(column="sup_phone" ,property="supPhone"),
            @Result(column="sup_address" ,property="supAddress"),
            @Result(column="sup_creditlevel" ,property="supCreditlevel"),
            @Result(column="sup_info" ,property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update" ,property="supUpdate"),
            @Result(column="sup_linkman" ,property="supLinkman"),
            @Result(column="sup_type" ,property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="sup_checkstate" ,property="supCheckstate"),
            @Result(column="sup_brand" ,property="supBrand"),
    })
    List<Supplier> querySupplierAll(@Param("endPos") Integer pageSize, @Param("start") Integer start, @Param("supplier") Supplier supplier);

    @Select("select *,b.brand_name  AS brandName FROM t_supplier u ,t_brand b WHERE u.sup_brand  = b.brand_id AND u.sup_id = #{id}")
    @Results({
            @Result(column="sup_id" ,property="supId"),
            @Result(column="sup_name" ,property="supName"),
            @Result(column="sup_phone" ,property="supPhone"),
            @Result(column="sup_address" ,property="supAddress"),
            @Result(column="sup_creditlevel" ,property="supCreditlevel"),
            @Result(column="sup_info" ,property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update" ,property="supUpdate"),
            @Result(column="sup_linkman" ,property="supLinkman"),
            @Result(column="sup_type" ,property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="sup_checkstate" ,property="supCheckstate"),
            @Result(column="sup_brand" ,property="supBrand"),
    })
    Supplier querySupplierById(Integer id);

    @Select("select  sup_id, sup_name, sup_phone, sup_address, sup_creditlevel, sup_info, sup_kits, sup_adddate, sup_update," +
            " sup_linkman, sup_type, sup_frame, sup_checkstate, sup_brand FROM t_supplier")
    @Results({
            @Result(column="sup_id" ,property="supId"),
            @Result(column="sup_name" ,property="supName"),
            @Result(column="sup_phone" ,property="supPhone"),
            @Result(column="sup_address" ,property="supAddress"),
            @Result(column="sup_creditlevel" ,property="supCreditlevel"),
            @Result(column="sup_info" ,property="supInfo"),
            @Result(column="sup_kits" ,property="supKits"),
            @Result(column="sup_adddate" ,property="supAdddate"),
            @Result(column="sup_update" ,property="supUpdate"),
            @Result(column="sup_linkman" ,property="supLinkman"),
            @Result(column="sup_type" ,property="supType"),
            @Result(column="sup_frame" ,property="supFrame"),
            @Result(column="sup_checkstate" ,property="supCheckstate"),
            @Result(column="sup_brand" ,property="supBrand"),
    })
    List<LinkedHashMap<String,Object>> toexcel();
    @Insert({
            "<script>",
            "insert into t_supplier ",
            "(sup_name, sup_phone, sup_address, sup_brand, sup_creditlevel, sup_info,",
            "sup_adddate, sup_linkman, sup_type, sup_frame, sup_checkstate)",
            "values",
            "<foreach item='supplier' index='index' collection='suppliersList' separator=','>",
            "(#{supplier.supName}, #{supplier.supPhone}, #{supplier.supAddress}, #{supplier.supBrand}, #{supplier.supCreditlevel}, #{supplier.supInfo},",
            "#{supplier.supAdddate}, #{supplier.supLinkman}, #{supplier.supType}, #{supplier.supFrame}, #{supplier.supCheckstate})",
            "</foreach>",
            "</script>"
    })
    void saveUploadExcelFiles(@Param("suppliersList") List<Supplier> suppliersList);
}