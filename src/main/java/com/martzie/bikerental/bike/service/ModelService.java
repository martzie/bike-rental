package com.martzie.bikerental.bike.service;

import com.martzie.bikerental.bike.controller.converter.ModelConverter;
import com.martzie.bikerental.bike.controller.dto.ModelRequest;
import com.martzie.bikerental.bike.controller.dto.ModelResponse;
import com.martzie.bikerental.bike.exception.CategoryNotFoundException;
import com.martzie.bikerental.bike.exception.ManufacturerNotFoundException;
import com.martzie.bikerental.bike.exception.ModelNotFoundException;
import com.martzie.bikerental.bike.model.Category;
import com.martzie.bikerental.bike.model.Manufacturer;
import com.martzie.bikerental.bike.model.Model;
import com.martzie.bikerental.bike.model.Size;
import com.martzie.bikerental.bike.repository.CategoryRepository;
import com.martzie.bikerental.bike.repository.ManufacturerRepository;
import com.martzie.bikerental.bike.repository.ModelRepository;
import com.martzie.bikerental.bike.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CategoryRepository categoryRepository;
    private final SizeRepository sizeRepository;

    @Transactional
    public ModelResponse addModel(ModelRequest request) {
        Manufacturer manufacturer = getManufacturer(request);
        Category category = getCategory(request);
        List<Size> sizes = getSizes(request);
        Model newModel = Model.builder()
                .model(request.model())
                .manufacturer(manufacturer)
                .category(category)
                .sizes(sizes)
                .build();
        return ModelConverter.mapToModelResponse(modelRepository.save(newModel));
    }

    public ModelResponse getModelById(long id) {
        Model model = findById(id);
        return ModelConverter.mapToModelResponse(model);
    }

    public List<ModelResponse> getAllBikes(){
        List<Model> allModels = modelRepository.findAll();
        return ModelConverter.mapToModelResponses(allModels);
    }

    public void removeModel(long id) {
        Model modelToDelete = findById(id);
        modelRepository.delete(modelToDelete);
    }

    @Transactional
    public ModelResponse updateModel(long id, ModelRequest request) {
        Model persistentModel = findById(id);
        persistentModel.setModel(request.model());
        persistentModel.setManufacturer(getManufacturer(request));
        persistentModel.setCategory(getCategory(request));
        persistentModel.setSizes(getSizes(request));
        modelRepository.save(persistentModel);
        return ModelConverter.mapToModelResponse(persistentModel);
    }

    private Model findById(long id) {
        return modelRepository.findById(id).orElseThrow(() -> new ModelNotFoundException(id));
    }

    private Manufacturer getManufacturer(ModelRequest request) {
        return manufacturerRepository.findById(request.manufacturerId())
                .orElseThrow(() -> new ManufacturerNotFoundException(request.manufacturerId()));
    }

    private Category getCategory(ModelRequest request) {
        return categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(request.categoryId()));
    }

    private List<Size> getSizes(ModelRequest request) {
        return sizeRepository.findByIdIn(request.sizeId());
    }
}
