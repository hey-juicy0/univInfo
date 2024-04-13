package jeewoo.webframework.univInfo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Courses")
@ToString

public class Register {
    private Long year;
    private int semester;

    @Id
    @Size(min = 7,max = 7, message = "교과코드는 7글자여야 합니다.")
    private String courseCode;

    @Size(min = 4, message = "교과목명은 4글자 이상이어야 합니다.")
    private String courseName;

    private String courseType;

    @Size(min = 2, message = "담당교수는 2글자 이상이어야 합니다.")
    private String professor;

    private int credits;
}
