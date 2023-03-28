package com.martzie.bikerental.bike.controller.dto;

import java.util.List;

public record ModelResponse(long id, String model, String manufacturer, String category, List<String> sizes) {
}
