package com.ssg.membertest.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Member {
    private String mid;
    private String pwd;
    private String mname;
}
