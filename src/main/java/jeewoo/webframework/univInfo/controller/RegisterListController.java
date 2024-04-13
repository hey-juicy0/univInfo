package jeewoo.webframework.univInfo.controller;

import jeewoo.webframework.univInfo.model.Register;
import jeewoo.webframework.univInfo.service.RegisterListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisterListController {

    @Autowired
    private RegisterListService registerListService;

    @GetMapping("/registerList")
    public String showRegisterList(Model model) {
        // 2024년 2학기 수강 신청 조회
        List<Register> registerList = registerListService.getRegisterListForYearAndSemester(2024, 2);
        model.addAttribute("registerList", registerList);
        return "registerList";
    }
    @GetMapping("/registerDetail")
    public String showRegisterListByYearAndSemester(@RequestParam long year, @RequestParam int semester, Model model) {
        // 해당 학기의 등록된 모든 과목 조회
        List<Register> registers = registerListService.getRegisterListForYearAndSemester(year, semester);
        model.addAttribute("courses", registers);
        return "registerDetail";
    }

}
