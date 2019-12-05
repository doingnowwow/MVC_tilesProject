package kr.or.ddit.base.uri.mapper;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

//클라이언트의 요청시 서블릿 패스와 맵핑(properties)되는 커맨드 컨트롤러 데이터를 Map으로 정리 및 반환
public class URIHandlerMapper {
	private static Map<String, String> actionMap = new HashMap<String, String>();
	
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("kr.or.ddit.base.uri.mapper.servletPathData");
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()){
			//ServletPath
			String key = keys.nextElement();
			
			//해당 ServletPath를 처리할 커맨드 컨트롤러의 패키지명.클래스명
			String value = bundle.getString(key);
			
			actionMap.put(key, value);
		}
	}
	
	public static Map<String, String> getActionMap(){
		return actionMap;
	}
}
