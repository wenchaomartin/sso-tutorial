package me.ssotutorial.utils;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by songwenchao　on 18-10-23
 */
public class JwtFilter extends OncePerRequestFilter {
	private static final String JWTTOKEN = "JWT-TOKEN";
	private static final String singleKey = "singleKey";

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		String username = JWTUtils.getValue(singleKey, httpServletRequest, JWTTOKEN);
		if (username == null) {
			String authServer = this.getFilterConfig().getInitParameter("authServer");
			httpServletResponse.sendRedirect(authServer );
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
