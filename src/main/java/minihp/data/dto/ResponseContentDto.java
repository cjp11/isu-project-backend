package minihp.data.dto;

import lombok.*;
import minihp.data.entity.Category;
import minihp.data.entity.Content;
import minihp.data.entity.ContentFile;
import minihp.data.entity.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseContentDto {

    private Long id;
    private Long categoryId;
    private String categoryName;
    private Long memberId;
    private String nickname;
    private String title;
    private String text;
    private LocalDateTime createDatetime;
    private LocalDateTime updateDatetime;
    private Long viewCount;
    private String deleteYn;

    private List<ContentFile> contentFile = new ArrayList<>();

    public static ResponseContentDto toDto(Content content) {
        return ResponseContentDto.builder()
                .id(content.getId())
                .categoryId(content.getCategory().getId())
                .categoryName(content.getCategory().getName())
                .memberId(content.getMember().getId())
                .nickname(content.getMember().getNickname())
                .title(content.getTitle())
                .text(content.getText())
                .createDatetime(content.getCreateDatetime())
                .updateDatetime(content.getUpdateDatetime())
                .viewCount(content.getViewCount())
                .deleteYn(content.getDeleteYn())
                .build();
    }


}
