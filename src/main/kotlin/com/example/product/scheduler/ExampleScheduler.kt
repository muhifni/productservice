package com.example.product.scheduler

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ExampleScheduler {

    private val log = LoggerFactory.getLogger(ExampleScheduler::class.java)

    // Jalan setiap 5 detik
    @Scheduled(fixedRate = 5000)
    fun schedulerForEvery5Sec() {
        log.info("Scheduler running every 5 seconds - ${System.currentTimeMillis()}")
    }
}