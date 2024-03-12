package minihp.controller;

import minihp.data.dto.CategoryDto;
import minihp.data.dto.MemberDto;
import minihp.data.dto.ResponseData;
import minihp.data.entity.HomePage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    @GetMapping("/isu/management/category/list")
    public ResponseEntity<ResponseData> example() {
        List<CategoryDto> dto = new ArrayList<>();

        return ResponseEntity.ok(
                ResponseData.builder()
                        .status(500)
                        .message("Success")
                        .data(dto)
                        .build()
        );
    }

}
