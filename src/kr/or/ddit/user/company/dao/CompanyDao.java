package kr.or.ddit.user.company.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CompanyVO;
import kr.or.ddit.vo.MemberVO;

public interface CompanyDao {
	public CompanyVO companyInfo(Map<String, String> params) throws SQLException;
	
	public void insertCompanyInfo(CompanyVO companyInfo) throws SQLException;
	
	public void updateCompanyInfo(CompanyVO companyInfo) throws SQLException;

	public void deleteCompanyInfo(Map<String, String> params) throws SQLException;

	public String searchId(Map<String,String>params) throws SQLException ;
	
	public String searchPwd(Map<String,String>params) throws SQLException ;
	
	// 멤버리스트
	public List<CompanyVO> companyList(Map<String, String> params)	throws SQLException;

		// 멤버리스트 파람없는거
	public List<CompanyVO> companyList() throws SQLException;
}

