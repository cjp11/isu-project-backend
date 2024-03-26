package minihp.controller;

import lombok.extern.slf4j.Slf4j;
import minihp.data.dto.RequestContentDto;
import minihp.data.dto.ResponseContentDto;
import minihp.data.dto.ResponseData;
import minihp.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
@Slf4j
public class ContentController {

    @Autowired
    ContentService contentService;

    @PostMapping("/list")
    public ResponseEntity<ResponseData> getContentList(@RequestBody RequestContentDto requestContentDto) {

        try {
            return ResponseEntity.ok(
                    ResponseData.builder()
                            .status(200)
                            .message("Success")
                            .data(contentService.getContentList(requestContentDto))
                            .build()
            );
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.ok(
                    ResponseData.builder()
                            .status(400)
                            .message(e.getMessage())
                            .data(null)
                            .build()
            );
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseData> writeContent(@RequestBody RequestContentDto requestContentDto) {
        try {
            contentService.saveContent(requestContentDto);
            return ResponseEntity.ok(
                    ResponseData.builder()
                            .status(200)
                            .message("Success")
                            .build()
            );
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.ok(
                    ResponseData.builder()
                            .status(400)
                            .message(e.getMessage())
                            .build()
            );
        }
    }

}