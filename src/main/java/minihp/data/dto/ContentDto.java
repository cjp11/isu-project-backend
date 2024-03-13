package minihp.data.dto;

import lombok.*;
import minihp.data.entity.Content;
import minihp.data.entity.ContentFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class ContentDto {

    private Long id;
    private Long categoryId;
    private Long memberId;
    private String title;
    private String text;
    private LocalDateTime createDatetime;
    private LocalDateTime updateDatetime;
    private Long viewCount;
    private String deleteYn;

    private List<ContentFile> contentFile = new ArrayList<>();


    public static ContentDto toDto(Content content) {
        return ContentDto.builder()
                .id(content.getId())
                .categoryId(content.getCategory().getId())
                .memberId(content.getMember().getId())
                .title(content.getTitle())
                .text(content.getText())
                .createDatetime(content.getCreateDatetime())
                .updateDatetime(content.getUpdateDatetime())
                .viewCount(content.getViewCount())
                .deleteYn(content.getDeleteYn())
                .build();
    }
}
