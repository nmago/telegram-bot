@file:Suppress("MatchingDeclarationName")

package eu.vendeli.tgbot.api.botactions

import eu.vendeli.tgbot.interfaces.ActionState
import eu.vendeli.tgbot.interfaces.SimpleAction
import eu.vendeli.tgbot.interfaces.TgAction
import eu.vendeli.tgbot.interfaces.features.OptionsFeature
import eu.vendeli.tgbot.types.internal.TgMethod
import eu.vendeli.tgbot.types.internal.options.SetWebhookOptions
import eu.vendeli.tgbot.utils.getReturnType

class SetWebhookAction(url: String) :
    SimpleAction<Boolean>,
    ActionState(),
    OptionsFeature<SetWebhookAction, SetWebhookOptions> {
    override val TgAction<Boolean>.method: TgMethod
        get() = TgMethod("setWebhook")
    override val TgAction<Boolean>.returnType: Class<Boolean>
        get() = getReturnType()
    override val OptionsFeature<SetWebhookAction, SetWebhookOptions>.options: SetWebhookOptions
        get() = SetWebhookOptions()

    init {
        parameters["url"] = url
    }
}

fun setWebhook(url: String) = SetWebhookAction(url)
