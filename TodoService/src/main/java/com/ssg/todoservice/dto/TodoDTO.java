package com.ssg.todoservice.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDTO {
    private int tno;
    @NotEmpty
    private String title;
    @Future
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer;
}
