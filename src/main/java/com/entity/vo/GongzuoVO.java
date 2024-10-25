package com.entity.vo;

import com.entity.GongzuoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工作人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongzuo")
public class GongzuoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 工作人员名称
     */

    @TableField(value = "gongzuo_name")
    private String gongzuoName;


    /**
     * 工作人员手机号
     */

    @TableField(value = "gongzuo_phone")
    private String gongzuoPhone;


    /**
     * 工作人员身份证号
     */

    @TableField(value = "gongzuo_id_number")
    private String gongzuoIdNumber;


    /**
     * 工作人员头像
     */

    @TableField(value = "gongzuo_photo")
    private String gongzuoPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 工作人员邮箱
     */

    @TableField(value = "gongzuo_email")
    private String gongzuoEmail;


    /**
     * 逻辑删除
     */

    @TableField(value = "gongzuo_delete")
    private Integer gongzuoDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：工作人员名称
	 */
    public String getGongzuoName() {
        return gongzuoName;
    }


    /**
	 * 获取：工作人员名称
	 */

    public void setGongzuoName(String gongzuoName) {
        this.gongzuoName = gongzuoName;
    }
    /**
	 * 设置：工作人员手机号
	 */
    public String getGongzuoPhone() {
        return gongzuoPhone;
    }


    /**
	 * 获取：工作人员手机号
	 */

    public void setGongzuoPhone(String gongzuoPhone) {
        this.gongzuoPhone = gongzuoPhone;
    }
    /**
	 * 设置：工作人员身份证号
	 */
    public String getGongzuoIdNumber() {
        return gongzuoIdNumber;
    }


    /**
	 * 获取：工作人员身份证号
	 */

    public void setGongzuoIdNumber(String gongzuoIdNumber) {
        this.gongzuoIdNumber = gongzuoIdNumber;
    }
    /**
	 * 设置：工作人员头像
	 */
    public String getGongzuoPhoto() {
        return gongzuoPhoto;
    }


    /**
	 * 获取：工作人员头像
	 */

    public void setGongzuoPhoto(String gongzuoPhoto) {
        this.gongzuoPhoto = gongzuoPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：工作人员邮箱
	 */
    public String getGongzuoEmail() {
        return gongzuoEmail;
    }


    /**
	 * 获取：工作人员邮箱
	 */

    public void setGongzuoEmail(String gongzuoEmail) {
        this.gongzuoEmail = gongzuoEmail;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getGongzuoDelete() {
        return gongzuoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setGongzuoDelete(Integer gongzuoDelete) {
        this.gongzuoDelete = gongzuoDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
