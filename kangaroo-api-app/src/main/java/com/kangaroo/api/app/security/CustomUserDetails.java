package com.kangaroo.api.app.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userid;
	private String username;
	private String password;
	private Boolean enabled;
	private Boolean accountNonLocked;
	private Boolean accountNonExpired;
	private List<GrantedAuthority> authorities;

	public CustomUserDetails(Long userid, String username, String password, List<GrantedAuthority> authorities) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.enabled=true;
		this.accountNonLocked=true;
		this.accountNonExpired=true;
	}
	
	

	public CustomUserDetails(Long userid, String username, String password, Boolean enabled, Boolean accountNonLocked,
			Boolean accountNonExpired, List<GrantedAuthority> authorities) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.accountNonLocked = accountNonLocked;
		this.accountNonExpired = accountNonExpired;
		this.authorities = authorities;
	}



	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

    
}