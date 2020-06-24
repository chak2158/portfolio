package com.goupang.www.service.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.sample.SampleDAO;
import com.goupang.www.dao.sample.SampleMybatisDAO;
import com.goupang.www.dto.sample.Sample;

@Service
public class SampleListService {
	
	private SampleDAO sampleDao;
	private SampleMybatisDAO dao;
	
	@Autowired
	public void setSampleDao(SampleDAO sampleDao) {
		this.sampleDao = sampleDao;
	}
		
	@Transactional
	public List<Sample> list() {
		List<Sample> sampleList = sampleDao.selectAll();
		return sampleList;
	}

	public List<Sample> listPagination() {
		List<Sample> sampleList = dao.selectPage();
		for(Sample sample :sampleList) {
			System.out.println(sample.getS_name());
			System.out.println(sample.getS_no());
		}
		return sampleList;
	}
}
