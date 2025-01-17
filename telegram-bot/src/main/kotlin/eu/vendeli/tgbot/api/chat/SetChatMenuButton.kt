@file:Suppress("MatchingDeclarationName")

package eu.vendeli.tgbot.api.chat

import eu.vendeli.tgbot.interfaces.Action
import eu.vendeli.tgbot.interfaces.ActionState
import eu.vendeli.tgbot.interfaces.TgAction
import eu.vendeli.tgbot.types.internal.TgMethod
import eu.vendeli.tgbot.types.keyboard.MenuButton
import eu.vendeli.tgbot.utils.getReturnType

class SetChatMenuButtonAction(menuButton: MenuButton) : Action<Boolean>, ActionState() {
    override val TgAction<Boolean>.method: TgMethod
        get() = TgMethod("setChatMenuButton")
    override val TgAction<Boolean>.returnType: Class<Boolean>
        get() = getReturnType()

    init {
        parameters["menu_button"] = menuButton
    }
}

fun setChatMenuButton(menuButton: MenuButton) = SetChatMenuButtonAction(menuButton)
