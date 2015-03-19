package com.lge.selinuxlogcatcher;

public class SELinuxLogItem {
	
	private static final String PREFIX_SCONTEXT = "scontext=u:r:";
	private static final String PREFIX_TCONTEXT = "tcontext=u:object_r:";
	private static final String PREFIX_SYSCALL = "{ ";
	private static final String SUFFIX_CONTEXT = ":s0";
	private static final String SUFFIX_SYSCALL = " }";
	
	private String tag;
	private String log;
	private String scontext;
	private String syscall;
	private String tcontext;
	
	 
	public SELinuxLogItem(String title, String log) {
		super();
		this.tag = title;
		this.log = log;
		this.scontext = null;
		this.syscall = null;
		this.tcontext = null;
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
	public String getScontext() {
		scontext = searchContext(PREFIX_SCONTEXT);
		return scontext;
	}
	public String getTcontext() {
		tcontext = searchContext(PREFIX_TCONTEXT);
		return tcontext;
	}
	public String getSyscall() {
		syscall = searchContext(PREFIX_SYSCALL);
		return syscall;
	}

	public String searchContext(String context) {
		
		int start = 0;
		int end = 0;
		String result = null;
		
		start = log.indexOf(context);
		
		if(context.equalsIgnoreCase(PREFIX_SCONTEXT)) {
			start = start + PREFIX_SCONTEXT.length();
		} else if(context.equals(PREFIX_TCONTEXT)) {
			start = start + PREFIX_TCONTEXT.length();
		} else if(context.equals(PREFIX_SYSCALL)){
			start = start + PREFIX_SYSCALL.length();
		}
		
		if(context.equals(PREFIX_SYSCALL)) {
			end = log.indexOf(SUFFIX_SYSCALL, start);
			end = end;
		} else {
			end = log.indexOf(SUFFIX_CONTEXT, start);
		}



		result = log.substring(start, end);

		return result;
	}


}