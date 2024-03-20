package minihp.service;

import lombok.RequiredArgsConstructor;
import minihp.data.dto.CategoryDto;
import minihp.data.dto.ContentDto;
import minihp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDto> getCategoryList(CategoryDto categoryDto) {
        return categoryRepository.findAll().stream()
                .map(data -> {
                    new CategoryDto();
                    return CategoryDto.to(data);
                })
                .collect(Collectors.toList());
    }
}
