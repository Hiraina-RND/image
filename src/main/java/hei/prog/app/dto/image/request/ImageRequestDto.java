package hei.prog.app.dto.image.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record ImageRequestDto(
    @NotBlank(message = "fileName is required") String fileName,
    @NotBlank(message = "email is required") @Email(message = "email must be valid") String email,
    LocalDateTime createdAt) {}
