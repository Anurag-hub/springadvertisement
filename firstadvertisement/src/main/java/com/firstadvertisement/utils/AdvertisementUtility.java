package com.firstadvertisement.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.firstadvertisement.entity.Advertise;

public class AdvertisementUtility {
	
	public static List<Advertise> convertAdvertisementEntitytoAdvertisementList(List<Advertise> userEntityList) {
		List<Advertise> advertiselist = new ArrayList<Advertise>();
		Consumer<Advertise> consumer = ((Advertise advertise)->advertiselist.add(convertAdvertisementEntitytoAdvertisement(advertise)));
		userEntityList.stream().forEach(consumer);
		return advertiselist;
	}
	

	public static Advertise convertAdvertisementEntitytoAdvertisement(Advertise advertise) {
		return new Advertise(advertise.getId(),advertise.getCategory(),advertise.getTitle(),advertise.getDescription());
	}

	public static Advertise convertAdvertisementtoAdvertisementEntity(Advertise advertise) {
		return new Advertise(advertise.getId(),advertise.getCategory(),advertise.getTitle(),advertise.getDescription());
	}
}
