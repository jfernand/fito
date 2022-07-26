package es.casaroja.fito

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates
import java.util.Optional
import jakarta.inject.Singleton

@Singleton
class CancelIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(Predicates.intentName("AMAZON.CancelIntent"))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        return input.responseBuilder
            .withSpeech("Goodbye")
            .withSimpleCard("HelloWorld", "Goodbye")
            .withShouldEndSession(true)
            .build()
    }
}
