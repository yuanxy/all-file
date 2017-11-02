package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.WenEntity;
import com.svse.util.DBConnection;

public class WenDAO
{
	private DBConnection b = new DBConnection();

	private PreparedStatement pre = null;

	private Connection conn = null;

	private ResultSet rs = null;

	/***************************************************************************
	 * 全查询
	 */
	public List getAll()
	{
		List ar = new ArrayList();
		try
		{
			conn = b.getConnection();
			String sql = "select * from wenzhang";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{
				WenEntity wen = new WenEntity();
				wen.setW_id(rs.getInt("w_id"));
				wen.setW_title(rs.getString("w_title"));
				wen.setW_lj(rs.getString("w_lj"));
				ar.add(wen);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//
		}
		return ar;
	}
	
	/***
	 * 增加
	 */
	public void addWen(List ar)
	{
		try
		{
			conn=b.getConnection();
			String sql="insert into wenzhang values(?,?)";
			for(int i=0;i<ar.size();i++)
			{
				WenEntity w=(WenEntity) ar.get(i);
				pre=conn.prepareStatement(sql);
				pre.setString(1,w.getW_title());
				pre.setString(2,w.getW_lj());
				pre.executeUpdate();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//
		}
	}
}
