package jeewoo.webframework.univInfo.service;

import jeewoo.webframework.univInfo.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveCourse(Register register) {
        entityManager.persist(register);
    }

}
