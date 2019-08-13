package com.jdb.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jdb.entities.Category;
import com.jdb.entities.Customer;
import com.jdb.entities.LoginView;
import com.jdb.entities.Offer;
import com.jdb.entities.Orders;
import com.jdb.entities.Provider;
import com.jdb.entities.SearchFilter;
import com.jdb.entities.User;
import com.jdb.services.CustomerServices;
import com.jdb.services.MarketplaceServices;
import com.jdb.services.ProviderServices;

@SessionAttributes(value = { "userLogin", "userType" })
@Controller
public class UserSessionController {

	// method level session annotations and handling
//	@RequestMapping("/login")
	public void myMethod(@RequestParam("password") String password, @SessionAttribute("userLogin") Provider userLogin,
			@SessionAttribute("userType") String userType) {
//		ModelAndView mav = new ModelAndView("index");
//		mav.addObject("userLogin", service.getUserByName(username));
//	mav.clear(); // logs out	

		// access that session data
//		similar to model access 

		// access in view
//		${userLogin.name}
	}

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
////		binder.setDisallowedFields(new String[] { "id", "uname", "email", "password" });
////		binder.setDisallowedFields(new String[] { "email" });
////		binder.setRequiredFields(new String[] { "uname" });
//		binder.setRequiredFields(new String[] { "id", "uname", "email", "password" });
////		binder.initBeanPropertyAccess();//(new String[] { "id", "uname", "email", "password" });
//	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}

////		****************************************************

	@RequestMapping(value = "/addProvider", method = RequestMethod.POST)
//	public ModelAndView insertProvider(@ModelAttribute("userkey") @Valid Provider provider, BindingResult errors,
	public String insertProvider(@ModelAttribute("userkey") @Valid Provider provider, BindingResult errors,
//	public void insertProvider(@ModelAttribute("userkey") @Valid Provider provider, BindingResult errors,
			RedirectAttributes ra) {

		System.out.println(errors.toString());

		if (errors.hasErrors()) {

// redirect version ****************************************
			// TODO: add error messages before redirect to show validation

//			ra.addFlashAttribute("errors", errors);
			ra.addFlashAttribute("org.springframework.validation.BindingResult.userkey", errors);
			ra.addFlashAttribute("userkey", provider);

//			return new ModelAndView("redirect:/login");
//			return "redirect:/login";
			return "redirect:/index";

//			return new ModelAndView("redirect:/loginn");

// call by method name version ****************************************

//			IndexController ctor = new IndexController();
//			ctor.loggedCustomerTwo(errors);

// new index view version ****************************************

//			ModelAndView mav = new ModelAndView("index");
//
//			MarketplaceServices marketServices = new MarketplaceServices();
//
//			SearchFilter filter = new SearchFilter();
//			List<Offer> offerList = marketServices.getAllMatchingOffers(filter);
//
//			List<Category> categoryList = marketServices.getCategories();

////			mav.addObject("userkey", new User(-1, "secret", "secret", "secret"));
//			mav.addObject("userkey", new User(-1, provider.getUname(), provider.getEmail(), ""));
//			mav.addObject("offerList", offerList);
//			mav.addObject("categoryList", categoryList);

//			return mav;
		}

//		move this logic to successful login ****************************************

		ModelAndView mav = new ModelAndView("index");
//
//		System.out.println("Session Contoller " + provider.toString());
//
//		ProviderServices service = new ProviderServices();
//		boolean result = service.addProvider(provider);
//
//		String message = result ? "Provider saved" : "try again, not saved";
//
//		mav.addObject("serviceType", result);
//		mav.addObject("cbMessage", message);
//		mav.addObject("userLogin", provider);
//
//		ra.addFlashAttribute("userLogin", provider);

//		return new ModelAndView("redirect:/providerDashboard");

//		return mav;
		return "index";
	}

	/*
	 * checking to see if validation works. Should display error messages for short
	 * user name
	 */
	@RequestMapping(value = "/addProviderOld", method = RequestMethod.POST)
	public ModelAndView addProviderOld(@ModelAttribute("userkey") @Valid Provider provider, BindingResult errors) {
		ModelAndView mav = new ModelAndView();

		if (errors.hasErrors()) {

			System.out.println("addProviderOld do we even get to errors???");

//			mav.addObject("userkey", provider);

			mav.setViewName("providerRegistrationOld");

//			ModelAndView mav = new ModelAndView("providerRegistrationOld");
//			ModelAndView mav = new ModelAndView("index");
//			return mav;

			// TODO: add error messages before redirect to show validation

//			ra.addFlashAttribute("errors", errors);
//			ra.addFlashAttribute("userLogin", provider);
//			return new ModelAndView("redirect:/login");

//			return new ModelAndView("redirect:/index");

		}

		return mav;
	}

	@RequestMapping("/loginProvider")
	public ModelAndView showProviderForm() {
		return new ModelAndView("providerLogin");
	}

