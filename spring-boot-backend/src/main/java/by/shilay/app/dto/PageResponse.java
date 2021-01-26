package by.shilay.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {
    @JsonProperty("content")
    private List<T> content;
    @JsonProperty("totalElements")
    private long totalElements;
    @JsonProperty("totalPages")
    private long totalPages;
}
