package com.example;
import javax.management.*;
public class Notificationfilter implements NotificationFilter{
	public boolean isNotificationEnabled(Notification notification){
		return true;
		
	}

}
