package jeewoo.webframework.univInfo.dao;

import jeewoo.webframework.univInfo.model.Register;
import jeewoo.webframework.univInfo.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegisterListDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Register> findRegisterByYearAndSemester(long year, int semester) {
        // 연도와 학기로 수강 내역 조회
        String sqlStatement = "SELECT * FROM Courses WHERE year = ? AND semester = ?";
        return jdbcTemplate.query(sqlStatement, new Object[]{year, semester}, new RowMapper<Register>() {
            @Override
            public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
                Register register = new Register();

                register.setCourseName(rs.getString("courseName"));
                register.setCourseType(rs.getString("courseType"));
                register.setProfessor(rs.getString("professor"));
                register.setCredits(rs.getInt("credits"));
                register.setYear(year);
                register.setSemester(semester);
                return register;
            }
        });
    }
}
