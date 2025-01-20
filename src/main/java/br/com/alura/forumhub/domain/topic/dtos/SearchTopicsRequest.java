package br.com.alura.forumhub.domain.topic.dtos;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record SearchTopicsRequest(
        String courseId,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate createdAt) {
}
