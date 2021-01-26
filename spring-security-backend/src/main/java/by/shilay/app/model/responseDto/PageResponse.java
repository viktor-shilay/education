package by.shilay.app.model.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {
    @JsonProperty("content")
    private List<T> content;
    @JsonProperty("totalElements")
    private int totalElements;
    @JsonProperty("totalPages")
    private int totalPages;
}
