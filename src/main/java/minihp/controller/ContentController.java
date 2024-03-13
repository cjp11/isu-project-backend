package minihp.controller;

import lombok.extern.slf4j.Slf4j;
import minihp.data.dto.ContentDto;
import minihp.data.dto.ResponseData;
import minihp.service.ContentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/content")
@Slf4j
public class ContentController {

    @Autowired
    ContentService contentService;

    @PostMapping("/list")
    public ResponseEntity<ResponseData> test2() {
        log.info("호출");
        contentService.getContentList(ContentDto.builder().build());

        return ResponseEntity.ok(
                ResponseData.builder()
                        .status(200)
                        .message("Success")
                        .data(contentService.getContentList(ContentDto.builder().build()))
                        .build()
        );
    }

}