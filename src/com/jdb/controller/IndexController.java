package com.jdb.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdb.entities.Category;
import com.jdb.entities.Employee;
import com.jdb.entities.Offer;
import com.jdb.entities.OfferView;
import com.jdb.entities.Orders;
import com.jdb.entities.Provider;
import com.jdb.entities.SearchFilter;
import com.jdb.entities.User;
import com.jdb.services.AdminServices;
import com.jdb.services.EmployeeServices;
import com.jdb.services.MarketplaceServices;
import com.jdb.services.ProviderServices;

@SessionAttributes(value = { "userLogin", "userType" })
@Controller
public class IndexController {

	@ModelAttribute("userLogin")
	public User setupProvider() {
		User user = new User(-1, "secret", "secret", "secret");
		return user;
	}

//	@RequestMapping("/")
	@RequestMapping(value = { "/", "/index" })
//	public ModelAndView home() {
	public String home(Model currentUser) {

		if (!currentUser.containsAttribute("userkey")) {
			currentUser.addAttribute("userkey", new User());
//			currentUser.addAttribute("userkey", new User(-1, "secret", "secret", "secret"));
		}

		MarketplaceServices marketServices = new MarketplaceServices();

		SearchFilter filter = new SearchFilter();
		List<Offer> offerList = marketServices.getAllMatchingOffers(filter);

		List<Category> categoryList = marketServices.getCategories();

//		mav.addObject("offerList", offerList);
//		mav.addObject("categoryList", categoryList);
//		return mav;

		currentUser.addAttribute("offerList", offerList);
		currentUser.addAttribute("categoryList", categoryList);

		return "index";
	}

	/*
	 * For testing purposes
	 */
	@RequestMapping("/login")
//	public ModelAndView loggedCustomer(@ModelAttribute("userLogin") User currentUser) {
//	public ModelAndView loggedCustomer(@ModelAttribute("userLogin") User currentUser, BindingResult errors) {
	public String loggedCustomer(Model currentUser) {

		System.out.println("loggedCustomer " + currentUser.toString());

		MarketplaceServices marketServices = new MarketplaceServices();

		SearchFilter filter = new SearchFilter();
		List<Offer> offerList = marketServices.getAllMatchingOffers(filter);

		List<Category> categoryList = marketServices.getCategories();

//		ModelAndView mav = new ModelAndView("index");
//
////		mav.addObject("userLogin", currentUser);
//		mav.addObject("userkey", new User(-1, "secret", "secret", "secret"));
//		mav.addObject("offerList", offerList);
//		mav.addObject("categoryList", categoryList);
////		mav.addObject("errors", errors);

//		userkey.addAttribute("userkey", userkey);
		currentUser.addAttribute("offerList", offerList);
		currentUser.addAttribute("categoryList", categoryList);

//		return mav;
		return "index";
//		return "providerRegistrationOld";
	}

	/*
	 * For testing purposes
	 */
	@RequestMapping("/loginn")
	public ModelAndView loggedCustomerTwo(@ModelAttribute("userLogin") User currentUser, BindingResult errors) {
//	public ModelAndView loggedCustomerTwo(BindingResult errors) {
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("userkey", new User(-1, "secret", "secret", "secret"));
		return mav;
	}

	@RequestMapping("category/{id}")
	public ModelAndView showByCategory(@PathVariable("id") int catalogId) {
//		public String deleteEmployee(@PathVariable("id") int catalogId, RedirectAttributes ra) {

		ModelAndView mav = new ModelAndView("index");
		mav.addObject("userkey", new User());

		MarketplaceServices marketServices = new MarketplaceServices();

		SearchFilter filter = new SearchFilter();
		List<Offer> offerList = marketServices.getAllMatchingOffers(filter);

		List<Offer> result = offerList.stream().filter(e -> e.getCategory().getCatalogId() == catalogId)
				.collect(Collectors.toList());
		mav.addObject("offerList", result);

		List<Category> categoryList = marketServices.getCategories();

		mav.addObject("categoryList", categoryList);

		return mav;

//		ra.addFlashAttribute("offerList", result);
//		return "redirect:/category/{id}";
//		return "index";
	}

	@RequestMapping("/addEmployee")
//	public ModelAndView insertEpmloyee() {
	public ModelAndView insertEpmloyee(@ModelAttribute Employee employee) {
		ModelAndView mav = new ModelAndView("index");

		System.out.println(employee.toString());

//		Employee employee = new Employee(501, "Peter", "Ostin", "osting@mail.com");

		EmployeeServices service = new EmployeeServices();
		boolean result = service.addEmployee(employee);

		String message = result ? "employee saved" : "try again, not saved";
		mav.addObject("messageResult", message);
		mav.setViewName("employeeProfile");

		return mav;
	}

	@RequestMapping("/RegisterEmployee")
	public ModelAndView employeeRegistration() {
		return new ModelAndView("employeeRegistration");
	}

	@RequestMapping("/showEmployees")
	public ModelAndView showAllEmployees() {

		EmployeeServices service = new EmployeeServices();
		List<Employee> employeeList = service.getAllEmployees();

		ModelAndView mav = new ModelAndView("allemployees");
		mav.addObject("employeeList", employeeList);

		return mav;
	}

