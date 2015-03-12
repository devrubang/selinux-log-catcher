package com.lge.selinuxlogcatcher;

public class SELinuxLogItem {
	private String tag;
	private String log;
	public SELinuxLogItem(String title, String log) {
		super();
		this.tag = title;
		this.log = log;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
}