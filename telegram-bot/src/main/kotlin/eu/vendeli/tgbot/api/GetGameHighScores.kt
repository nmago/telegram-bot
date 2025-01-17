@file:Suppress("MatchingDeclarationName")

package eu.vendeli.tgbot.api

import eu.vendeli.tgbot.interfaces.Action
import eu.vendeli.tgbot.interfaces.ActionState
import eu.vendeli.tgbot.interfaces.InlineMode
import eu.vendeli.tgbot.interfaces.TgAction
import eu.vendeli.tgbot.types.game.GameHighScore
import eu.vendeli.tgbot.types.internal.TgMethod
import eu.vendeli.tgbot.utils.getReturnType

class GetGameHighScoresAction : Action<GameHighScore>, ActionState, InlineMode<GameHighScore> {
    override val TgAction<GameHighScore>.method: TgMethod
        get() = TgMethod("getGameHighScores")
    override val TgAction<GameHighScore>.returnType: Class<GameHighScore>
        get() = getReturnType()

    constructor(userId: Long, messageId: Long) {
        parameters["user_id"] = userId
        parameters["message_id"] = messageId
    }

    constructor(userId: Long) {
        parameters["user_id"] = userId
    }
}

fun getGameHighScores(userId: Long, messageId: Long) = GetGameHighScoresAction(userId, messageId)
fun getGameHighScores(userId: Long) = GetGameHighScoresAction(userId)
