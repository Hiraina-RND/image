package hei.prog.app.service;

import hei.prog.app.dto.image.response.ImageResponseDto;
import hei.prog.app.entity.Image;
import hei.prog.app.mapper.ImageMapper;
import hei.prog.app.repository.ImageRepository;
import hei.prog.app.repository.model.JImage;
import hei.prog.app.s3.S3Service;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

  private final ImageRepository imageRepository;
  private final ImageMapper imageMapper;
  private final S3Service s3Service;
  private final ImageProcessingService imageProcessingService;

  public ImageResponseDto save(String fileName, String email, MultipartFile file) {
    Image image =
        Image.builder()
            .fileName(fileName)
            .email(email)
            .createdAt(LocalDateTime.now())
            .build();

    JImage jImage = imageMapper.toEntity(image);
    JImage saved = imageRepository.save(jImage);

    asyncUploadToS3(file, saved.getFileName());

    return imageMapper.toDto(imageMapper.toDomain(saved));
  }

  @Async
  public void asyncUploadToS3(MultipartFile file, String fileName) {
    try {
      InputStream grayscaleStream = imageProcessingService.convertToGrayscale(file.getInputStream());
      String s3Key = "grayscale/" + UUID.randomUUID() + "_" + fileName;
      s3Service.upload(s3Key, grayscaleStream, "image/png");
    } catch (IOException e) {
      log.error("Failed to process and upload image to S3", e);
    }
  }
}
