package minihp.data.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minihp.data.entity.Category;


import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private LocalDateTime createDatetime;
    private String deleteYn;

    /*
    public CategoryDto(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.createDatetime = entity.getCreateDatetime();
        this.deleteYn = entity.getDeleteYn();

    }*/

    public static CategoryDto to(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .createDatetime(category.getCreateDatetime())
                .deleteYn(category.getDeleteYn())
                .build();
    }

}

