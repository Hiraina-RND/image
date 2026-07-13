package hei.prog.app.s3;

import hei.prog.app.PojaGenerated;
import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@PojaGenerated
@Slf4j
@Service
@RequiredArgsConstructor
public class S3Service {

  private final S3Client s3Client;

  @Value("${aws.s3.bucket}")
  private String bucketName;

  public void upload(String key, InputStream inputStream, String contentType) throws IOException {
    PutObjectRequest putObjectRequest =
        PutObjectRequest.builder().bucket(bucketName).key(key).contentType(contentType).build();

    byte[] bytes = inputStream.readAllBytes();
    s3Client.putObject(putObjectRequest, RequestBody.fromBytes(bytes));
    log.info("Successfully uploaded {} to bucket {}", key, bucketName);
  }
}
