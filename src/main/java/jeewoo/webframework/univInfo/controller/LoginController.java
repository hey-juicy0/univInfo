package jeewoo.webframework.univInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller public class LoginController {

    @GetMapping("/login")
    public String showLogin(@RequestParam(value="error", required = false) String error,
                            @RequestParam(value="logout", required = false) String logout,
                            Model model) {

        if(error != null) {
            model.addAttribute("errorMsg","아이디 또는 비밀번호를 확인해주세요.");
        }

        if(logout != null) {
            model.addAttribute("logoutMsg", "로그아웃 성공!");
        }


        return "login";
    }
}