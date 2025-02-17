package com.lcw.user.service.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {

    private String message;
    private T data;

   /* public ResponseDTO(String message, T data) {
        this.message = message;
        this.data = data;
    }
    public ResponseDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for data
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class Builder<T> {
        private String message;
        private T data;

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDTO<T> build() {
            return new ResponseDTO<>(message, data);
        }
    }

    // Static method to get the builder
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }
*/

}
