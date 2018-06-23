package com.kangaroo.api.app.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.stereotype.Component;


@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();


	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			Object user = authentication.getPrincipal();
			Long userId = null;
			if (user instanceof CustomUserDetails) {
				userId = ((CustomUserDetails) user).getUserid();
			}

			return;
		}
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
}
