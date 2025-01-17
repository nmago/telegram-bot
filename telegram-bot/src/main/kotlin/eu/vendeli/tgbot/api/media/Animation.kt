@file:Suppress("MatchingDeclarationName")

package eu.vendeli.tgbot.api.media

import eu.vendeli.tgbot.interfaces.ActionState
import eu.vendeli.tgbot.interfaces.MediaAction
import eu.vendeli.tgbot.interfaces.TgAction
import eu.vendeli.tgbot.interfaces.features.CaptionFeature
import eu.vendeli.tgbot.interfaces.features.MarkupFeature
import eu.vendeli.tgbot.interfaces.features.OptionsFeature
import eu.vendeli.tgbot.types.Message
import eu.vendeli.tgbot.types.internal.ImplicitFile
import eu.vendeli.tgbot.types.internal.MediaContentType
import eu.vendeli.tgbot.types.internal.TgMethod
import eu.vendeli.tgbot.types.internal.options.AnimationOptions
import eu.vendeli.tgbot.utils.builders.EntitiesContextBuilder
import eu.vendeli.tgbot.utils.getReturnType
import java.io.File

class SendAnimationAction(private val animation: ImplicitFile<*>) :
    MediaAction<Message>,
    ActionState(),
    OptionsFeature<SendAnimationAction, AnimationOptions>,
    MarkupFeature<SendAnimationAction>,
    EntitiesContextBuilder,
    CaptionFeature<SendAnimationAction> {
    override val TgAction<Message>.method: TgMethod
        get() = TgMethod("sendAnimation")
    override val TgAction<Message>.returnType: Class<Message>
        get() = getReturnType()
    override val OptionsFeature<SendAnimationAction, AnimationOptions>.options: AnimationOptions
        get() = AnimationOptions()
    override val EntitiesContextBuilder.entitiesField: String
        get() = "caption_entities"

    override val MediaAction<Message>.defaultType: MediaContentType
        get() = MediaContentType.ImageGif
    override val MediaAction<Message>.media: ImplicitFile<*>
        get() = animation
    override val MediaAction<Message>.dataField: String
        get() = "animation"
}

fun animation(block: () -> String) = SendAnimationAction(ImplicitFile.FromString(block()))

fun animation(ba: ByteArray) = SendAnimationAction(ImplicitFile.FromByteArray(ba))

fun animation(file: File) = SendAnimationAction(ImplicitFile.FromFile(file))
