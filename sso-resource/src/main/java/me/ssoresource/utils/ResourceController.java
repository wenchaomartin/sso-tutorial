package me.ssoresource.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * create by songwenchao　on 18-10-24
 */
@Controller
public class ResourceController {

	private static final String JWTTOKEN = "JWT-TOKEN";

	@RequestMapping(value = "/protect-resource")
	public String resource() {
		return "protectResource";
	}

	@RequestMapping(value = "/")
	public String home() {


		return "redirect:/protect-resource";
	}

	@RequestMapping(value = "/loginOut")
	public String clearCookie(HttpServletResponse response) {
		CookiesUtils.clear(response, JWTTOKEN);
		return "redirect:/";
	}
}
