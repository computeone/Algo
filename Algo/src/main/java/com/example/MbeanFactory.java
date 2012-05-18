package com.example;
import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;
public class MbeanFactory {
	private Student impl=new Student();
	public StandardMBean getMbean(){
		//StandardMBean mbean;
		StandardMBean mbean=new StandardMBean(impl,StudentMBean.class,false);
		return mbean;
	}

}
