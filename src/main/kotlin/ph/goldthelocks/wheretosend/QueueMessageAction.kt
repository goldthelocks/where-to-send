package ph.goldthelocks.wheretosend

import java.util.Properties

interface QueueMessageAction<T, R> {

    fun properties(): QueueMessageActionProperties

    fun doOnRabbit(message: T, headers: Properties?): R?

    fun doOnHornetQ(message: T, headers: Properties?): R?

}