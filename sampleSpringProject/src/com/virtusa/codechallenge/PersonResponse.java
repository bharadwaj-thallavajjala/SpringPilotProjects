/**
 * 
 */
package com.virtusa.codechallenge;

/**
 * @author bharadwaj
 *
 */
public class PersonResponse {

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
	private boolean eligibility;
	/**
	 *
	 */
	private String errorStr;

	/**
	 *
	 */
	public PersonResponse() {

	}

	/**
	 * @param fn firstName
	 * @param ln lastName
	 * @param eligi eligibility
	 */
	public PersonResponse(final String fn, final String ln, final boolean eligi) {
		this.setFirstName(fn);
		this.setLastName(ln);
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
	 * @param ln lastname
	 */
	public void setLastName(final String ln) {
		this.lastName = ln;
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


	/**
	 * @return String
	 */
	public String getErrorStr() {
		return errorStr;
	}

	/**
	 * @param errStr errorString
	 */
	public void setErrorStr(final String errStr) {
		this.errorStr = errStr;
	}

}
