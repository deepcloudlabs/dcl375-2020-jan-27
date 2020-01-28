package com.example.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.service.RandomNumberService;
import com.example.service.Strategy;
import com.example.service.StrategyType;

@Service
@Strategy(StrategyType.SECURE)
public class SecureRandomNumberService implements RandomNumberService {
	private Random random = new SecureRandom();

	@Override
	public int next(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

}
