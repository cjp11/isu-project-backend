package minihp.service;

import lombok.RequiredArgsConstructor;
import minihp.data.dto.ResponseData;
import minihp.data.entity.Category;
import minihp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


}
