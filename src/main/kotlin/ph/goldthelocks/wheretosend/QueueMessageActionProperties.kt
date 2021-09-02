package ph.goldthelocks.wheretosend

data class QueueMessageActionProperties(
        val isRabbitMqEnabled: Boolean,
        val rabbitMqQueueName: String
)