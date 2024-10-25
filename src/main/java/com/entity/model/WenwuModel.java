package com.entity.model;

import com.entity.WenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 文物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WenwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 文物编号
     */
    private String wenwuUuidNumber;


    /**
     * 文物名称
     */
    private String wenwuName;


    /**
     * 文物图片
     */
    private String wenwuPhoto;


    /**
     * 文物类型
     */
    private Integer wenwuTypes;


    /**
     * 文物热度
     */
    private Integer wenwuClicknum;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 文物介绍
     */
    private String wenwuContent;


    /**
     * 信息审核
     */
    private Integer wenwuYesnoTypes;


    /**
     * 审核结果
     */
    private String wenwuYesnoText;


    /**
     * 逻辑删除
     */
    private Integer wenwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
