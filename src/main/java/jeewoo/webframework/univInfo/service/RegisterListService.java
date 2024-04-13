package jeewoo.webframework.univInfo.service;

import jeewoo.webframework.univInfo.dao.RegisterListDAO;
import jeewoo.webframework.univInfo.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterListService {

    @Autowired
    private RegisterListDAO registerListDAO;

    public List<Register> getRegisterListForYearAndSemester(long year, int semester) {
        return registerListDAO.findRegisterByYearAndSemester(year, semester);
    }
}