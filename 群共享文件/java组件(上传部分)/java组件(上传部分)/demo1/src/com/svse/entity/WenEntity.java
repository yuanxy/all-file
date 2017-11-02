package com.svse.entity;

import java.io.Serializable;

public class WenEntity implements Serializable
{

	private int w_id;

	private String w_title;

	private String w_lj;

	public int getW_id()
	{
		return w_id;
	}

	public void setW_id(int w_id)
	{
		this.w_id = w_id;
	}

	public String getW_lj()
	{
		return w_lj;
	}

	public void setW_lj(String w_lj)
	{
		this.w_lj = w_lj;
	}

	public String getW_title()
	{
		return w_title;
	}

	public void setW_title(String w_title)
	{
		this.w_title = w_title;
	}

}
