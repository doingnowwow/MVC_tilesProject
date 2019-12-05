package kr.or.ddit.user.zipcode.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ZipcodeVO;

public interface IZipCodeService {

   public List<ZipcodeVO> zipcodeList(Map<String, String> params);
}