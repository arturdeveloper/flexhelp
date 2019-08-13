package com.jdb.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.jdb.entities.Category;
import com.jdb.entities.Offer;
import com.jdb.entities.Provider;
import com.jdb.entities.User;
import com.jdb.services.ProviderServices;

@RunWith(Parameterized.class)
class ProviderServicesTest {

	Offer expected;
	static ProviderServices service;

	public ProviderServicesTest(Offer expected) {
		super();
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection params() {
		Category category = new Category(10, "CatTitle1", "CatDescr1", "hourly");
		Provider provider = new Provider(106, "uname1", "uname1@mail.com", "secret");

		return Arrays.asList(new Object[][] { 
				{ new Offer(category, provider, 44, "Dubai", 4) },
				{ new Offer(category, provider, 17, "Portland", 7) },
				{ new Offer(category, provider, 22, "Belgium", 3) }, 
				{ new Offer(category, provider, 33, "agga", 4) }

		});
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddProvider() {
		fail("Not yet implemented");
	}

	@Test
	void testAddService() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateOffer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteOffer() {
		fail("Not yet implemented");
	}

}
