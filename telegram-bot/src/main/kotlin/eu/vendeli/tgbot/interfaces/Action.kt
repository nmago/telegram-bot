package eu.vendeli.tgbot.interfaces

import eu.vendeli.tgbot.TelegramBot
import eu.vendeli.tgbot.types.User
import eu.vendeli.tgbot.types.internal.Response
import eu.vendeli.tgbot.utils.makeRequestAsync
import eu.vendeli.tgbot.utils.makeSilentRequest
import kotlinx.coroutines.Deferred

/**
 * Action, see [Actions article](https://github.com/vendelieu/telegram-bot/wiki/Actions)
 *
 * @param ReturnType response type.
 */
interface Action<ReturnType> : TgAction<ReturnType>, IActionState {
    /**
     * Make a request for action.
     *
     * @param to Recipient
     * @param via Instance of the bot through which the request will be made.
     */
    suspend fun send(to: String, via: TelegramBot) {
        parameters["chat_id"] = to
        via.makeSilentRequest(method, parameters)
    }

    /**
     * Make a request for action.
     *
     * @param to Recipient
     * @param via Instance of the bot through which the request will be made.
     */
    suspend fun send(to: Long, via: TelegramBot) {
        parameters["chat_id"] = to
        via.makeSilentRequest(method, parameters)
    }

    /**
     * Make a request for action.
     *
     * @param to Recipient
     * @param via Instance of the bot through which the request will be made.
     */
    suspend fun send(to: User, via: TelegramBot) {
        parameters["chat_id"] = to.id
        via.makeSilentRequest(method, parameters)
    }

    /**
     * Make a request for action returning its [Response].
     *
     * @param to Recipient
     * @param via Instance of the bot through which the request will be made.
     */
    suspend fun sendAsync(
        to: Long,
        via: TelegramBot,
    ): Deferred<Response<out ReturnType>> {
        parameters["chat_id"] = to
        return via.makeRequestAsync(method, parameters, returnType, wrappedDataType)
    }

    /**
     * Make a request for action returning its [Response].
     *
     * @param to Recipient
     * @param via Instance of the bot through which the request will be made.
     */
    suspend fun sendAsync(
        to: User,
        via: TelegramBot,
    ): Deferred<Response<out ReturnType>> {
        parameters["chat_id"] = to.id
        return via.makeRequestAsync(method, parameters, returnType, wrappedDataType)
    }

    /**
     * Make a request for action returning its [Response].
     *
     * @param to Recipient
     * @param via Instance of the bot through which the request will be made.
     */
    suspend fun sendAsync(
        to: String,
        via: TelegramBot,
    ): Deferred<Response<out ReturnType>> {
        parameters["chat_id"] = to
        return via.makeRequestAsync(method, parameters, returnType, wrappedDataType)
    }
}
