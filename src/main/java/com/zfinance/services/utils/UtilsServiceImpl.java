package com.zfinance.services.utils;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class UtilsServiceImpl implements UtilsService {

	@Override
	public String generateRandomNumberWithTs() {
		// Get the current time in milliseconds since the epoch
		long currentTime = System.currentTimeMillis();

		// Generate a random number between 0 and 999
		int randomNumber = ThreadLocalRandom.current().nextInt(1000);

		// Concatenate the timestamp and random number
		String combinedNumber = String.valueOf(currentTime) + randomNumber;

		// Ensure the result is 8 characters long
		String result = combinedNumber.substring(0, Math.min(combinedNumber.length(), 8));

		return result;
	}

}
