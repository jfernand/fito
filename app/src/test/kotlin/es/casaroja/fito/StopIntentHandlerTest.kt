package es.casaroja.fito

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Intent
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.RequestEnvelope
import com.amazon.ask.model.ui.SimpleCard
import com.amazon.ask.model.ui.SsmlOutputSpeech
import es.casaroja.ask.StopIntentHandler
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class StopIntentHandlerTest {

    @Inject
    lateinit var handler: StopIntentHandler

    @Test
    fun testStopIntentHandler() {
        val input = HandlerInput.builder()
            .withRequestEnvelope(
                RequestEnvelope.builder()
                    .withRequest(
                        IntentRequest.builder()
                            .withIntent(
                                Intent.builder()
                                    .withName("AMAZON.StopIntent")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            ).build()
        Assertions.assertTrue(handler.canHandle(input))
        val responseOptional = handler.handle(input)
        Assertions.assertTrue(responseOptional.isPresent)
        val response = responseOptional.get()
        Assertions.assertTrue(response.outputSpeech is SsmlOutputSpeech)
        val speechText = "Goodbye"
        val expectedSsml = "<speak>$speechText</speak>"
        Assertions.assertEquals(expectedSsml, (response.outputSpeech as SsmlOutputSpeech).ssml)
        Assertions.assertNull(response.reprompt)
        Assertions.assertTrue(response.card is SimpleCard)
        Assertions.assertEquals("HelloWorld", (response.card as SimpleCard).title)
        Assertions.assertEquals(speechText, (response.card as SimpleCard).content)
        Assertions.assertTrue(response.shouldEndSession)
    }
}
