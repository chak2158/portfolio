package com.goupang.www.dao.manager;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.member.Member;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.seller.Seller;
import com.goupang.www.dto.seller.SellerRequest;

@Mapper
public interface ManagerDAO {

	List<Seller> selectSellerList() throws Exception;/* 이 인터페이스의 이름을 맵퍼(TB_Board_SQL.xml)의 id와 맞춰줌 */

	List<Product> selectBySellerNo(int sellerNo) throws Exception;

	void updateSeller(SellerRequest selReq) throws Exception;

	void deleteSeller(int sellerNo) throws Exception;

	List<Member> selectMemberList() throws Exception;

	List<Member> selectByMemberName(String memberName) throws Exception;

	void updateMember(Member member) throws Exception;

	void deleteMember(int memberNo) throws Exception;

	//전체 수
	int MemberCnt();
	
	//시작, 페이지 크기 
	List<Member> MemberList2(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize) throws Exception;
	

}
