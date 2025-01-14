//package com.example.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class User {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	
//	private String fullname;
//	private String mobile;
//	private String email;
//	private String password;
//	private String confirmpassword;
//	
//	
//	public User() {}
//	
//	public User(Long id, String fullname, String mobile, String email, String password, String confirmpassword) {
//
//		this.id = id;
//		this.fullname = fullname ;
//		this.mobile = mobile;
//		this.email= email;
//		this.password = password;
//		this.confirmpassword =confirmpassword;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFullname() {
//		return fullname;
//	}
//
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}
//
//	public String getMobile() {
//		return mobile;
//	}
//
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getConfirmpassword() {
//		return confirmpassword;
//	}
//
//	public void setConfirmpassword(String confirmpassword) {
//		this.confirmpassword = confirmpassword;
//	}
//
//}
//	

package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullname;
    private String username; 
    private String contactnumber; 
    private String email;
    private String password;
    

    public User() {}

    public User(Long id, String fullname, String username, String contactNumber, String email, String password) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.contactnumber = contactNumber;
        this.email = email;
        this.password = password;
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getfullname() {
        return fullname;
    }

    public void setfullname(String fullname ) {
        this.fullname = fullname ;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContactNumber() {
        return contactnumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactnumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
}

