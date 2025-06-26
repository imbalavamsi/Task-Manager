package com.practice.task.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskDto(
        Long id,

        @NotBlank(message = "Title cannot be blank")
        String title,

        String description,

        boolean completed
) {}
