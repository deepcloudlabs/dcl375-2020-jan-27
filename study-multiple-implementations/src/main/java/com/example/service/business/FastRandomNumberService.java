package com.example.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.example.service.RandomNumberService;
import com.example.service.Strategy;
import com.example.service.StrategyType;

@Service
@Strategy(StrategyType.FAST)
public class FastRandomNumberService implements RandomNumberService {

	@Override
	public int next(int min, int max) {
		System.err.println(getClass().getSimpleName());
		return ThreadLocalRandom.current()
				        .nextInt(max-min+1)+min;
	}

}
