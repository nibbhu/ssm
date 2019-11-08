package com.xkit.ssm.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xkit.ssm.entity.Easybuy_user;
import com.xkit.ssm.service.Easybuy_userService;
@Controller
public class UserHandler {
	@Autowired
	private Easybuy_userService userService;
	@RequestMapping("/login")
	public String login(@ModelAttribute("zh") String zh,@ModelAttribute("mm")String mm,Model m,HttpSession session) throws Exception{
		Easybuy_user user = userService.UserLogin(zh, mm);
		if (user==null) {
			m.addAttribute("msg","µÇÂ½Ê§°Ü£¡");
			return "login";
		}else{
			m.addAttribute(user);
			session.setAttribute("loginUser", user);
			return "welcome";
		}
	}
	@RequestMapping(value="/checkLoginName")
	public @ResponseBody String checkLoginName(String zh)throws Exception{
		boolean isok=userService.checkLoginUsed(zh);
		String rs="{\"msg\":0}";
		if (isok) {
			rs="{\"msg\":1}";
		}
		return rs;
		
	}
	@RequestMapping(value="/userlist/{abc}")
	public @ResponseBody String UserList(@PathVariable("abc") Integer id)throws Exception{
		System.out.println("idÊÇ"+id);
		return "login";
		
	}
	@RequestMapping(value="/showList")
	public @ResponseBody List<Easybuy_user> showUserList()throws Exception{
		List<Easybuy_user> list=userService.queryUser();
		return list;
		
	}
	@RequestMapping("/reg")
	public String regist(Easybuy_user user,Model m) throws Exception{
		boolean isok=userService.addUser(user);
		if (isok) {
			m.addAttribute("msg","×¢²á³É¹¦£¡");
			return "regist";
		}else{
			m.addAttribute("msg","×¢²áÊ§°Ü£¡");
			return "regist";
		}
	}
}
