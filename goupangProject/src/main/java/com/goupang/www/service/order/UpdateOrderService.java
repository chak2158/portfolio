package com.goupang.www.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goupang.www.dao.order.OrderDAO;
import com.goupang.www.dto.order.Order;

@Service
public class UpdateOrderService {
	
	@Autowired
	private OrderDAO orderDAO;
	
	public void confirmOrder(Order order) throws Exception{
		System.out.println("UpdateOrderService");
		orderDAO.confirmOrderUpdate(order);	
	}
	
	public void refundOrder(Order order) throws Exception{
		orderDAO.refundOrderUpdate(order);
		
	}
	public void cancelOrder(Order order) throws Exception{
		orderDAO.cancelOrderUpdate(order);
		
	}

}
