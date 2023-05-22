package ru.kpfu.itis.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
public class InformationResponse {

    @SerializedName("id")
    private Long id;

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    @SerializedName("summary")
    private String summary;

}
