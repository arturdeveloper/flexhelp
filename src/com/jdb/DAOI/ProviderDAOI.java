package com.jdb.DAOI;

import com.jdb.entities.LoginView;
import com.jdb.entities.OfferView;
import com.jdb.entities.Provider;
import com.jdb.entities.User;

public interface ProviderDAOI {

	boolean addService(OfferView offer);

	boolean addProvider(User provider);

	User validateUser(LoginView login);

	boolean updateOffer(OfferView offerView, int offerId);

	boolean deleteOffer(User user, int offerId);

}
