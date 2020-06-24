package com.goupang.www.dao.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.manager.Manager;
import com.goupang.www.dto.member.Member;
//마이바티스가 알아서impl 만들어서 맵핑해줘서 빈등록 필요없음(아마 마이바티스랑 스프링 연동해주는 라이브러리가 해주는듯) 
import com.goupang.www.dto.seller.Seller;
public interface MemberDAO {
	//이메일만 뽑음
	List<Member> selectByEmail(@Param("memberEmail") String memberEmail);
	//멤버 정보 뽑음
	List<Member> selectMemberByEmail(@Param("memberEmail") String memberEmail);
    void insertMember(
    		@Param("memberEmail") String memberEmail,
    		@Param("memberPw") String memberPw,
    		@Param("memberName") String memberName,
    		@Param("memberPhone") String memberPhone
    		);
	List<Member> selectMemberByMemberNo(@Param("memberNo")int memberNo);
	List<Manager> selectManagerByManagerId(@Param("managerId")String managerId);
	void insertManager(@Param("managerId")String managerId,@Param("managerPw")String managerPw);
	List<Seller> selectSellerBySellerId(@Param("sellerId")String sellerId);
	void insertSeller(
			@Param("sellerLicenseNumber")int sellerLicenseNumber,
			@Param("sellerCompanyName")String sellerCompanyName,
			@Param("sellerName")String sellerName,
			@Param("sellerId")String sellerId,
			@Param("sellerPw")String sellerPw,
			@Param("sellerPhone")String sellerPhone,
			@Param("sellerAddr")String sellerAddr
			);
}
