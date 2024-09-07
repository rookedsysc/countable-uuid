package org.rookedsysc.coutableuuid.uuidv1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/trigger")
public class UuidV1Controller {
    private final UuidV1Service uuidV1Service;

    @GetMapping
    public CompletableFuture<UUID> trigger() {
        return uuidV1Service.generateUuids(1000000);
    }
}
