package hei.prog.app.repository.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JImage {
  @Id @GeneratedValue @UuidGenerator private UUID id;

  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Column(nullable = false)
  private String email;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;
}
