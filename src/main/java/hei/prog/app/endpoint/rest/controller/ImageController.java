package hei.prog.app.endpoint.rest.controller;

import hei.prog.app.dto.image.request.ImageRequestDto;
import hei.prog.app.dto.image.response.ImageResponseDto;
import hei.prog.app.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<ImageResponseDto> save(@RequestBody @Valid ImageRequestDto imageRequestDto) {
        ImageResponseDto imageResponseDto = imageService.save(imageRequestDto);
        return new ResponseEntity<>(imageResponseDto, HttpStatus.CREATED);
    }
}