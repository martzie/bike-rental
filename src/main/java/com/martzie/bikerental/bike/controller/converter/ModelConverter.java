package com.martzie.bikerental.bike.controller.converter;

import com.martzie.bikerental.bike.controller.dto.ModelResponse;
import com.martzie.bikerental.bike.model.Model;
import com.martzie.bikerental.bike.model.Size;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelConverter {

    public static ModelResponse mapToModelResponse(Model model){
        String manufacturer = model.getManufacturer().getManufacturer();
        String category = model.getCategory().getCategory();
        List<String> sizes = model.getSizes().stream()
                .map(Size::getSize)
                .collect(Collectors.toList());
        return new ModelResponse(model.getId(), model.getModel(), manufacturer, category, sizes);
    }

    public static List<ModelResponse> mapToModelResponses(List<Model> models){
        return models.stream()
                .map(ModelConverter::mapToModelResponse)
                .collect(Collectors.toList());
    }
}
