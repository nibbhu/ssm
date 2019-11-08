package com.xkit.ssm.handler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.entity.Easybuy_user_address;
import com.xkit.ssm.service.Easybuy_userService;
import com.xkit.ssm.service.Easybuy_user_addressService;

@Controller
public class AddressHandler {
	@Autowired
	private Easybuy_userService userService;
	@Autowired
	private Easybuy_user_addressService addressService;
	
	@RequestMapping("/initAddAddress")
	public String initAddAddress() throws Exception{
		return "WEB-INF/pages/addAddress";
	}
	
	@RequestMapping("/addAddress")
	public String addAddress(Easybuy_user_address address,Model m){
		address.setCreateTime(new Date());
		if (address.getIsDefault()==null) {
			address.setIsDefault(0);
		}
		boolean isok=addressService.addAddress(address);
		if (isok) {
			m.addAttribute("msg", "������ַ�ɹ���");
		}else{
			m.addAttribute("msg", "������ַʧ�ܣ�");
		}
		return "WEB-INF/pages/addAddress";
	}
	@ModelAttribute("userlist")
	public List<Easybuy_user> getUsers() throws Exception{
		List<Easybuy_user> list = userService.queryUser();
		return list;
	}
	
	
	
	
}
