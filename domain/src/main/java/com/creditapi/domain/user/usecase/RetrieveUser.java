package com.creditapi.domain.user.usecase;

import com.creditapi.domain.common.usecase.UseCase;

public record RetrieveUser(
        Long userId
) implements UseCase {
}
