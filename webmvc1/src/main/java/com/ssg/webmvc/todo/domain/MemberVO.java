package com.ssg.webmvc.todo.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String mid;
    private String pwd;
    private String mname;
}
