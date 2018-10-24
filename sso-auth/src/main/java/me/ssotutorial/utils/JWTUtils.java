package me.ssotutorial.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * create by songwenchao　on 18-10-23
 */
public class JWTUtils {


	public static String generateToken(String signKey, String object) {
		Long timeMills = System.currentTimeMillis();
		Date date = new Date(timeMills);

		JwtBuilder jwtBuilder = Jwts.builder().setSubject(object).
				signWith(SignatureAlgorithm.HS256, signKey).setIssuedAt(date);
		return jwtBuilder.compact();
	}

	public static String getValue(String singleKey, HttpServletRequest request, String jwtCookieName) {
		String token = CookiesUtils.getValue(request, jwtCookieName);
		if (token == null) {
			return null;
		} else {
			return Jwts.parser().setSigningKey(singleKey).parseClaimsJws(token).getBody().getSubject();
		}

	}
}
