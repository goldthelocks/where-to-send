package ph.goldthelocks.wheretosend

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application(
        val messageSender: QueueMessageSender,
        val catMessageAction: QueueMessageAction<Cat, Unit>,
        val dogMessageAction: QueueMessageAction<Dog, String>
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(Application::class.java)

    override fun run(vararg args: String?) {
        messageSender.send(Cat("Shiro", "Puspin"), null, catMessageAction)

        log.info(messageSender.send(Dog("Shiro", "Aspin", true), null, dogMessageAction))
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
