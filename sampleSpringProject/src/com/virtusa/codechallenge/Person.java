/**
 * 
 */
package com.virtusa.codechallenge;

import org.apache.log4j.Logger;

/**
 * @author bharadwaj
 *
 */
public class Person {

	/**
	 *
	 */
	private String firstName;
	/**
	 *
	 */
	private String lastName;
	/**
	 *
	 */
	private String ssn;
	/**
	 *
	 */
	private String zipCode;
	/**
	 *
	 */
	private boolean eligibility;
	/**
	 * Log4j Logger that is used to log information and some debug statements.
	 */
	/**
	 *
	 */
	protected static Logger logger = Logger.getLogger("SampleLogger");

	/**
	 *
	 */
	public Person() {

	}

	/**
	 * @param fn firstName
	 * @param ln lastName
	 * @param ssnStr ssn
	 * @param zc zipCode
	 * @param eligi eligibility
	 */
	public Person(final String fn, final String ln, final String ssnStr, final String zc,
			final boolean eligi) {
		this.setFirstName(fn);
		this.setLastName(ln);
		this.setSsn(ssnStr);
		this.setZipCode(zc);
		this.setEligibility(eligi);
	}

	/**
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param fn firstName
	 */
	public void setFirstName(final String fn) {
		this.firstName = fn;
	}

	/**
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param ln lastName
	 */
	public void setLastName(final String ln) {
		this.lastName = ln;
	}

	/**
	 * @return String
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssnStr ssnStr
	 */
	public void setSsn(final String ssnStr) {
		this.ssn = ssnStr;
	}

	/**
	 * @return String
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zc Zipcode
	 */
	public void setZipCode(final String zc) {
		this.zipCode = zc;
	}

	/**
	 * @return boolean
	 */
	public boolean getEligibility() {
		return eligibility;
	}

	/**
	 * @param eligi eligibility
	 */
	public void setEligibility(final boolean eligi) {
		this.eligibility = eligi;
	}

}
