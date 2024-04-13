package jeewoo.webframework.univInfo.dao;

import jeewoo.webframework.univInfo.model.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SemesterDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    // 모든 학기 조회
    public List<Semester> getAllSemesters() {
        String sql = "SELECT year, semester, SUM(credits) AS totalCredits FROM Courses GROUP BY year, semester";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Semester semester = new Semester();
            semester.setYear(rs.getLong("year"));
            semester.setSemester(rs.getInt("semester"));
            semester.setTotalCredits(rs.getInt("totalCredits")); //총학점
            return semester;
        });
    }
}