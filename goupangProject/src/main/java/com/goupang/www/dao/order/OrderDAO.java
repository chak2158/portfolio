package com.goupang.www.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.order.Order;
import com.goupang.www.dto.order.OrderProduct;
import com.goupang.www.dto.order.OrderRequest;



public interface OrderDAO {

	//주문 전체 목록
	List<Order> selectAllOrderList(@Param("memberNo")long memberNo) throws Exception;
	
	//주문 날짜 별 회원 주문 목록
	
	//구매확정된 주문
	void confirmOrderUpdate(Order order) throws Exception;
	
	//반품신청된 주문
	void refundOrderUpdate(Order order) throws Exception;
	
	//구매취소된 주문
	void cancelOrderUpdate(Order order) throws Exception;

	//주문창 회원 폰번호 수정
	void modifyMemberPhone(int memberNo) throws Exception;

	//주문창에 보여줄 member정보
	List<Member> memberInfo(int memberNo) throws Exception;

	//장바구니에서 넘어갈 주문정보
	int insertOrder(OrderRequest orderRequest) throws Exception;

	//주문된 장바구니 삭제
	int deleteCart(@Param("productNo")int productNo,@Param("memberNo") int memberNo) throws Exception;



	
}
