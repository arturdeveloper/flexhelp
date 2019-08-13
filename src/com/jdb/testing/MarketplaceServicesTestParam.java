package com.jdb.testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.jdb.entities.Category;
import com.jdb.entities.Offer;
import com.jdb.entities.Provider;
import com.jdb.services.MarketplaceServices;

@RunWith(Parameterized.class)
public class MarketplaceServicesTestParam {

	Offer expected;
	static MarketplaceServices service;

	public MarketplaceServicesTestParam(Offer expected) {
		super();
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection params() {
		Category category = new Category(10, "CatTitle1", "CatDescr1", "hourly");
		Provider provider = new Provider(106, "uname1", "uname1@mail.com", "secret");

		return Arrays.asList(new Object[][] { { new Offer(category, provider, 44, "Dubai", 4) },
				{ new Offer(category, provider, 17, "Portland", 7) },
				{ new Offer(category, provider, 22, "Belgium", 3) }, { new Offer(category, provider, 33, "agga", 4) }

		});
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		service = new MarketplaceServices();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllMatchingOffers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategories() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOffersByProviderId() {

//		Offer actual = service.getOffersByProviderId(expected.getProvider());
		List<Offer> actual = service.getOffersByProviderId(expected.getProvider());
//		assertEquals(expected, actual);
//		assertArrayEquals(expected, actual);

		for (Offer actualOffer : actual) {
			assertEquals(expected, actualOffer);
		}

	}

	@Test
	public void testGetOfferById() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddOfferToOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrdersByCustomerId() {
		fail("Not yet implemented");
	}

}
