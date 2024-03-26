package minihp.service;

import minihp.data.dto.RequestContentDto;
import minihp.data.dto.ResponseContentDto;
import minihp.data.entity.Category;
import minihp.data.entity.Member;
import minihp.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public List<ResponseContentDto> getContentList(RequestContentDto requestContentDto) {
        Member member = Member.builder()
                .id(requestContentDto.getMemberId())
                .build();

        Category category = Category.builder()
                .id(requestContentDto.getCategoryId())
                .build();

        return contentRepository.findByMemberIdAndCategoryId(member.getId(), category.getId()).stream()
                .map(data -> {
                    new ResponseContentDto();
                    return ResponseContentDto.toDto(data);
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveContent(RequestContentDto requestContentDto) {
        Member member = Member.builder()
                .id(requestContentDto.getMemberId())
                .build();

        Category category = Category.builder()
                .id(requestContentDto.getCategoryId())
                .build();

        System.out.println(requestContentDto);
        contentRepository.save(RequestContentDto.toEntity(requestContentDto, member, category));

    }

}
