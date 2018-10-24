package me.ssoresource.utils;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by songwenchao　on 18-10-23
 */
public class CookiesUtils {

	public static void create(HttpServletResponse response, String name, String value, boolean secure, int maxAge, String domian) {
		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		cookie.setSecure(secure);
		cookie.setDomain(domian);
		response.addCookie(cookie);
	}

	public static void clear(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setHttpOnly(true);
		cookie.setDomain("localhost");
		cookie.setMaxAge(0);
		cookie.setPath("/");
		cookie.setSecure(false);
		response.addCookie(cookie);
	}

	public static String getValue(HttpServletRequest request, String name) {
		Cookie cookie = WebUtils.getCookie(request, name);
		return cookie == null ? null : cookie.getValue();
	}
}
