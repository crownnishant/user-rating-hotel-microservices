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

}
