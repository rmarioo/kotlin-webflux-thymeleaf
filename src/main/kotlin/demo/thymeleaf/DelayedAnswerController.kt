package demo.thymeleaf

import kotlinx.coroutines.delay
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class DelayedAnswerController {
	private val logger: Logger = LoggerFactory.getLogger("controller")



	@GetMapping("/sleep") @ResponseBody
	suspend fun sleep(@RequestParam(value = "id") id: Integer,
					  @RequestParam(value = "time") timeMillis: Long): String {

		logger.info("received a call from $id will sleep for $timeMillis " )
		val delayMs = delay(timeMillis)
		val message = "server_ok_$id"
		logger.info("returning $message" )
		return message
	}
}


