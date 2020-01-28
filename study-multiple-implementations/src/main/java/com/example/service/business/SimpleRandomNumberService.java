package com.example.service.business;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.service.RandomNumberService;
import com.example.service.Strategy;
import com.example.service.StrategyType;

@Service
@Strategy(StrategyType.SIMPLE)
public class SimpleRandomNumberService implements RandomNumberService {
	private Random random = new Random();

	@Override
	public int next(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

}
