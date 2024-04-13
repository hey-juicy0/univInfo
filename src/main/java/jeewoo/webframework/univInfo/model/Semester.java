package jeewoo.webframework.univInfo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

public class Semester {
    private long year;
    private int semester;
    private int totalCredits;
}