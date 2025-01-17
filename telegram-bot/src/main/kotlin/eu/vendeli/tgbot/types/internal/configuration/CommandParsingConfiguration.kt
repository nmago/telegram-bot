package eu.vendeli.tgbot.types.internal.configuration

/**
 * Class for configuration of command parsing parameters
 *
 * @property commandDelimiter Separator between the command and parameters.
 * @property parametersDelimiter Separator between the parameters
 * @property parameterValueDelimiter Separator between key and value of parameter
 * @property restrictSpacesInCommands If this flag is enabled, if there is a space in the command,
 * parser will treat this as the end of the command and start parsing parameters
 */
data class CommandParsingConfiguration(
    var commandDelimiter: Char = '?',
    var parametersDelimiter: Char = '&',
    var parameterValueDelimiter: Char = '=',
    var restrictSpacesInCommands: Boolean = true,
)
