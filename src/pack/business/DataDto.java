package pack.business;

import java.sql.Timestamp;

public class DataDto {
	private String id,name,password;
	private Timestamp regdata;
	
	public boolean isCheckPasswd(String passwd){
		if(this.password.equals(passwd)){
			return true;
		}else{
			return false;
		}
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegdata() {
		return regdata;
	}

	public void setRegdata(Timestamp regdata) {
		this.regdata = regdata;
	}
	
	
	
}
