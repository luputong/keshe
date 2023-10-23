package mavenkeshe.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private int gender;
    private int savings;
    private String phoneNumber;
    private LocalDateTime loginTime;
    private LocalDateTime updateTime;

}
