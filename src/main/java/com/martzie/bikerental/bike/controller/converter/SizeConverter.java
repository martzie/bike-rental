package com.martzie.bikerental.bike.controller.converter;

import com.martzie.bikerental.bike.controller.dto.SizeRequest;
import com.martzie.bikerental.bike.controller.dto.SizeResponse;
import com.martzie.bikerental.bike.model.Size;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SizeConverter {

    public static Size mapToSizeEntity(SizeRequest request){
        Size size = new Size();
        size.setSize(request.size());
        return size;
    }

    public static SizeResponse mapToSizeResponse(Size persistentSize) {
        return new SizeResponse(persistentSize.getId(), persistentSize.getSize());
    }

    public static List<SizeResponse> mapToSizeResponses(List<Size> sizes) {
        return sizes.stream()
                .map(SizeConverter::mapToSizeResponse)
                .collect(Collectors.toList());
    }
}
