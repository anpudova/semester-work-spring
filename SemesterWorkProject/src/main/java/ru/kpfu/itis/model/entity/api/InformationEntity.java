package ru.kpfu.itis.model.entity.api;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InformationEntity {

    private Long id;
    private String title;
    private String image;
    private String summary;
}
