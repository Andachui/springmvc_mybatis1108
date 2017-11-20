package myproject.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	//登陆
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) {
		//通过username查询数据库
		
		
		session.setAttribute("username", username);
		return "redirect:/items/queryItems.action";
	}
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/jsp/login.jsp";
	}
}
