package com.goupang.www.service.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.order.OrderDAO;
import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.order.OrderProduct;
import com.goupang.www.dto.order.OrderRequest;

@Service
@Transactional
public class OrderFormService {

	@Autowired
	private OrderDAO orderDAO;

	public int insertOrderProduct(Map<String, Object> params) throws Exception {
		System.out.println("insertOrderProduct");
		System.out.println("params ->"+ params);
		List<OrderRequest> list = makeRequest(params);
		System.out.println("list : " + list);
		for(OrderRequest or : list) {
			orderDAO.insertOrder(or);
			System.out.println("or: " + or);
			orderDAO.deleteCart(or.getOrderProduct().getProductNo(),or.getMemberNo());
			System.out.println(or);
		}
		return 1;
	}

	private List<OrderRequest> makeRequest(Map<String, Object> params) {

		List<OrderRequest> list = new ArrayList<OrderRequest>();  
		System.out.println("params: >>>>>>>>>> " + params );
		System.out.println("params.get(\"orderProductArr\") >>>>>>>>>>>>>>>> " + params.get("orderProductArr"));

		List products = (List)params.get("orderProductArr");
		
		for(Object obj : products) {

			Map orderProduct = (Map) obj;
		
			OrderProduct op = new OrderProduct(Integer.parseInt((String)orderProduct.get("productNo")), 
					Integer.parseInt((String)orderProduct.get("orderQty"))); 
			System.out.println("OrderProduct >>>>>>>>>>>>>>  " +  op);
			OrderRequest or = new OrderRequest(Integer.parseInt((String)params.get("memberNo")), 
											op, Integer.parseInt((String)params.get("paymentNo")), 
											(String)params.get("addr"));
			System.out.println("OrderRequest >>>>>>>>>>>>>>  " +  or);
			list.add(or); 
		}
		return list;
	}

	public List<Member> memberInfo(int memberNo) throws Exception {
		System.out.println("orderFormService");
		return orderDAO.memberInfo(memberNo);
	}


	
}
