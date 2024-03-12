package minihp.data.dto;

import lombok.Builder;
import minihp.data.entity.Category;

public class CategoryListRequestDto {
    private String homepageId;
    @Builder
    public CategoryListRequestDto(String homepageId) {
        this.homepageId = homepageId;
    }

}
