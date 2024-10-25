package com.entity.vo;

import com.entity.WenwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 文物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wenwu")
public class WenwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 文物编号
     */

    @TableField(value = "wenwu_uuid_number")
    private String wenwuUuidNumber;


    /**
     * 文物名称
     */

    @TableField(value = "wenwu_name")
    private String wenwuName;


    /**
     * 文物图片
     */

    @TableField(value = "wenwu_photo")
    private String wenwuPhoto;


    /**
     * 文物类型
     */

    @TableField(value = "wenwu_types")
    private Integer wenwuTypes;


    /**
     * 文物热度
     */

    @TableField(value = "wenwu_clicknum")
    private Integer wenwuClicknum;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 文物介绍
     */

    @TableField(value = "wenwu_content")
    private String wenwuContent;


    /**
     * 信息审核
     */

    @TableField(value = "wenwu_yesno_types")
    private Integer wenwuYesnoTypes;


    /**
     * 审核结果
     */

    @TableField(value = "wenwu_yesno_text")
    private String wenwuYesnoText;


    /**
     * 逻辑删除
     */

    @TableField(value = "wenwu_delete")
    private Integer wenwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：文物编号
	 */
    public String getWenwuUuidNumber() {
        return wenwuUuidNumber;
    }


    /**
	 * 获取：文物编号
	 */

    public void setWenwuUuidNumber(String wenwuUuidNumber) {
        this.wenwuUuidNumber = wenwuUuidNumber;
    }
    /**
	 * 设置：文物名称
	 */
    public String getWenwuName() {
        return wenwuName;
    }


    /**
	 * 获取：文物名称
	 */

    public void setWenwuName(String wenwuName) {
        this.wenwuName = wenwuName;
    }
    /**
	 * 设置：文物图片
	 */
    public String getWenwuPhoto() {
        return wenwuPhoto;
    }


    /**
	 * 获取：文物图片
	 */

    public void setWenwuPhoto(String wenwuPhoto) {
        this.wenwuPhoto = wenwuPhoto;
    }
    /**
	 * 设置：文物类型
	 */
    public Integer getWenwuTypes() {
        return wenwuTypes;
    }


    /**
	 * 获取：文物类型
	 */

    public void setWenwuTypes(Integer wenwuTypes) {
        this.wenwuTypes = wenwuTypes;
    }
    /**
	 * 设置：文物热度
	 */
    public Integer getWenwuClicknum() {
        return wenwuClicknum;
    }


    /**
	 * 获取：文物热度
	 */

    public void setWenwuClicknum(Integer wenwuClicknum) {
        this.wenwuClicknum = wenwuClicknum;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：文物介绍
	 */
    public String getWenwuContent() {
        return wenwuContent;
    }


    /**
	 * 获取：文物介绍
	 */

    public void setWenwuContent(String wenwuContent) {
        this.wenwuContent = wenwuContent;
    }
    /**
	 * 设置：信息审核
	 */
    public Integer getWenwuYesnoTypes() {
        return wenwuYesnoTypes;
    }


    /**
	 * 获取：信息审核
	 */

    public void setWenwuYesnoTypes(Integer wenwuYesnoTypes) {
        this.wenwuYesnoTypes = wenwuYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getWenwuYesnoText() {
        return wenwuYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setWenwuYesnoText(String wenwuYesnoText) {
        this.wenwuYesnoText = wenwuYesnoText;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWenwuDelete() {
        return wenwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWenwuDelete(Integer wenwuDelete) {
        this.wenwuDelete = wenwuDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
