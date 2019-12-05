package kr.or.ddit.user.company.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CompanyVO;

public interface CompanyService {
	public CompanyVO companyInfo(Map<String, String> params);
	
	public void insertCompanyInfo(CompanyVO companyInfo);
	
	public void updateCompanyInfo(CompanyVO companyInfo);
	
	public void deleteCompanyInfo(Map<String, String> params);
	
	public String searchId(Map<String,String>params);
	
	public String searchPwd(Map<String,String>params);
	
	// 멤버리스트
	public List<CompanyVO> companyList(Map<String, String> params)	;

	// 멤버리스트 파람없는거
	public List<CompanyVO> companyList() ;
}
