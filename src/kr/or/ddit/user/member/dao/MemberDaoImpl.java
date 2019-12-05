package kr.or.ddit.user.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao dao = new MemberDaoImpl();
	
	private SqlMapClient client;
	
	private MemberDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
		
	}
	
	public static MemberDao getInstance(){
		
		return(dao == null)? dao = new MemberDaoImpl() : dao;
	}
	
	
	

	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		return (MemberVO) client.queryForObject("member.memberInfo",params);
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("member.memberList",params);
	}

	@Override
	public List<MemberVO> memberList() throws SQLException {
		
		return client.queryForList("member.memberList");
	}

	@Override
	public void insertMemberInfo(MemberVO memberInfo) throws SQLException {
		client.insert("member.insertMember",memberInfo);


	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) throws SQLException {
		client.update("member.updateMember",memberInfo);

	}

	@Override
	public void deleteMemberInfo(Map<String, String> params)
			throws SQLException {
		client.update("member.deleteMember",params);
	}

	@Override
	public String checkId(String input_id) throws SQLException {
		 return (String) client.queryForObject("member.checkId",input_id);
	}

	@Override
	public String searchId(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("member.searchId",params);
	}

	@Override
	public String searchPwd(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("member.searchPwd",params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		
		return (String) client.queryForObject("member.totalCount",params);
	}

}
