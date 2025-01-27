package ru.alexeykuznetsov.spbgti.sdlab.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArrayUnitDataConverter implements AttributeConverter<List<Integer>, String> {

  private final ObjectMapper objectMapper;

  @Override
  public String convertToDatabaseColumn(List<Integer> attribute) {
    if (attribute == null) {
      return null;
    }
    try {
      return objectMapper.writeValueAsString(attribute);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Integer> convertToEntityAttribute(String dbData) {
    try {
      if(dbData == null) {
        return null;
      }
      return Arrays.asList(objectMapper.readValue(dbData, Integer[].class));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
