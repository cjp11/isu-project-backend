package minihp.controller;

import minihp.data.dto.MemberDto;
import minihp.data.dto.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    @GetMapping("/example")
    public ResponseEntity<ResponseData> example() {

        List<MemberDto> dto = new ArrayList<>();

        return ResponseEntity.ok(
                ResponseData.builder()
                        .status(500)
                        .message("Success")
                        .data(dto)
                        .build()
        );
    }
}
