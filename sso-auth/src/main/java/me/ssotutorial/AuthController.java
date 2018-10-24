package me.ssotutorial;

import me.ssotutorial.utils.CookiesUtils;
import me.ssotutorial.utils.JWTUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;

/**
 * create by songwenchao　on 18-10-23
 */
@Controller
public class AuthController {

	private static final ConcurrentHashMap<String, String> DATA = new ConcurrentHashMap<>();

	private static final String SINGLEKEY = "singleKey";

	private static final String COOKIENAME = "JWT-TOKEN";


	public AuthController() {
		DATA.put("admin", "admin");
	}

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletResponse response, String redirect, String username, String password, Model model) {
		if (StringUtils.isEmpty(username) || DATA.get(username) == null || !DATA.get(username).equals(password)) {
			model.addAttribute("error", "username or password is incorrect!");
			return "login";
		} else {
			String token = JWTUtils.generateToken(SINGLEKEY, username);
			CookiesUtils.create(response, COOKIENAME, token, false, -1, "localhost");
			return "redirect:" + redirect;
		}
	}


}