	@RequestMapping("/addCatalogItem")
	public ModelAndView insertCatalogItem(@ModelAttribute Category category) {
		ModelAndView mav = new ModelAndView("index");

		System.out.println("Contoller " + category.toString());
//		CatalogItem item = new CatalogItem(11, "Parking Rental", "Convenient Locations", "spot");

		AdminServices service = new AdminServices();
		boolean result = service.addCategory(category);

		String message = result ? "ServiceType saved" : "try again, not saved";

		mav.addObject("serviceType", result);
		mav.addObject("cbMessage", message);

		return mav;
	}

	@RequestMapping("/registerCatalogItem")
	public ModelAndView showCatalogItems() {
		return new ModelAndView("catalogRegistration");
	}

	@RequestMapping("/registerProvider")
	public ModelAndView showProviderForm() {
//		ModelAndView mav = new ModelAndView("providerRegistration");
		ModelAndView mav = new ModelAndView("providerRegistrationOld");

		mav.addObject("userkey", new Provider());
		return mav;
	}

	/*
	 * Add service and redirect to providerDashboard
	 */
	@RequestMapping("/addService")
//	public ModelAndView insertService(@ModelAttribute OfferView offer,
//			@SessionAttribute("userLogin") Provider provider) {
	public ModelAndView insertService(@ModelAttribute OfferView offer, @SessionAttribute("userLogin") User provider,
			RedirectAttributes ra) {

		System.out.println("Contoller Offer " + offer.toString());

		ProviderServices service = new ProviderServices();
		// Ignore the hidden field on front end. Enter info for the
		// current Provider from the session
		offer.setProviderId(provider.getId());
		boolean result = service.addService(offer);

		String message = result ? "You just added a new item to Marketplace" : "Connection error, please try again";

		ra.addFlashAttribute("userLogin", provider);
		ra.addFlashAttribute("cbMessage", message);
		return new ModelAndView("redirect:/providerDashboard");
	}

	/*
	 * Show form
	 */
	@RequestMapping("/registerService")
	public ModelAndView showServiceForm(@SessionAttribute("userLogin") Provider provider) {
		ModelAndView mav = new ModelAndView("serviceRegistration");
		System.out.println("Restricted page " + provider.toString());

		if (provider.getUname() == null) {
			mav.addObject("userLogin", provider);
			mav.setViewName("errorPage");
		} else {

			MarketplaceServices marketServices = new MarketplaceServices();
			List<Category> categoryList = marketServices.getCategories();

			categoryList.stream().forEach(c -> System.out.println(c.toString()));

			mav.addObject("categoryList", categoryList);
		}

		return mav;
	}

	@RequestMapping("/searchOffers")
	public ModelAndView searchForm() {
		return new ModelAndView("searchForm");
	}

	@RequestMapping("/searchResults")
	public ModelAndView showSearchResults(@ModelAttribute SearchFilter filter) {
//	@RequestMapping("category/{id}/searchResults")
//	public ModelAndView showSearchResults(@ModelAttribute SearchFilter filter, @PathVariable("id") int catalogId) {

		System.out.println("got mapping right?? ");// + catalogId);
//		MarketplaceServices marketServices = new MarketplaceServices();
//		List<Offer> offerList = marketServices.getAllMatchingOffers(filter);
//
//		List<Offer> result = offerList.stream().filter(e -> e.getLocation().equalsIgnoreCase(filter.getLocation()))
//				.collect(Collectors.toList());
//
//		ModelAndView mav = new ModelAndView("offerSearchResults");
////		mav.addObject("offerList", offerList);
//		mav.addObject("offerList", result);

//		return mav;
		return processSearch(filter);
	}

	private ModelAndView processSearch(SearchFilter searchFilter) {

		System.out.println("processSearch " + searchFilter.toString());
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("userkey", new User());

		MarketplaceServices marketServices = new MarketplaceServices();

		SearchFilter filter = new SearchFilter();
		List<Offer> offerList = marketServices.getAllMatchingOffers(filter);

//		List<Offer> result = offerList.stream().filter(e -> e.getCategory().getCatalogId() == catalogId)
//				.collect(Collectors.toList());

		List<Offer> result = null;

		try {
			result = offerList.stream()
					.filter(e -> e.getLocation().equalsIgnoreCase(searchFilter.getLocation())
							&& e.getPrice() > Double.parseDouble(searchFilter.getFromPrice())
							&& e.getPrice() < Double.parseDouble(searchFilter.getToPrice()))
					.collect(Collectors.toList());
		} catch (Exception e2) {

			// TODO: search by price only???
			System.out.println("first catch");
			try {
				result = offerList.stream().filter(e -> e.getLocation().equalsIgnoreCase(searchFilter.getLocation()))
						.collect(Collectors.toList());
			} catch (Exception e3) {
				System.out.println("second catch");
				result = offerList;
			}
		}

//		List<Offer> result = offerList.stream()
//				.filter(e -> e.getLocation().equalsIgnoreCase(searchFilter.getLocation())
//						&& e.getPrice() > Double.parseDouble(searchFilter.getFromPrice())
//						&& e.getPrice() < Double.parseDouble(searchFilter.getToPrice()))
//				.collect(Collectors.toList());

		mav.addObject("offerList", result);

		List<Category> categoryList = marketServices.getCategories();

		mav.addObject("categoryList", categoryList);

		return mav;
	}

