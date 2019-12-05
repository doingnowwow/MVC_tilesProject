package kr.or.ddit.user.company.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.CompanyVO;

public class CompanyDaoImpl implements CompanyDao {
	
	private static CompanyDao dao = new CompanyDaoImpl();
	
	private SqlMapClient client;
	
	private CompanyDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static CompanyDao getInstance(){
		return (dao == null) ? dao = new CompanyDaoImpl() : dao;
	}

	@Override
	public void insertCompanyInfo(CompanyVO companyInfo) throws SQLException {
		client.insert("company.insertCompany", companyInfo);
	}

	@Override
	public CompanyVO companyInfo(Map<String, String> params) throws SQLException {
		return (CompanyVO) client.queryForObject("company.companyInfo", params);
	}

	@Override
	public String searchId(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("company.searchId",params);
	}

	@Override
	public String searchPwd(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("company.searchPwd",params);
	}

	@Override
	public void updateCompanyInfo(CompanyVO companyInfo) throws SQLException {
		client.update("company.updateCompany", companyInfo);
	}

	@Override
	public void deleteCompanyInfo(Map<String, String> params)
			throws SQLException {
		client.update("company.deleteCompany", params);
	}

	@Override
	public List<CompanyVO> companyList(Map<String, String> params)
			throws SQLException {
		
		return client.queryForList("company.companyList",params);
	}

	@Override
	public List<CompanyVO> companyList() throws SQLException {
		return client.queryForList("company.companyList");
	}

}
