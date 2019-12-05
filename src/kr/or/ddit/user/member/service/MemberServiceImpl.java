package kr.or.ddit.user.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.member.dao.MemberDao;
import kr.or.ddit.user.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	// 싱글톤

	private static MemberService service = new MemberServiceImpl();

	private MemberDao dao;

	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	public static MemberService getInstance() {
		return (service == null) ? service = new MemberServiceImpl() : service;
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;

		try {
			memberInfo = dao.memberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) {
		List<MemberVO> memberList = null;
		try {
			memberList = dao.memberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> memberList = null;

		try {
			memberList = dao.memberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public void insertMemberInfo(MemberVO memberInfo) {
		try {
			dao.insertMemberInfo(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) {

		try {
			dao.updateMemberInfo(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) {
		try {
			dao.deleteMemberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String checkId(String input_id) {
		String checkId = null;
		try {
			checkId = dao.checkId(input_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkId;
	}

	@Override
	public String searchId(Map<String, String> params) {
		String searchId = null;

		try {
			searchId = dao.searchId(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchId;
	}

	@Override
	public String searchPwd(Map<String, String> params) {
		String searchPwd = null;

		try {
			searchPwd = dao.searchPwd(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchPwd;

	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "0";

		try {
			totalCount = dao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return totalCount;
	}
}
