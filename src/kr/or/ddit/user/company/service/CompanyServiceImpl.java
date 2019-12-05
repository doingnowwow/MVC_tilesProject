package kr.or.ddit.user.company.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.company.dao.CompanyDao;
import kr.or.ddit.user.company.dao.CompanyDaoImpl;
import kr.or.ddit.vo.CompanyVO;

public class CompanyServiceImpl implements CompanyService {

	private static CompanyService service = new CompanyServiceImpl();
	
	private CompanyDao dao;
	
	private CompanyServiceImpl(){
		dao = CompanyDaoImpl.getInstance();
	}
	
	public static CompanyService getInstance(){
		return (service == null) ? service = new CompanyServiceImpl() : service;
	}
	
	@Override
	public void insertCompanyInfo(CompanyVO companyInfo) {
		try {
			dao.insertCompanyInfo(companyInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CompanyVO companyInfo(Map<String, String> params) {
		CompanyVO vo = new CompanyVO();
		try {
			vo = dao.companyInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
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
	public void updateCompanyInfo(CompanyVO companyInfo) {
		try {
			dao.updateCompanyInfo(companyInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCompanyInfo(Map<String, String> params) {
		try {
			dao.deleteCompanyInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CompanyVO> companyList(Map<String, String> params)
			 {
		List<CompanyVO> companyList = null;
		
		try {
			companyList = dao.companyList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return companyList;
	}

	@Override
	public List<CompanyVO> companyList()  {
		List<CompanyVO> companyList = null;
		
		try {
			companyList = dao.companyList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return companyList;
	}
}
