package hei.prog.app.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Image {
  private UUID id;
  private String fileName;
  private String email;
  private LocalDateTime createdAt;
}
