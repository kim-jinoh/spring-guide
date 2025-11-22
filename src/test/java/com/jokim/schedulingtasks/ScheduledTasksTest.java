package com.jokim.schedulingtasks;

import org.awaitility.Durations;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@SpringBootTest
public class ScheduledTasksTest {
    
    // @MockitoSpyBean
    // ScheduledTasks tasks;

    // @Test
    // public void reportCurrentTime() {
		// await().atMost(Durations.TEN_SECONDS).untilAsserted(() -> {
		// 	verify(tasks, atLeast(2)).reportCurrentTime();
		// });
    // }
}
