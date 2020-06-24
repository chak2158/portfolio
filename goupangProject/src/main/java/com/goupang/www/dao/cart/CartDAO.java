package com.goupang.www.dao.cart;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.goupang.www.dto.cart.Cart;
import com.goupang.www.dto.order.OrderCommand;
import com.goupang.www.dto.product.Product;

public interface CartDAO {

	// 카트번호로 카트정보 받기
	//List<Product> cartNoInfo(int cartNo) throws Exception;

	//세션에 memberNo 받아 장바구니 리스트 보여주기
	List<Cart> memberCartList(long memberNo) throws Exception;

	// 장바구니 전체 목록
	List<Cart> selectAllCartList() throws Exception;

	// void insertCart(@Param("num")int num) throws Exception;

	// 회원번호 별 장바구니 목록
	List<Cart> selectByMemberNo(@Param("memberNo") int memberNo) throws Exception;

	//장바구니상품 수량 체크
	List<Integer> checkMemberHasCart(Cart cart) throws Exception;
//	
	
	// 장바구니 추가
//	int insertCart(
//			@Param("memberNo") int memberNo,
//			@Param("productNo") int productNo,
//			@Param("orderQty") int orderQty
//			) throws Exception;

	// 장바구니 리스트에서의 수량 수정
	// int updateCart(@Param("cartNo")int cartNo) throws Exception;
	void updateCart(Cart cart) throws Exception;

	// 장바구니 삭제
	void deleteCart(@Param("cartNo") int cartNo) throws Exception;

	OrderCommand selectCartByCartNo(@Param("cartNo") int cartNo);

	//카트 수량 가져오기
	int cartQty(int cartNo) throws Exception;

	
	//기존 장바구니 수량업데이트
	void addQty(@Param("newQty")int newQty,@Param("cartNo")int cartNo ) throws Exception;

	//장바구니 추가
	int addNewCart(@Param("memberNo")int memberNo, @Param("productNo")int productNo, @Param("orderQty")int orderQty) throws Exception;

}
