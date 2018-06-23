package com.kangaroo.api.management.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = -2525781927419274378L;
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



	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
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