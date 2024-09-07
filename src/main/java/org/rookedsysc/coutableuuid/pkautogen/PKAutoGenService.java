package org.rookedsysc.coutableuuid.pkautogen;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rookedsysc.coutableuuid.uuidv1.UuidV1;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PKAutoGenService {
    private final PkAutoGenRepository pkAutoGenRepository;

    @Async("taskExecutor3")
    public void generateUuids(int totalCount) {
        int batchSize = 10000;  // 배치 단위로 처리하여 메모리 부담을 줄임

        for (int i = 0; i < totalCount; i += batchSize) {
            List<PKAutoGen> entities = new ArrayList<>(batchSize);

            // 배치 생성
            for (int j = i; j < i + batchSize && j < totalCount; j++) {
                PKAutoGen uuidEntity = PKAutoGen.builder()
                    .name("name" + j)
                    .addr("addr" + j)
                    .introduce("introduce" + j)
                    .build();

                entities.add(uuidEntity);
            }

            // 배치 저장으로 성능 최적화
            pkAutoGenRepository.saveAll(entities);
        }
    }
}
