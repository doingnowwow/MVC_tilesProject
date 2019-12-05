package kr.or.ddit.user.zipcode.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.zipcode.dao.IZipCodeDao;
import kr.or.ddit.user.zipcode.dao.IZipCodeDaoImpl;
import kr.or.ddit.vo.ZipcodeVO;

public class IZipCodeServiceImpl implements IZipCodeService {

	private static IZipCodeService service = new IZipCodeServiceImpl();
	private IZipCodeDao dao;

	private IZipCodeServiceImpl() {
		dao = IZipCodeDaoImpl.getInstance();
	}

	public static IZipCodeService getInstance() {
		return (service == null) ? service = new IZipCodeServiceImpl()
				: service;
	}

	public List<ZipcodeVO> zipcodeList(Map<String, String> params) {
		List<ZipcodeVO> zipcodeList = null;
		try {
			zipcodeList = dao.zipcodeList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}
}
