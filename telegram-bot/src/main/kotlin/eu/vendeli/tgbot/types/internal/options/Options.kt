package eu.vendeli.tgbot.types.internal.options

import eu.vendeli.tgbot.types.ParseMode

interface Options

interface OptionsInterface<O> : Options {
    @Suppress("UNCHECKED_CAST", "unused")
    private val thisAsO: O
        get() = this as O
}

interface OptionsParseMode : Options {
    var parseMode: ParseMode?
}

interface MediaSpoiler : Options {
    var hasSpoiler: Boolean?
}

interface FileOptions : Options {
    var fileName: String?
}

interface OptionsCommon : Options {
    var disableNotification: Boolean?
    var replyToMessageId: Long?
    var allowSendingWithoutReply: Boolean?
    var protectContent: Boolean?
    var messageThreadId: Long?
}
