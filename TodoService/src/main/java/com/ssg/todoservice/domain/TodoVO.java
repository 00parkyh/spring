package com.ssg.todoservice.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoVO {
    private int tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
}