	@RequestMapping("/validateUser")
	public ModelAndView validateAndSessionProvider(@ModelAttribute LoginView login, RedirectAttributes ra) {
		ModelAndView mav = new ModelAndView("index");

		ProviderServices providerService = new ProviderServices();
		User currentUser = providerService.validateUser(login);
//		Provider currentUser = providerService.validateUser(login);

		if (currentUser == null) {
//			mav.setViewName("index");
//			mav.addObject("userkey", new User());

			ra.addFlashAttribute("loginFailed", true);
			return new ModelAndView("redirect:/index");
		}

		if (currentUser.getRole().equalsIgnoreCase("provider")) {

//			return new ModelAndView("forward:/providerDashboard");

			ra.addFlashAttribute("userLogin", currentUser);
			ra.addFlashAttribute("cbMessage", "");
			return new ModelAndView("redirect:/providerDashboard");
		}

		if (currentUser.getRole().equalsIgnoreCase("customer")) {

			System.out.println("Customer logged with id " + currentUser.getId());

			ra.addFlashAttribute("userLogin", currentUser);

			return new ModelAndView("redirect:/index");
		}

		// TODO: add if statement for admin too with its view

//		String message = currentUser != null ? "Provider " + currentUser.getUname() + " is logged" : "login failed";

//		mav.addObject("cbMessage", message);
		mav.addObject("userLogin", currentUser);

		return mav;
	}

	@RequestMapping("/providerDashboard")
	public ModelAndView setProviderDashboard(@ModelAttribute("userLogin") User provider,
			@ModelAttribute("offerToUpdate") Optional<Offer> uoffer, @ModelAttribute("cbMessage") String message) {

		System.out.println("providerDashboard prov " + provider.toString());

		ModelAndView mav = new ModelAndView("providerLogged");

		MarketplaceServices marketServices = new MarketplaceServices();

		// Populate selection drop-down with actual values from DB
		List<Category> categoryList = marketServices.getCategories();

		List<Offer> offerList = marketServices.getOffersByProviderId(provider);

		Offer offerToUpdate = uoffer.get().getOfferId() == 0 ? null : uoffer.get();

		System.out.println("providerDashboard optional " + offerToUpdate);
		System.out.println(" pres " + uoffer.isPresent());

//		if (offerList != null) {
//			offerList.stream().forEach(c -> System.out.println("/providerDashboard " + c.toString()));
//		}

		mav.addObject("categoryList", categoryList);
		mav.addObject("offerList", offerList);
		mav.addObject("userLogin", provider);
		mav.addObject("offerToUpdate", offerToUpdate);
		mav.addObject("cbMessage", message);

		return mav;
	}

	@RequestMapping("/customerDashboard")
	public ModelAndView setCustomerDashboard(@ModelAttribute("userLogin") User customer,
			@ModelAttribute("cbMessage") String message) {

		System.out.println("customerDashboard cust " + customer.toString());

		ModelAndView mav = new ModelAndView("customerLogged");

		MarketplaceServices marketServices = new MarketplaceServices();

		List<Orders> orderList = marketServices.getOrdersByCustomerId(customer);
		List<Category> categoryList = marketServices.getCategories();

		if (orderList != null) {
			orderList.stream().forEach(c -> System.out.println("/customerDashboard " + c.toString()));
		}
		mav.addObject("categoryList", categoryList);
		mav.addObject("orderList", orderList);
		mav.addObject("userLogin", customer);
		mav.addObject("cbMessage", message);

		return mav;
	}

	@RequestMapping("/logoutProvider")
	public ModelAndView logoutProvider() {
		ModelAndView mav = new ModelAndView("index");
		mav.clear();

		String message = "Session cleaned, user logged out";
		mav.addObject("cbMessage", message);

		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logoutUser() {

		System.out.println("do we get to logout controller???");
		ModelAndView mav = new ModelAndView("index");
//		ModelAndView mav = new ModelAndView("redirect:/index");
		mav.clear();
		mav.addObject("userLogin", new User(-1, "secret", "secret", "secret"));

		return mav;
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
//	public ModelAndView insertCustomer(@ModelAttribute("userkey") @Valid User customer, BindingResult errors) {
	public ModelAndView insertCustomer(@ModelAttribute("userkey") @Valid Customer customer, BindingResult errors,
			RedirectAttributes ra) {

		System.out.println("insertCustomer " + customer.toString());

		if (errors.hasErrors()) {
//			ModelAndView mav = new ModelAndView("providerRegistration");
			ModelAndView mav = new ModelAndView("index");
			return mav;
		}

		CustomerServices service = new CustomerServices();
		boolean result = service.addCustomer(customer);

		ProviderServices providerService = new ProviderServices();

		// important to retrieve the user from login where the "role" is getting
		// assigned
		LoginView login = new LoginView(customer.getUname(), customer.getPassword());
		User currentUser = providerService.validateUser(login);

//		String message = result ? "Provider saved" : "try again, not saved";

//		mav.addObject("serviceType", result);
//		mav.addObject("cbMessage", message);
//		mav.addObject("userLogin", customer);

//		return mav;

		ra.addFlashAttribute("userLogin", currentUser);

		return new ModelAndView("redirect:/index");
	}
}
