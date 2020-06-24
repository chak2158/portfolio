package com.goupang.www.service.order;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goupang.www.dao.order.OrderDAO;
import com.goupang.www.dto.order.Order;


@Service
@Transactional
public class OrderListService {
	
	@Autowired
	private OrderDAO orderDAO;

	
	public List<Order> orderListAll(long memberNo) throws Exception {
		System.out.println("OrderListService");
		System.out.println("Service => memberNo" + memberNo);
		return orderDAO.selectAllOrderList(memberNo);
	}

	/*
	 * public List<Order> selectByMemberNo(long memberNo) throws Exception { return
	 * orderDAO.selectByMemberNo(memberNo); }
	 */


}
