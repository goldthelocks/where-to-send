package ph.goldthelocks.wheretosend

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.Properties

@Service
class CatMessageAction : QueueMessageAction<Cat, Unit> {

    private val log = LoggerFactory.getLogger(CatMessageAction::class.java)

    override fun properties(): QueueMessageActionProperties {
        return QueueMessageActionProperties(
                isRabbitMqEnabled = true,
                rabbitMqQueueName = "cat_queue"
        )
    }

    override fun doOnRabbit(message: Cat, headers: Properties?) {
        log.info("Preparing for rabbit! {}", message)
    }

    override fun doOnHornetQ(message: Cat, headers: Properties?) {
        log.info("Preparing for hornet! {}", message)
    }
}

data class Cat(
        val name: String,
        val breed: String
)