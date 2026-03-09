package com.example.product.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@Configuration
class KafkaConsumerConfig(
    @Value("\${kafka.bootstrap-servers}") private val bootstrapServers: String
) {
    @Bean
    fun consumerFactory(): ConsumerFactory<String, Any> {
        val props = mapOf<String, Any>(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
            ConsumerConfig.GROUP_ID_CONFIG to "BATCH16_PRODUCT_SERVICE",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java
        )
        return DefaultKafkaConsumerFactory(props)
    }

    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, Any>{
        val factory = ConcurrentKafkaListenerContainerFactory<String, Any>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}