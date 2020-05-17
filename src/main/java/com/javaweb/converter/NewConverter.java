package com.javaweb.converter;

import com.javaweb.dto.NewDTO;
import com.javaweb.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

    public NewEntity toEntity(NewDTO dto){
        NewEntity result = new NewEntity();
        result.setTitle(dto.getTitle());
        result.setThumbnail(dto.getThumbnail());
        result.setShortDescription(dto.getShortDescription());
        result.setContent(dto.getContent());
        return result;
    }

    public NewEntity toEntity(NewEntity result, NewDTO dto){
        result.setTitle(dto.getTitle());
        result.setThumbnail(dto.getThumbnail());
        result.setShortDescription(dto.getShortDescription());
        result.setContent(dto.getContent());
        return result;
    }

    public NewDTO toDTO(NewEntity entity){
        NewDTO result = new NewDTO();
        result.setId(entity.getId());
        result.setTitle(entity.getTitle());
        result.setThumbnail(entity.getThumbnail());
        result.setShortDescription(entity.getShortDescription());
        result.setContent(entity.getContent());
        result.setCategoryCode(entity.getCategory().getCode());
        result.setCreatedDate(entity.getCreatedDate());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedDate(entity.getModifiedDate());
        result.setModifiedBy(entity.getModifiedBy());
        return result;
    }

}
