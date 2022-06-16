package com.scaler.splitwisejune22.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequestDto {
    private Long userId;
    private String newPassword;
}
