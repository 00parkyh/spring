package com.ssg.homework_board.domain;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class PostVO {
    private int post_id;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
