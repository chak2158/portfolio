package com.goupang.www.dao.sample;

import java.util.List;

import com.goupang.www.dto.sample.Sample;

public interface SampleMybatisDAO {
	
	List<Sample> selectPage();

    
}
