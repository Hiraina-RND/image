package hei.prog.app.endpoint.rest.controller;

import hei.prog.app.dto.image.response.ImageResponseDto;
import hei.prog.app.service.ImageService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

  private final ImageService imageService;

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ImageResponseDto> save(
      @RequestParam("file") MultipartFile file,
      @NotBlank(message = "fileName is required") @RequestParam("fileName") String fileName,
      @NotBlank(message = "email is required")
          @Email(message = "email must be valid")
          @RequestParam("email")
          String email) {
    ImageResponseDto imageResponseDto = imageService.save(fileName, email, file);
    return new ResponseEntity<>(imageResponseDto, HttpStatus.CREATED);
  }
}
