package org.rookedsysc.coutableuuid.uuidv2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v4/trigger")
public class UuidV4Controller {
    private final UuidV4Service uuidV2Service;

    @GetMapping
    public void trigger() {
        uuidV2Service.generateUuids(1000000);
    }

}
