package org.rookedsysc.coutableuuid.pkautogen;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auto-gen/trigger")
public class PKAutoGenController {
    private final PKAutoGenService pkAutoGenService;
    @GetMapping
    public void trigger() {
        pkAutoGenService.generateUuids(1000000);
    }
}
