package minihp.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minihp.data.entity.Category;
import minihp.data.entity.Content;
import minihp.data.entity.Member;

import javax.xml.catalog.Catalog;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestContentDto {

    private Long id;
    private Long memberId;
    private Long categoryId;
    private String title;
    private String text;
    private String searchText;
    private String SearchType;

    public static Content toEntity(RequestContentDto requestContentDto, Member member, Category category) {
        return Content.builder()
                .member(member)
                .category(category)
                .title(requestContentDto.getTitle())
                .text(requestContentDto.getText())
                .build();

        }
}
