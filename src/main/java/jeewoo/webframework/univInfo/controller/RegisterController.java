package jeewoo.webframework.univInfo.controller;

import jeewoo.webframework.univInfo.model.Register;
import jeewoo.webframework.univInfo.service.RegisterService;
import jeewoo.webframework.univInfo.validation.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("course", new Register());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("course") @Valid Register register, BindingResult result, Model model) {

        // 오류 검증 작업
        if(result.hasErrors()){
            System.out.println("invalid data error");
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error:errors){
                System.out.println(error.getDefaultMessage());
            }
            return "register";
        }

        // 새로운 Register 객체 생성
        Register newRegister = new Register();

        newRegister.setCourseCode(register.getCourseCode());
        newRegister.setCourseName(register.getCourseName());
        newRegister.setCourseType(register.getCourseType());
        newRegister.setProfessor(register.getProfessor());
        newRegister.setCredits(register.getCredits());
        newRegister.setYear(2024L);
        newRegister.setSemester(2);

        // 유효성 검증 성공 시, DB에 저장
        registerService.saveCourse(newRegister);

        // 성공 메시지를 모델에 추가하여 뷰 페이지에서 사용할 수 있도록 함
        model.addAttribute("successMessage", "수강 신청이 완료되었습니다.");

        // 성공 메시지를 포함한 뷰 페이지로 이동
        return "register";
    }
}