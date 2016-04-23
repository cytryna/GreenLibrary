package s10338.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginLibraryController {

	@RequestMapping(value="/loginlibrary", method = RequestMethod.GET)
	public String login() {
 		return "loginLibrary";
	}
//
//	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
//	public String loginerror(Model model) {
//
//		model.addAttribute("error", "true");
//		return "login";
// 	}
//
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logout(Model model) {
// 		return "login";
// 	}
}
