package kr.or.ddit.user.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface MemberDao {

	// 멤버 정보 불러오기
	public MemberVO memberInfo(Map<String, String> params) throws SQLException;

	// 멤버리스트
	public List<MemberVO> memberList(Map<String, String> params)	throws SQLException;

	// 멤버리스트 파람없는거
	public List<MemberVO> memberList() throws SQLException;

	// 회원가입
	public void insertMemberInfo(MemberVO memberInfo) throws SQLException;

	// 정보수정
	public void updateMemberInfo(MemberVO memberInfo) throws SQLException;

	// 회원탈퇴
	public void deleteMemberInfo(Map<String, String> params) throws SQLException;
	
	// 중복아이디 찾기
	public String checkId(String input_id) throws SQLException; 
	
	public String searchId(Map<String,String>params) throws SQLException ;
	
	public String searchPwd(Map<String,String>params) throws SQLException ;
	
	//페이지네이션
	public String totalCount(Map<String, String> params) throws SQLException;

}
