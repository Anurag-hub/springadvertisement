package com.firstadvertisement.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstadvertisement.entity.Advertise;
import com.firstadvertisement.services.AdvertisementService;

@RestController
@RequestMapping("/advertise")
public class AdvertisementController {
	
	private AdvertisementService advertisementservice;

	@RequestMapping(value="/newadvertisement",method=RequestMethod.POST)
	public Advertise addNewAdvertisement(@RequestBody Advertise advertisement,@RequestHeader String key) {
		return advertisementservice.save(advertisement,key);
	}
}
