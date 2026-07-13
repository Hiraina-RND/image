package hei.prog.app.repository;

import hei.prog.app.repository.model.JImage;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<JImage, UUID> {}
