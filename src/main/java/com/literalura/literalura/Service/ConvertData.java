package com.literalura.literalura.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertData implements IConvertData{
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T ObtainData(String json, Class<T> classeGenerica) {
        try {
            return mapper.readValue(json, classeGenerica);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> ObtainList(String json, Class<T> classeGenerica) {
        CollectionType list = mapper.getTypeFactory()
                .constructCollectionType(List.class, classeGenerica);
        try {
            return mapper.readValue(json,list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

