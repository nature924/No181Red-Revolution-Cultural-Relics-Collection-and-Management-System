package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 文物
 *
 * @author 
 * @email
 */
@TableName("wenwu")
public class WenwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WenwuEntity() {

	}

	public WenwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 文物编号
     */
    @ColumnInfo(comment="文物编号",type="varchar(200)")
    @TableField(value = "wenwu_uuid_number")

    private String wenwuUuidNumber;


    /**
     * 文物名称
     */
    @ColumnInfo(comment="文物名称",type="varchar(200)")
    @TableField(value = "wenwu_name")

    private String wenwuName;


    /**
     * 文物图片
     */
    @ColumnInfo(comment="文物图片",type="varchar(200)")
    @TableField(value = "wenwu_photo")

    private String wenwuPhoto;


    /**
     * 文物类型
     */
    @ColumnInfo(comment="文物类型",type="int(11)")
    @TableField(value = "wenwu_types")

    private Integer wenwuTypes;


    /**
     * 文物热度
     */
    @ColumnInfo(comment="文物热度",type="int(11)")
    @TableField(value = "wenwu_clicknum")

    private Integer wenwuClicknum;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 文物介绍
     */
    @ColumnInfo(comment="文物介绍",type="longtext")
    @TableField(value = "wenwu_content")

    private String wenwuContent;


    /**
     * 信息审核
     */
    @ColumnInfo(comment="信息审核",type="int(11)")
    @TableField(value = "wenwu_yesno_types")

    private Integer wenwuYesnoTypes;


    /**
     * 审核结果
     */
    @ColumnInfo(comment="审核结果",type="longtext")
    @TableField(value = "wenwu_yesno_text")

    private String wenwuYesnoText;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "wenwu_delete")

    private Integer wenwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：文物编号
	 */
    public String getWenwuUuidNumber() {
        return wenwuUuidNumber;
    }
    /**
	 * 设置：文物编号
	 */

    public void setWenwuUuidNumber(String wenwuUuidNumber) {
        this.wenwuUuidNumber = wenwuUuidNumber;
    }
    /**
	 * 获取：文物名称
	 */
    public String getWenwuName() {
        return wenwuName;
    }
    /**
	 * 设置：文物名称
	 */

    public void setWenwuName(String wenwuName) {
        this.wenwuName = wenwuName;
    }
    /**
	 * 获取：文物图片
	 */
    public String getWenwuPhoto() {
        return wenwuPhoto;
    }
    /**
	 * 设置：文物图片
	 */

    public void setWenwuPhoto(String wenwuPhoto) {
        this.wenwuPhoto = wenwuPhoto;
    }
    /**
	 * 获取：文物类型
	 */
    public Integer getWenwuTypes() {
        return wenwuTypes;
    }
    /**
	 * 设置：文物类型
	 */

    public void setWenwuTypes(Integer wenwuTypes) {
        this.wenwuTypes = wenwuTypes;
    }
    /**
	 * 获取：文物热度
	 */
    public Integer getWenwuClicknum() {
        return wenwuClicknum;
    }
    /**
	 * 设置：文物热度
	 */

    public void setWenwuClicknum(Integer wenwuClicknum) {
        this.wenwuClicknum = wenwuClicknum;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：文物介绍
	 */
    public String getWenwuContent() {
        return wenwuContent;
    }
    /**
	 * 设置：文物介绍
	 */

    public void setWenwuContent(String wenwuContent) {
        this.wenwuContent = wenwuContent;
    }
    /**
	 * 获取：信息审核
	 */
    public Integer getWenwuYesnoTypes() {
        return wenwuYesnoTypes;
    }
    /**
	 * 设置：信息审核
	 */

    public void setWenwuYesnoTypes(Integer wenwuYesnoTypes) {
        this.wenwuYesnoTypes = wenwuYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getWenwuYesnoText() {
        return wenwuYesnoText;
    }
    /**
	 * 设置：审核结果
	 */

    public void setWenwuYesnoText(String wenwuYesnoText) {
        this.wenwuYesnoText = wenwuYesnoText;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWenwuDelete() {
        return wenwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWenwuDelete(Integer wenwuDelete) {
        this.wenwuDelete = wenwuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Wenwu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", wenwuUuidNumber=" + wenwuUuidNumber +
            ", wenwuName=" + wenwuName +
            ", wenwuPhoto=" + wenwuPhoto +
            ", wenwuTypes=" + wenwuTypes +
            ", wenwuClicknum=" + wenwuClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", wenwuContent=" + wenwuContent +
            ", wenwuYesnoTypes=" + wenwuYesnoTypes +
            ", wenwuYesnoText=" + wenwuYesnoText +
            ", wenwuDelete=" + wenwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
