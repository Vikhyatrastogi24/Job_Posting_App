package com.Titan.throne.springBoot_rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;
//basically created this using chatgpt to convert data of post tech stack into JSON type as MYsql does not directly converts the data in json it will give varbinary (BLOB )

 @Converter
    public class StringListConverter implements AttributeConverter<List<String>, String> {

        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public String convertToDatabaseColumn(List<String> attribute) {
            try {
                return objectMapper.writeValueAsString(attribute);
            } catch (Exception e) {
                throw new RuntimeException("Could not convert list to JSON string.", e);
            }
        }

        @Override
        public List<String> convertToEntityAttribute(String dbData) {
            try {
                return objectMapper.readValue(dbData, new TypeReference<List<String>>() {});
            } catch (Exception e) {
                throw new RuntimeException("Could not convert JSON string to list.", e);
            }
        }
    }


