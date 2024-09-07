package org.rookedsysc.coutableuuid.uuidv2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class UuidV4Service {
    private final UuidV4Repository uuidV2Repository;

    @Async("taskExecutor2")
    public CompletableFuture<UUID> generateUuids(int totalCount) {
        int batchSize = 10000;  // 배치 단위로 처리하여 메모리 부담을 줄임
        UUID targetId = null;
        int minCount = 450000; // 45만 번째 생성
        int maxCount = 550000; // 55만 번째 생성

        for (int i = 0; i < totalCount; i += batchSize) {
            List<UuidV4> uuidList = new ArrayList<>(batchSize);

            // 배치 생성
            for (int j = i; j < i + batchSize && j < totalCount; j++) {
                UuidV4 uuidEntity = UuidV4.builder()
                    .name("name" + j)
                    .addr("addr" + j)
                    .introduce("introduce" + j)
                    .build();

                uuidList.add(uuidEntity);

                // 450만 ~ 550만 사이에서 하나의 UUID를 추출
                if (j >= minCount && j <= maxCount && targetId == null) {
                    targetId = uuidEntity.getId();
                }
            }

            // 배치 저장으로 성능 최적화
            uuidV2Repository.saveAll(uuidList);
        }

        log.info("targetId: {}", targetId);

        return CompletableFuture.completedFuture(targetId);
    }

}
