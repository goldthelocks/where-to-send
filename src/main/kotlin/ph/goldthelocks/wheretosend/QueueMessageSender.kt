package ph.goldthelocks.wheretosend

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.Properties

@Service
class QueueMessageSender {

    private val log = LoggerFactory.getLogger(QueueMessageSender::class.java)

    fun <T, R> send(message: T, headers: Properties?, messageAction: QueueMessageAction<T, R>): R? {
        return if (messageAction.properties().isRabbitMqEnabled) {
            log.info("Sending message to RabbitMq. queueName: {}", messageAction.properties().rabbitMqQueueName)
            messageAction.doOnRabbit(message, headers)
        } else {
            log.info("Sending message to HornetQ. queueName: {}", messageAction.properties().rabbitMqQueueName)
            messageAction.doOnHornetQ(message, headers)
        }
    }

}