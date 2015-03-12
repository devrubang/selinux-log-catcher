package com.lge.selinuxlogcatcher;

import java.util.ArrayList;

public class SELinuxLogItemMgr {
	ArrayList<SELinuxLogItem> logItemList = new ArrayList<SELinuxLogItem>();
	
	public void addList(SELinuxLogItem item) {
		logItemList.add(item);
	}
	
	public ArrayList<SELinuxLogItem> getLogItemList() {
		return logItemList;
	}
}