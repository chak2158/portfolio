package com.goupang.www.dao.inquiry;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.inquiry.Inquiry;
import com.goupang.www.dto.inquiry.InquiryReply;
//마이바티스가 알아서impl 만들어서 맵핑해줘서 빈등록 필요없음(아마 마이바티스랑 스프링 연동해주는 라이브러리가 해주는듯) 
public interface InquiryDAO {
 
    //List<Inquiry> selectInquiryList(@Param("productNo") int productNo) throws Exception;/*이 메소드의 이름을 맵퍼(TB_Board_SQL.xml)의 id와 맞춰줌*/
    List<Inquiry> selectInquiryList(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize,@Param("productNo") int productNo) throws Exception;
    List<InquiryReply> selectInquiryReplyListByInquiryNo(@Param("inquiryNo") int inquiryNo) throws Exception;
    void insertInquiry(
    		@Param("memberNo") int memberNo,
    		@Param("productNo") int productNo,
    		@Param("inquiryTitle") String inquiryTitle,
    		@Param("inquiryContent") String inquiryContent
    		) throws Exception;
	List<Inquiry> selectInquiryByInquiryNo(@Param("inquiryNo")int inquiryNo);
	void updateInquiry(
			@Param("inquiryContent") String inquiryContent,
			@Param("inquiryNo") int inquiryNo
			);
	void deleteInquiry(@Param("inquiryNo")int inquiryNo)throws Exception;
	 void insertInquiryReply(
    		@Param("sellerNo") int sellerNo,
    		@Param("inquiryNo") int inquiryNo,
    		@Param("replyContent") String replyContent
    		) throws Exception;
	int selectInquiryCnt(int productNo);
}
