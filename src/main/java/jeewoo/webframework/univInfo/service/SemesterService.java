package jeewoo.webframework.univInfo.service;

import jeewoo.webframework.univInfo.dao.SemesterDAO;
import jeewoo.webframework.univInfo.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {

    @Autowired
    private SemesterDAO semesterDAO;

    public List<Semester> getAllSemesters() {
        return semesterDAO.getAllSemesters();
    }
    
    public int getTotalCredits() { // 이수한 총 학점 조회
        List<Semester> semesters = getAllSemesters();
        int totalCredits = 0; //0으로 초기화
        for (Semester semester : semesters) {
            totalCredits += semester.getTotalCredits(); // 해당 학기에 수강한 과목 학점을 모두 더함
        }
        return totalCredits;
    }
}