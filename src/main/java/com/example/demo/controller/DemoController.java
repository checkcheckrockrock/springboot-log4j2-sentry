package com.example.demo.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.sentry.Sentry;

@RestController
//@RequestMapping("/api/v1")
public class DemoController {

	private final Logger logger = LogManager.getLogger(DemoController.class);

	@RequestMapping("/")
	public String index() {
//		logger.trace("A TRACE Message");
//		logger.debug("A DEBUG Message");
//		logger.info("An INFO Message");
//		logger.warn("A WARN Message");
//		logger.error("An ERROR Message");

		try {
			throw new Exception("This is a test.");
		} catch (Exception e) {
			// This sends a simple event to Sentry
		    logger.error("This is a test");
			Sentry.captureException(e);
			logger.error("This is a test");
			return "Exception!";
		}
//		try {
//			unsafeMethod();
//		} catch (Exception e) {
//			// This sends an exception event to Sentry
////			logger.error("Exception caught", e);
//			return "Exception!";
//		}
//		return "Howdy! Check out the Logs to see the output...";
	}

	void unsafeMethod() {
		throw new UnsupportedOperationException("You shouldn't call this!");
	}

	@GetMapping("/test-get")
	public String testGet() {

		return "";
	}

	@PostMapping("/test-post")
	public String testPost() {
		return "";
	}
}
