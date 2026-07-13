package hei.prog.app.dto.image.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ImageResponseDto(
        UUID id,
        String fileName,
        String email,
        LocalDateTime createdAt
) {}
