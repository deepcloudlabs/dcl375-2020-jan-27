package com.example.service;

import java.util.List;

public interface LotteryService {
	List<Integer> draw(int max,int size,
			           boolean isSorted);
	List<List<Integer>> draw(int max,int size,
			boolean isSorted, int length);
}
