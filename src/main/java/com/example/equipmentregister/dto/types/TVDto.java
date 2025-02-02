package com.example.equipmentregister.dto.types;

import com.example.equipmentregister.dto.TVModelDto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Вид телевизора")
public class TVDto extends BaseTypeDto{
    private List<TVModelDto> tvModelDtoList;
    public TVDto() {
    }

    public List<TVModelDto> getTvModelDtoList() {
        return tvModelDtoList;
    }

    public void setTvModelDtoList(List<TVModelDto> tvModelDtoList) {
        this.tvModelDtoList = tvModelDtoList;
    }
}
