package minihp.service;

import minihp.data.dto.ContentDto;
import minihp.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public List<ContentDto> getContentList(ContentDto contentDto) {
        return contentRepository.findAll().stream()
                .map(data -> {
                    new ContentDto();
                    return ContentDto.toDto(data);
                })
                .collect(Collectors.toList());
    }
}
