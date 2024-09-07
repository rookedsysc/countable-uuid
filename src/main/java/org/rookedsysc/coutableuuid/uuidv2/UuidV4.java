package org.rookedsysc.coutableuuid.uuidv2;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UuidV4 {
    @Id
    @Builder.Default
    private UUID id = Generators.timeBasedEpochGenerator().generate();

    private String name;

    private String addr;

    private String introduce;
}
