package hei.prog.app.service;

import hei.prog.app.dto.image.request.ImageRequestDto;
import hei.prog.app.dto.image.response.ImageResponseDto;
import hei.prog.app.entity.Image;
import hei.prog.app.mapper.ImageMapper;
import hei.prog.app.repository.ImageRepository;
import hei.prog.app.repository.model.JImage;
import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ImageResponseDto save(ImageRequestDto imageRequestDto) {
        Image image = imageMapper.toDomain(imageRequestDto);
        image.setCreatedAt(LocalDateTime.now());
        JImage jImage = imageMapper.toEntity(image);
        JImage saved = imageRepository.save(jImage);
        return imageMapper.toDto(imageMapper.toDomain(saved));
    }
}