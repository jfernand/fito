package es.casaroja.fito

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Intent
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.RequestEnvelope
import com.amazon.ask.model.ui.SimpleCard
import com.amazon.ask.model.ui.SsmlOutputSpeech
import es.casaroja.ask.HelpIntentHandler
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class HelpIntentHandlerTest {
    @Inject
    lateinit var handler: HelpIntentHandler

    @Test
    fun testHelpIntentHandler() {
        val input = HandlerInput.builder()
            .withRequestEnvelope(
                RequestEnvelope.builder()
                    .withRequest(
                        IntentRequest.builder()
                            .withIntent(
                                Intent.builder()
                                    .withName("AMAZON.HelpIntent")
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
        val speechText = "You can say hello to me!"
        val expectedSsml = "<speak>$speechText</speak>"
        Assertions.assertEquals(expectedSsml, (response.outputSpeech as SsmlOutputSpeech).ssml)
        Assertions.assertNotNull(response.reprompt.outputSpeech)
        Assertions.assertTrue(response.reprompt.outputSpeech is SsmlOutputSpeech)
        Assertions.assertEquals(expectedSsml, (response.reprompt.outputSpeech as SsmlOutputSpeech).ssml)
        Assertions.assertTrue(response.card is SimpleCard)
        Assertions.assertEquals("HelloWorld", (response.card as SimpleCard).title)
        Assertions.assertEquals(speechText, (response.card as SimpleCard).content)
        Assertions.assertFalse(response.shouldEndSession)
    }
}
