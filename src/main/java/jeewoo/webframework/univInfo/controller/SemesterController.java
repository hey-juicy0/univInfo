package jeewoo.webframework.univInfo.controller;

import jeewoo.webframework.univInfo.model.Semester;
import jeewoo.webframework.univInfo.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SemesterController {

    @Autowired
    private SemesterService semesterService;
    //학년별 이수 학점 조회
    @GetMapping("/semesters")
    public String showSemesters(Model model) {
        List<Semester> semesters = semesterService.getAllSemesters();
        model.addAttribute("semesters", semesters);

        //총 이수 학점 조회
        int totalCredits = semesterService.getTotalCredits();
        model.addAttribute("totalCredits", totalCredits);
        return "semesterList";
    }
}