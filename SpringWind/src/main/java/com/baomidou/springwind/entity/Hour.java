package com.baomidou.springwind.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author zhyonk
 * @since 2018-04-07
 */
public class Hour extends Model<Hour> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String hour;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
