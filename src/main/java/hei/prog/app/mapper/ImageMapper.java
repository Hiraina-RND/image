package hei.prog.app.mapper;

import hei.prog.app.dto.image.request.ImageRequestDto;
import hei.prog.app.dto.image.response.ImageResponseDto;
import hei.prog.app.entity.Image;
import hei.prog.app.repository.model.JImage;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public Image toDomain(ImageRequestDto imageRequestDto) {
        return Image.builder()
                .fileName(imageRequestDto.fileName())
                .email(imageRequestDto.email())
                .createdAt(imageRequestDto.createdAt())
                .build();
    }

    public Image toDomain(JImage jImage) {
        return Image.builder()
                .id(jImage.getId())
                .fileName(jImage.getFileName())
                .email(jImage.getEmail())
                .createdAt(jImage.getCreatedAt())
                .build();
    }

    public JImage toEntity(Image image) {
        return JImage.builder()
                .id(image.getId())
                .fileName(image.getFileName())
                .email(image.getEmail())
                .createdAt(image.getCreatedAt())
                .build();
    }

    public ImageResponseDto toDto(Image image) {
        return new ImageResponseDto(
                image.getId(),
                image.getFileName(),
                image.getEmail(),
                image.getCreatedAt()
        );
    }
}