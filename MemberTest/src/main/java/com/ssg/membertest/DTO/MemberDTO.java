package com.ssg.membertest.DTO;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MemberDTO {
//    private String mid;
//    private String pwd;
//    private String mname;

    private String userid;
    private String userPwd;
    private String userName;
    private String userEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
}
