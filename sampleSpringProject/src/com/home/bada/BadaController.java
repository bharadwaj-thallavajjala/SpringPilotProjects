/**
 * 
 */
package com.home.bada;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Z500-PC
 *
 */
// this is a comment.
//hi

// Macha Chicha >> What The HEll !!

// Hey guys this is a edited and set by abhimanyu

@Controller
public class BadaController extends HttpServlet{
	  //private static final long serialVersionUID = 1L;
	  @Autowired
	  ServletContext servletContext;
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
	  @RequestMapping(value = "/processTestID", method = { RequestMethod.POST, RequestMethod.GET })
	  public final String badaProcess(final HttpServletRequest request, final HttpServletResponse response, final ModelMap modelMap) throws IOException
	  {
		System.out.println("=====>START processTestID");
	    String strTestID = request.getParameter("testidtxt");
	    modelMap.addAttribute("testID", strTestID);

	    return "sample.jsp";
	  }

	  @RequestMapping(value = "/home.daba", method = { RequestMethod.POST, RequestMethod.GET })
	  public final String home(final HttpServletRequest request, final HttpServletResponse response, final ModelMap modelMap) throws IOException
	  {
		System.out.println("=====>START home");
	    return "home1.html";
	  }
	  
	  @RequestMapping(value = "/testURI", method = { RequestMethod.POST, RequestMethod.GET })
	  public final String testURI(final HttpServletRequest request, final HttpServletResponse response, final ModelMap modelMap) throws IOException
	  {
		System.out.println("=====>START testURI");

	    return "sample.jsp";
	  }
	  
}
