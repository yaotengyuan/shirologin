package com.yaotengyuan.errorcode;

public enum YaotengyuanErrorCode {
	
	NULL_OBJ("LUO001","空对象"),
	ERROR_ADD_USER("LUO002","添加用户错误"),
	LOGIN_VERIFY_FAILURE("LUO003","登陆认证失败"),
	UNKNOWN_ERROR("LUO999","未知错误....");
	
	
    private String value;
    private String desc;

    private YaotengyuanErrorCode(String value, String desc) {
        this.setValue(value);
        this.setDesc(desc);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    @Override
    public String toString() {
    	return "[" + this.value + "]" + this.desc;
    }
}
