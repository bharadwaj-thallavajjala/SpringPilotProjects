/**
 *
 */
package com.virtusa.codechallenge;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * @author bharadwaj
 *
 */
public class PersonRepository {
	/**
	 * Log4j Logger that is used to log information and some debug statements.
	 */
	/**
	 *
	 */
	protected static Logger logger = Logger.getLogger("SampleLogger");

	/**
	 *
	 *
	 */
	public ArrayList<Person> personRepo = new ArrayList<Person>();

	/**
	 *
	 */
	public PersonRepository() {
		Person person1 = new Person("f1", "l1", "ssn1", "z1", true);
		Person person2 = new Person("f2", "l2", "ssn2", "z2", true);
		Person person3 = new Person("f3", "l3", "ssn3", "z3", false);
		Person person4 = new Person("f4", "l4", "ssn4", "z4", false);
		personRepo.add(person1);
		personRepo.add(person2);
		personRepo.add(person3);
		personRepo.add(person4);

	}

	/**
	 * @param ssn
	 *            ssn
	 * @return Person
	 * @throws Exception
	 *             Exception
	 */
	public Person findPersonBySSN(final String ssn) throws Exception {
		Person retPer = null;
		for (Person per : personRepo) {
			if (per.getSsn().equals(ssn)) {
				retPer = per;
			}
		}
		return retPer;
	}


}
