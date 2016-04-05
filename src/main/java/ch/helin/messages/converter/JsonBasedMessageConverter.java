package ch.helin.messages.converter;

import ch.helin.messages.commons.AssertUtils;
import ch.helin.messages.dto.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json Specific MessageConverter
 *
 * @author Kirusanth Poopalasingam ( pkirusanth@gmail.com )
 */
public class JsonBasedMessageConverter implements MessageConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonBasedMessageConverter.class);

    @Override
    public Message parseStringToMessage(String messageAsJson) throws CouldNotParseJsonException {
        try {

            return parseMessageWithoutCare(messageAsJson);

        } catch (RuntimeException catchedException) {

            LOGGER.warn("Failed to parse following json message:\n {}", messageAsJson);
            throw new CouldNotParseJsonException("Json message parsing failed", catchedException);

        }
    }

    private Message parseMessageWithoutCare(String messageAsJson) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Message.class, new MessageClassAdapter())
                .create();

        Message parsedMessage = gson.fromJson(messageAsJson, Message.class);
        AssertUtils.throwExceptionIfNull(parsedMessage);

        return parsedMessage;
    }

    @Override
    public String parseMessageToString(Message message) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        return gson.toJson(message);
    }
}
