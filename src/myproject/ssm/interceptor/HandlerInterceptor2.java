package myproject.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor{
	//�����֤�������Ȩ
		@Override
		public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
			// TODO Auto-generated method stub
			return false;
		}
		
		//�����õ�ģ�������ﴫ����ͼ�����ò˵�����
		@Override
		public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}
		
		//ͳһ���쳣������־����
		@Override
		public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}
}
