@file:Suppress("MatchingDeclarationName")
package eu.vendeli.tgbot.api.media

import eu.vendeli.tgbot.interfaces.MediaAction
import eu.vendeli.tgbot.interfaces.features.CaptionAble
import eu.vendeli.tgbot.interfaces.features.CaptionFeature
import eu.vendeli.tgbot.interfaces.features.MarkupAble
import eu.vendeli.tgbot.interfaces.features.MarkupFeature
import eu.vendeli.tgbot.interfaces.features.OptionAble
import eu.vendeli.tgbot.interfaces.features.OptionsFeature
import eu.vendeli.tgbot.types.Message
import eu.vendeli.tgbot.types.internal.ImplicitFile
import eu.vendeli.tgbot.types.internal.MediaContentType
import eu.vendeli.tgbot.types.internal.TgMethod
import eu.vendeli.tgbot.types.internal.options.AnimationOptions
import java.io.File

class SendAnimationAction(private val animation: ImplicitFile<*>) :
    MediaAction<Message>,
    OptionAble,
    MarkupAble,
    CaptionAble,
    OptionsFeature<SendAnimationAction, AnimationOptions>,
    MarkupFeature<SendAnimationAction>,
    CaptionFeature<SendAnimationAction> {
    override val method: TgMethod = TgMethod("sendAnimation")
    override var options = AnimationOptions()
    override val parameters: MutableMap<String, Any?> = mutableMapOf()

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
