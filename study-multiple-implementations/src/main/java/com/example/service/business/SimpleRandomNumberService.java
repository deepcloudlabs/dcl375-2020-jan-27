package com.example.service.business;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.service.RandomNumberService;
import com.example.service.Strategy;
import com.example.service.StrategyType;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
@Strategy(StrategyType.SIMPLE)
public class SimpleRandomNumberService implements RandomNumberService {
	private Random random = new Random();

	@Override
	public int next(int min, int max) {
		System.err.println(getClass().getSimpleName());
		return random.nextInt(max - min + 1) + min;
	}

}
