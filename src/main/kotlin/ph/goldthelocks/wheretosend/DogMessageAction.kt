package ph.goldthelocks.wheretosend

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.Properties

@Service
class DogMessageAction : QueueMessageAction<Dog, String> {

    private val log = LoggerFactory.getLogger(DogMessageAction::class.java)

    override fun properties(): QueueMessageActionProperties {
        return QueueMessageActionProperties(
                isRabbitMqEnabled = false,
                rabbitMqQueueName = "dog_queue"
        )
    }

    override fun doOnRabbit(message: Dog, headers: Properties?): String? {
        log.info("I'm doing something for rabbit! {}", message)
        return "I'm at rabbit!"
    }

    override fun doOnHornetQ(message: Dog, headers: Properties?): String? {
        log.info("I'm doing something for hornet! {}", message)
        return "I'm at hornet!"
    }
}

data class Dog(
        val name: String,
        val breed: String,
        val isGuard: Boolean
)