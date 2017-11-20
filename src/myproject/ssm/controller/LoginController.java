package myproject.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	//��½
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) {
		//ͨ��username��ѯ���ݿ�
		
		
		session.setAttribute("username", username);
		return "redirect:/items/queryItems.action";
	}
	//�˳�
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/jsp/login.jsp";
	}
}
