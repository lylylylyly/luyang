package com.luyang.pigservice;

import com.luyang.pigbean.PigBean;

public interface PigService {
	PigBean getPigById(int id);
	boolean changePigById(PigBean pig);
	boolean addPig(PigBean pig);
}
