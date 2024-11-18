package com.vsu.by.customermicro.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessages {
    public static final String RESOURCE_NOT_FOUND_MESSAGE = "%s with id %d does not exist";
    public static final String DUPLICATE_RESOURCE_MESSAGE = "%s with this %s already exists";
}
