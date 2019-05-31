package com.luyang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luyang.pigbean.PigBean;
import com.luyang.pigmapper.PigMapper;
import com.luyang.pigservice.PigService;

@Service(value="PigServiceImpl")
public class PigServiceImpl implements PigService {
	
	@Autowired
	private PigMapper pigMapper;

	@Override
	public PigBean getPigById(int id) {
		// TODO Auto-generated method stub
		return pigMapper.getOne(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean changePigById(PigBean pig) {
		// TODO Auto-generated method stub
		try {
			pigMapper.changeOne(pig);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addPig(PigBean pig) {
		// TODO Auto-generated method stub
		try {
			pigMapper.addOne(pig);
			System.out.println("添加成功");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("添加失败");
			e.printStackTrace();
			return false;
		}
		
		
	}

}
