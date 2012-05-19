package com.example;
import javax.management.*;
public class Management {

	/**
	 * @param args
	 */
	public MBeanServer getMbeanserver(){
		return MBeanServerFactory.createMBeanServer();
	}
	public static void main(String[] argv) throws Exception{
		System.out.println("Mbean Server initing...");
		MbeanFactory mfactory=new MbeanFactory();
		Notificationfilter notificationfilter=new Notificationfilter();
		//Notification notification=new Notification();
		Notificationimpl notificationimpl=new Notificationimpl();
		Handback handback=new Handback();
		StandardMBean mbean=mfactory.getMbean();
		//Attribute attrname=new Attribute("name","niubaisui");
		//mbean.setAttribute(attrname);
		ObjectName  name;
	    name = new ObjectName("mbean:type=Student");
		Management management=new Management();
		MBeanServer mbeanserver=management.getMbeanserver();
		try {
			mbeanserver.registerMBean(mbean, name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("mbean build default");
			e.printStackTrace();
		    System.exit(0);
		}
		//mbeanserver.addNotificationListener(name, notificationimpl, notification, handback);
		System.out.println("initing success!");
		Thread.sleep(Long.MAX_VALUE);
		//System.out.println(mbeanserver.getAttribute(name, "name"));
	}
}












