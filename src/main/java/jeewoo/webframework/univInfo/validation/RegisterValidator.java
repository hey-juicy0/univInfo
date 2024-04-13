package jeewoo.webframework.univInfo.validation;

import jeewoo.webframework.univInfo.model.Register;
import jeewoo.webframework.univInfo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Register.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Register register = (Register) target;

        // 값이 null인 경우
        if (register.getCourseName() == null || register.getCourseType() == null ||
                register.getProfessor() == null || register.getCourseCode() == null) {
            errors.reject("nullValue", "모든 항목을 기입해주세요.");
        }
        // 교수 이름은 2글자 이상이어야 함
        if (register.getProfessor().length() < 2) {
            errors.rejectValue("professor", "invalidProfessor", "교수 이름은 2글자 이상이어야 합니다.");
        }
        // 교과목명은 2글자 이상이어야 함
        if (register.getCourseName().length() < 2) {
            errors.rejectValue("courseName", "invalidCourseName", "교과목명은 2글자 이상이어야 합니다.");
        }
        // 교과코드는 2글자 이상이어야 함
        if (register.getCourseCode().length() != 7) {
            errors.rejectValue("courseCode", "invalidCourseCode", "교과코드는 2글자 이상이어야 합니다.");
        }
    }
}
