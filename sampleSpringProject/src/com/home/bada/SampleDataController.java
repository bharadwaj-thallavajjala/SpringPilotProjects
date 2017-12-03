/**
 * 
 */
package com.home.bada;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		int inpStr = Integer.parseInt(request.getParameter("inputStr"));
		logger.debug("=====>inputStr:"+inpStr);
		String outputStr = sampleJdbcTempl.getInfoFromDB(inpStr);
		logger.debug("=====>outputStr:"+outputStr);
		
		modelMap.addAttribute("testID1", outputStr);
	    return "sample.jsp";
	  }
	  @RequestMapping(value = "/getDataFromDBMulOut", method = { RequestMethod.POST, RequestMethod.GET })
	  public final String getDataMulOut(final HttpServletRequest request, final HttpServletResponse response, final ModelMap modelMap) throws IOException
	  {
		logger.debug("=====>START getData");
		int inpStr = Integer.parseInt(request.getParameter("inputStr"));
		logger.debug("=====>inputStr:"+inpStr);
		List<Map<String,Object>> outputStr = sampleJdbcTempl.getInfoFromDBMulOut(inpStr);
		logger.debug("=====>outputStr:"+outputStr);
		String outStr = "";
		for (Iterator iterator = outputStr.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			outStr = outStr + map.get("COUNTRY_ID")+"--"+map.get("COUNTRY_NAME") + "<BR>";
			
		}
		
		modelMap.addAttribute("testID1", outStr);
	    return "sample.jsp";
	  }
}
