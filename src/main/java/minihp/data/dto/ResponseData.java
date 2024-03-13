package minihp.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseData<T> {
    private int status;
    private String message;
    private T data;

    public static <T> ResponseData<T> res(final int status, final String message) {
        return ResponseData.<T>builder()
                .status(status)
                .message(message)
                .data(null)
                .build();
    }


    public static <T> ResponseData<T> res(final int status, final String message, final T data) {
        return ResponseData.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }
}