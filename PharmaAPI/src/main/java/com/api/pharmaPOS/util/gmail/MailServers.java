package com.api.pharmaPOS.util.gmail;

public enum MailServers {
  
	GMAIL("GMAIL", "smtp.gmail.com"),
    OUTLOOK("OUTLOOK", "smtp-mail.outlook.com"),
    YAHOO("YAHOO", "smtp.mail.yahoo.com"),
    ZOHO("ZOHO", "smtp.zoho.com");

    private final String name;
    private final String address;
    
	private MailServers(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
    
}
