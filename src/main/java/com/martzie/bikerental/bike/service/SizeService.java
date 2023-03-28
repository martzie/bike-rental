package com.martzie.bikerental.bike.service;

import com.martzie.bikerental.bike.controller.converter.SizeConverter;
import com.martzie.bikerental.bike.controller.dto.SizeRequest;
import com.martzie.bikerental.bike.controller.dto.SizeResponse;
import com.martzie.bikerental.bike.exception.SizeAlreadyExistsException;
import com.martzie.bikerental.bike.exception.SizeNotFoundException;
import com.martzie.bikerental.bike.model.Size;
import com.martzie.bikerental.bike.repository.SizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeService {

    private final SizeRepository sizeRepository;

    @Transactional
    public SizeResponse addSize(SizeRequest request) {
        checkSize(request.size());
        Size persistentSize = sizeRepository.save(SizeConverter.mapToSizeEntity(request));
        return SizeConverter.mapToSizeResponse(persistentSize);
    }

    private void checkSize(String size) {
        if (sizeRepository.existsBySizeIgnoreCase(size)) {
            throw new SizeAlreadyExistsException();
        }
    }

    public SizeResponse getSizeById(long id){
        Size size = findById(id);
        return SizeConverter.mapToSizeResponse(size);
    }

    private Size findById(long id) {
        return sizeRepository.findById(id).orElseThrow(() -> new SizeNotFoundException(id));
    }

    public List<SizeResponse> getAllSizes() {
        return SizeConverter.mapToSizeResponses(sizeRepository.findAll());
    }

    public void removeSize(long id) {
        Size sizeToRemove = findById(id);
        sizeRepository.delete(sizeToRemove);
    }
}
