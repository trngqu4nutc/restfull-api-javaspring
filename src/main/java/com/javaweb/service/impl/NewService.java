package com.javaweb.service.impl;

import com.javaweb.converter.NewConverter;
import com.javaweb.dto.NewDTO;
import com.javaweb.entity.CategoryEntity;
import com.javaweb.entity.NewEntity;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.repository.NewRepository;
import com.javaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewConverter newConverter;

    @Override
    @Transactional
    public NewDTO save(NewDTO newDTO) {
        NewEntity entity = new NewEntity();
        if (newDTO.getId() != null) {
            entity = newRepository.findOne(newDTO.getId());
            entity = newConverter.toEntity(entity, newDTO);
        } else {
            entity = newConverter.toEntity(newDTO);
        }
        CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        entity.setCategory(category);
        entity = newRepository.save(entity);
        return newConverter.toDTO(entity);
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            newRepository.delete(id);
        }
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity item:entities){
            results.add(newConverter.toDTO(item));
        }
        return results;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity item:entities){
            results.add(newConverter.toDTO(item));
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }
}
