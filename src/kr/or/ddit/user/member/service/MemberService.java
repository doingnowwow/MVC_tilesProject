package kr.or.ddit.user.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface MemberService {

	// 멤버 정보 불러오기
	public MemberVO memberInfo(Map<String, String> params);

	// 멤버리스트
	public List<MemberVO> memberList(Map<String, String> params);

	// 멤버리스트 파람없는거
	public List<MemberVO> memberList();

	// 회원가입
	public void insertMemberInfo(MemberVO memberInfo);

	// 정보수정
	public void updateMemberInfo(MemberVO memberInfo);

	// 회원탈퇴
	public void deleteMemberInfo(Map<String, String> params);
	

	// 중복아이디 찾기
	public String checkId(String input_id) ; 
	
	//아이디찾기
	public String searchId(Map<String,String>params) ;
	
	public String searchPwd(Map<String,String>params)  ;
	
	public String totalCount(Map<String, String> params);

}
