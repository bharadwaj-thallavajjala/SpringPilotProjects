/**
 * 
 */
package com.home.bada;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bharadwaj
 *
 */
@Controller
public class SampleDataController extends HttpServlet {
	  @Autowired
	  ServletContext servletContext;
	    /**
	     * AccInfoJDBCTemplate used in this class.
	     */
//	    private final SampleJDBCTemplate sampleJdbcTempl = (SampleJDBCTemplate) SpringApplicationContext.getBean("sampleJdbcTemplate");
	    /**
	     *
	     */
	    @Autowired
	    private SampleJDBCTemplate sampleJdbcTempl;
	    /**
	     * Log4j Logger that is used to log information and some debug statements.
	     */
		protected static Logger logger = Logger.getLogger("SampleLogger");
	  
	  /**
	   * @param request
	   *          request
	   * @param response
	   *          response
	   * @param modelMap
	   *          modelMap
	   * @return String String
	   * @throws IOException
	   *           IOException
	   */
	  @RequestMapping(value = "/getDataFromDB", method = { RequestMethod.POST, RequestMethod.GET })
	  public final String getData(final HttpServletRequest request, final HttpServletResponse response, final ModelMap modelMap) throws IOException
	  {
		logger.debug("=====>START getData");
		String inpStr = request.getParameter("inputStr");
		logger.debug("=====>inputStr:"+inpStr);
		String outputStr = sampleJdbcTempl.getInfoFromDB(inpStr);
		logger.debug("=====>outputStr:"+outputStr);
		
		modelMap.addAttribute("testID", outputStr);
	    return "sample.jsp";
	  }
}
