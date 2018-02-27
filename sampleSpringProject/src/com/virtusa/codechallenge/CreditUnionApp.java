/**
 * 
 */

package com.virtusa.codechallenge;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bharadwaj
 *
 */
@RestController
public class CreditUnionApp {
	/*
	 * Log4j Logger that is used to log information and some debug statements.
	 */
	/**
	 *
	 */
	protected static Logger logger = Logger.getLogger("SampleLogger");

	/**
	 *
	 */
	@Autowired
	ServletContext servletContext;

	/**
	 * @param person person
	 * @param request request
	 * @param response response
	 * @return PersonResponse
	 * @throws ParseException ParseException
	 * @throws IOException  IOException
	 */
	@RequestMapping(value = "/financial-eligibility", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public PersonResponse checkCredit(@RequestBody final Person person, final HttpServletRequest request,
			final HttpServletResponse response)
			throws ParseException, IOException {
		logger.debug("=====> CreditUnionApp:checkCredit: START");
		logger.debug("=====>FN:" + person.getFirstName());
		logger.debug("=====>SSN:" + person.getSsn());
		logger.debug("=====>request:" + request.getHeader("Bearer"));
		PersonResponse perResp = new PersonResponse();

		if (!request.getHeader("Bearer").trim().equals("TestBearerValue")) {
			perResp.setFirstName("InValid Request");
			perResp.setLastName("InValid Request");
			perResp.setEligibility(false);
			perResp.setErrorStr("DENIED");
			return perResp;
		}


		PersonRepository persRepo = new PersonRepository();
		Person per = null;
		try {
			per = persRepo.findPersonBySSN(person.getSsn());
			if (per != null) {
			if (!per.getFirstName().equals(person.getFirstName())
					|| !per.getLastName().equals(person.getLastName())) {
				per = null;
			}
			}
		} catch (Exception e) {
			per = null;
			logger.debug("Person Not Found...");
		}

		if (per == null) {
			perResp.setFirstName("Not Found");
			perResp.setLastName("Not Found");
			perResp.setEligibility(false);
			perResp.setErrorStr("DENIED");
		} else {
			perResp.setFirstName(per.getFirstName());
			perResp.setLastName(per.getLastName());
			perResp.setEligibility(per.getEligibility());
			if (per.getEligibility()) {
				perResp.setErrorStr("APPROVED");
			} else {
				perResp.setErrorStr("DENIED");
			}
		}
		response.setHeader("X-Request-ID", request.getHeader("X-Request-ID"));
		logger.debug("=====>perResp:" + perResp.getErrorStr());
		return perResp;
	}
}
