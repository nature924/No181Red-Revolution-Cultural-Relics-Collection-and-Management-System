package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WenwuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 文物留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wenwu_liuyan")
public class WenwuLiuyanView extends WenwuLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 文物
					 
		/**
		* 文物 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer wenwuYonghuId;
		/**
		* 文物编号
		*/

		@ColumnInfo(comment="文物编号",type="varchar(200)")
		private String wenwuUuidNumber;
		/**
		* 文物名称
		*/

		@ColumnInfo(comment="文物名称",type="varchar(200)")
		private String wenwuName;
		/**
		* 文物图片
		*/

		@ColumnInfo(comment="文物图片",type="varchar(200)")
		private String wenwuPhoto;
		/**
		* 文物类型
		*/
		@ColumnInfo(comment="文物类型",type="int(11)")
		private Integer wenwuTypes;
			/**
			* 文物类型的值
			*/
			@ColumnInfo(comment="文物类型的字典表值",type="varchar(200)")
			private String wenwuValue;
		/**
		* 文物热度
		*/

		@ColumnInfo(comment="文物热度",type="int(11)")
		private Integer wenwuClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 文物介绍
		*/

		@ColumnInfo(comment="文物介绍",type="longtext")
		private String wenwuContent;
		/**
		* 信息审核
		*/
		@ColumnInfo(comment="信息审核",type="int(11)")
		private Integer wenwuYesnoTypes;
			/**
			* 信息审核的值
			*/
			@ColumnInfo(comment="信息审核的字典表值",type="varchar(200)")
			private String wenwuYesnoValue;
		/**
		* 审核结果
		*/

		@ColumnInfo(comment="审核结果",type="longtext")
		private String wenwuYesnoText;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wenwuDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public WenwuLiuyanView() {

	}

	public WenwuLiuyanView(WenwuLiuyanEntity wenwuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, wenwuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 文物
		/**
		* 获取：文物 的 用户
		*/
		public Integer getWenwuYonghuId() {
			return wenwuYonghuId;
		}
		/**
		* 设置：文物 的 用户
		*/
		public void setWenwuYonghuId(Integer wenwuYonghuId) {
			this.wenwuYonghuId = wenwuYonghuId;
		}

		/**
		* 获取： 文物编号
		*/
		public String getWenwuUuidNumber() {
			return wenwuUuidNumber;
		}
		/**
		* 设置： 文物编号
		*/
		public void setWenwuUuidNumber(String wenwuUuidNumber) {
			this.wenwuUuidNumber = wenwuUuidNumber;
		}

		/**
		* 获取： 文物名称
		*/
		public String getWenwuName() {
			return wenwuName;
		}
		/**
		* 设置： 文物名称
		*/
		public void setWenwuName(String wenwuName) {
			this.wenwuName = wenwuName;
		}

		/**
		* 获取： 文物图片
		*/
		public String getWenwuPhoto() {
			return wenwuPhoto;
		}
		/**
		* 设置： 文物图片
		*/
		public void setWenwuPhoto(String wenwuPhoto) {
			this.wenwuPhoto = wenwuPhoto;
		}
		/**
		* 获取： 文物类型
		*/
		public Integer getWenwuTypes() {
			return wenwuTypes;
		}
		/**
		* 设置： 文物类型
		*/
		public void setWenwuTypes(Integer wenwuTypes) {
			this.wenwuTypes = wenwuTypes;
		}


			/**
			* 获取： 文物类型的值
			*/
			public String getWenwuValue() {
				return wenwuValue;
			}
			/**
			* 设置： 文物类型的值
			*/
			public void setWenwuValue(String wenwuValue) {
				this.wenwuValue = wenwuValue;
			}

		/**
		* 获取： 文物热度
		*/
		public Integer getWenwuClicknum() {
			return wenwuClicknum;
		}
		/**
		* 设置： 文物热度
		*/
		public void setWenwuClicknum(Integer wenwuClicknum) {
			this.wenwuClicknum = wenwuClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 文物介绍
		*/
		public String getWenwuContent() {
			return wenwuContent;
		}
		/**
		* 设置： 文物介绍
		*/
		public void setWenwuContent(String wenwuContent) {
			this.wenwuContent = wenwuContent;
		}
		/**
		* 获取： 信息审核
		*/
		public Integer getWenwuYesnoTypes() {
			return wenwuYesnoTypes;
		}
		/**
		* 设置： 信息审核
		*/
		public void setWenwuYesnoTypes(Integer wenwuYesnoTypes) {
			this.wenwuYesnoTypes = wenwuYesnoTypes;
		}


			/**
			* 获取： 信息审核的值
			*/
			public String getWenwuYesnoValue() {
				return wenwuYesnoValue;
			}
			/**
			* 设置： 信息审核的值
			*/
			public void setWenwuYesnoValue(String wenwuYesnoValue) {
				this.wenwuYesnoValue = wenwuYesnoValue;
			}

		/**
		* 获取： 审核结果
		*/
		public String getWenwuYesnoText() {
			return wenwuYesnoText;
		}
		/**
		* 设置： 审核结果
		*/
		public void setWenwuYesnoText(String wenwuYesnoText) {
			this.wenwuYesnoText = wenwuYesnoText;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWenwuDelete() {
			return wenwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWenwuDelete(Integer wenwuDelete) {
			this.wenwuDelete = wenwuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "WenwuLiuyanView{" +
			", wenwuUuidNumber=" + wenwuUuidNumber +
			", wenwuName=" + wenwuName +
			", wenwuPhoto=" + wenwuPhoto +
			", wenwuClicknum=" + wenwuClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", wenwuContent=" + wenwuContent +
			", wenwuYesnoText=" + wenwuYesnoText +
			", wenwuDelete=" + wenwuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
