package com.martzie.bikerental.bike.controller.dto;

import lombok.Builder;

@Builder
public record BikeResponse(long id, String model, String manufacturer, String category, String size) {
}
