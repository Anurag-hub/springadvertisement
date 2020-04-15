package com.firstadvertisement.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstadvertisement.entity.Advertise;
import com.firstadvertisement.entity.User;
import com.firstadvertisement.repository.AdvertisementRepository;
import com.firstadvertisement.repository.UserRepository;
import com.firstadvertisement.utils.AdvertisementUtility;

@Service
public class AdvertisementServiceImplementation {

	@Autowired
	private AdvertisementRepository advertisementrepository;
	
	
	public Advertise save(Advertise advertisement, String key) {
		User user=new User();
		String usersessionid =user.getSessionId();
		if(usersessionid!=null)
		{	Advertise advertise=AdvertisementUtility.convertAdvertisementEntitytoAdvertisement(advertisement);
			advertisementrepository.save(advertise);
			return AdvertisementUtility.convertAdvertisementEntitytoAdvertisement(advertisement);
		}
		else
		{
			return null;
		}
	}
}