	@RequestMapping("offerdetails/{id}")
	public ModelAndView showOfferDetails(@PathVariable("id") int offerId) {
		ModelAndView mav = new ModelAndView("offerSelected");
		mav.addObject("userkey", new Provider());

		MarketplaceServices marketServices = new MarketplaceServices();
		Offer foundOffer = marketServices.getOfferById(offerId);

		System.out.println("Found offer? Controller " + foundOffer);

		mav.addObject("offer", foundOffer);

		return mav;
	}

	@RequestMapping("/comletepurchase/{id}")
	public ModelAndView orderService(@SessionAttribute("userLogin") User customer, @PathVariable("id") int offerId,
			RedirectAttributes ra) {

		if (customer.getId() < 0) {
			ra.addFlashAttribute("loginFailed", true);
			return new ModelAndView("redirect:/offerdetails/" + offerId);
		}

		// TODO: put in database ;)
		System.out.println("/comletepurchase " + customer.toString());
		System.out.println("/comletepurchase " + offerId);

//		ModelAndView mav = new ModelAndView("offerSelected");
//		mav.addObject("userkey", new Provider());

		MarketplaceServices marketServices = new MarketplaceServices();
		Offer foundOffer = marketServices.getOfferById(offerId);
		long millis = System.currentTimeMillis();
		Orders newOrder = new Orders();
		newOrder.setCustomer(customer);
		newOrder.setOffer(foundOffer);
		newOrder.setOrderStartDate(new Date(millis));

		boolean result = marketServices.addOfferToOrders(newOrder);

		String message = result ? "Thank you for buying the item." : "Transaction failed please try again later";
//		mav.addObject("order", newOrder);
//		mav.addObject("cbMessage", message);
		ra.addFlashAttribute("userLogin", customer);
		ra.addFlashAttribute("cbMessage", message);

		return new ModelAndView("redirect:/customerDashboard");
	}

	@RequestMapping("/showdashboard/{id}")
//	public ModelAndView goToDashboard(@SessionAttribute("userLogin") User user, @PathVariable("id") int offerId,
	public ModelAndView goToDashboard(@SessionAttribute("userLogin") Optional<User> oUser,
			@PathVariable("id") int offerId, RedirectAttributes ra) {

		if (!oUser.isPresent()) {

			return new ModelAndView("redirect:/logout");
		}

		User user = oUser.get();

		System.out.println("showdashboard " + user.toString());

		ra.addFlashAttribute("userLogin", user);
		ra.addFlashAttribute("cbMessage", "");

		if (user.getRole().equalsIgnoreCase("provider")) {
			return new ModelAndView("redirect:/providerDashboard");
		}

		if (user.getRole().equalsIgnoreCase("customer")) {
			return new ModelAndView("redirect:/customerDashboard");
		}

		return new ModelAndView("redirect:/logout");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView getOfferToUpdate(@SessionAttribute("userLogin") User user, @PathVariable("id") int offerId,
			RedirectAttributes ra) {

		System.out.println("updateOffer " + user.toString());

		MarketplaceServices marketServices = new MarketplaceServices();
		Offer offerToUpdate = marketServices.getOfferById(offerId);

		ra.addFlashAttribute("userLogin", user);
		ra.addFlashAttribute("offerToUpdate", offerToUpdate);

		return new ModelAndView("redirect:/providerDashboard");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView setOfferToUpdate(@SessionAttribute("userLogin") User user, @PathVariable("id") int offerId,
			@ModelAttribute OfferView offerView, RedirectAttributes ra) {

		ProviderServices providerService = new ProviderServices();

		// retrieve the provider Id from the session
		offerView.setProviderId(user.getId());

		// we don't have ID on the model and get the value from path var
		boolean result = providerService.updateOffer(offerView, offerId);

		String message = result ? "Your offer has been updated" : "Connection error please try again";

		ra.addFlashAttribute("userLogin", user);
		ra.addFlashAttribute("cbMessage", message);

		return new ModelAndView("redirect:/providerDashboard");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public ModelAndView removeOffer(@SessionAttribute("userLogin") User user, @PathVariable("id") int offerId,
			RedirectAttributes ra) {

		// can we get here when session is not present
		System.out.println("removeOffer " + user.toString());

		ProviderServices providerService = new ProviderServices();

		// passing the user so that we can check ownership
		boolean result = providerService.deleteOffer(user, offerId);

		String message = result ? "Your offer has been deleted" : "Connection error please try again";

		ra.addFlashAttribute("userLogin", user);
		ra.addFlashAttribute("cbMessage", message);

		return new ModelAndView("redirect:/providerDashboard");
	}
}
