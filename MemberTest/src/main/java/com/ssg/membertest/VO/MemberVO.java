package com.ssg.membertest.VO;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class MemberVO {
    private String mid;
    private String pwd;
    private String mname;
}
