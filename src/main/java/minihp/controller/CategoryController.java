package minihp.controller;

import lombok.RequiredArgsConstructor;
import minihp.data.dto.CategoryDto;
import minihp.data.dto.ResponseData;
import minihp.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/isu/management/category")
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<ResponseData> getDTO() {

        //categoryService.getCategoryList(CategoryDto.builder().build());

        // ResponseEntity를 사용하여 DTO, 상태 코드 함께 반환
        return ResponseEntity.ok(
                ResponseData.builder()
                        .status(200)
                        .message("Success")
                        .data(categoryService.getCategoryList(CategoryDto.builder().build()))
                        .build()
        );
    }
}
