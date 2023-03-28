package com.martzie.bikerental.bike.controller.dto;

import java.util.List;

public record ModelRequest (String model, long manufacturerId, long categoryId, List<Long> sizeId) {
}
