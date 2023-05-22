package ru.kpfu.itis.model.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StepDto {

    private Long id;
    private String name;
}
