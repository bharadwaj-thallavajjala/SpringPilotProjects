/**
 * 
 */
package com.home.bada;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.HttpStatus;
/**
 * @author bharadwaj
 *
 */
@RestController
public class SampleRestController {
    /**
     * Log4j Logger that is used to log information and some debug statements.
     */
	protected static Logger logger = Logger.getLogger("SampleLogger");
	
	  @Autowired
	  ServletContext servletContext;
	    /**
	     *
	     */
	    @Autowired
	    private SampleJDBCTemplate sampleJdbcTempl;

    @RequestMapping(value = "/getJsonFromRestController", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    public List<Map<String,Object>> getCurrentSessionInfo(final HttpServletRequest request) throws ParseException, IOException {
    	logger.debug("=====> SampleRestController:getCurrentSessionInfo: START");
    	int inpStr = Integer.parseInt(request.getParameter("inputStr"));
		logger.debug("=====>inputStr:"+inpStr);
		List<Map<String,Object>> outputStr = sampleJdbcTempl.getInfoFromDBMulOut(inpStr);
		logger.debug("=====>outputStr:"+outputStr);

        return outputStr;
    }
}
