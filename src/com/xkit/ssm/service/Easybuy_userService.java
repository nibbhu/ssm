package com.xkit.ssm.service;

import java.util.List;

import com.xkit.ssm.entity.Easybuy_user;
//�û�������service�ӿ�
public interface Easybuy_userService {
	public Easybuy_user UserLogin(String zh,String mm) throws Exception;
	public boolean addUser(Easybuy_user user) throws Exception;
	public boolean checkLoginUsed(String zh) throws Exception;
	
	public List<Easybuy_user> queryUser()throws Exception;
}