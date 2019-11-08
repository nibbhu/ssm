package com.xkit.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xkit.ssm.entity.Easybuy_user;
//�û������dao�ӿ�
public interface Easybuy_userDAO {
	public Easybuy_user get(@Param("zh") String zh,@Param("mm") String mm) throws Exception;
	public int insert(Easybuy_user user) throws Exception;
	public int getCount(String zh) throws Exception;
	public List<Easybuy_user> selectUser()throws Exception;
}
