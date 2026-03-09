package com.example.product.consumer

import com.example.product.service.ProductService
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class UserManagementConsumer(
   private val productService: ProductService
) {
    val log = LoggerFactory.getLogger(this::class.java)
    @KafkaListener(
        containerFactory = "kafkaListenerContainerFactory",
        id = "BATCH16_DELETE_USER_PRODUCT",
        topics = ["BATCH16_DELETE_USER_PRODUCT"],
        groupId = "BATCH16_DELETE_USER_PRODUCT"
    )
    @KafkaHandler
    fun deleteUserProductHandler(message: Int){
        log.info("Received message: $message of topic BATCH16_DELETE_USER_PRODUCT")
        productService.deleteProduct(message)
    }
}