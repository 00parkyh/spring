package com.ssg.homework_board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long post_id;
    private String title;
    private String content;
    private String writer;
    private String passphrase;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}