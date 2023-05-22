package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.mapper.db.CategoryMapper;
import ru.kpfu.itis.model.dto.CategoryDto;
import ru.kpfu.itis.model.entity.db.CategoryEntity;
import ru.kpfu.itis.repository.db.datajpa.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<CategoryEntity> getAllCategory() {
        return categoryRepo.findAll();
    }

    public List<CategoryEntity> getAllCategoryById(List<Long> ids) {
        return categoryRepo.findAllById(ids);
    }
}
