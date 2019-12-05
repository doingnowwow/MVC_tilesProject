/**
 * "a001".validationID()
 * 정규식 패턴 작성 : http://ryanswanson.com/regexp/#start
 */
String.prototype.validationID = function(){
	return /^[a-z][0-9]{3}$/.test(this);
};

String.prototype.validationPWD = function(){
	return /^[a-z0-9]{4,8}$/.test(this);
};

String.prototype.validationNM = function(){
	return /^[가-힣]{2,3}$/.test(this);
};

String.prototype.validationREGNO = function(){
	// 1 1 1 1 1 1 - 1 1 1 1 1 1           8
	// * * * * * *   * * * * * *
	// 2+3+4+5+6+7+8+9+2+3+4+5 = 연산결과  매직넘버
	// (11-(연산결과 % 11)) % 10 = 최종값
	// if(최종값 == 매직넘버) 유효한 주민등록번호
//	var moto = this.replace('-', '');
//	var magicNumber = moto.substr(12, 1);
//	var sequenceValue = '234567892345';
//	var sum = 0;
//
//	for (var i = 0; i < 12; i++) {
//	   sum += moto.charAt(i) * sequenceValue.charAt(i);
//	}
//	var finalValue = (11 - (sum % 11)) % 10;
//	   
//	if (finalValue == parseInt(magicNumber)) {
//	   return true;
//	} else {
//	   return false;
//	}
	
	sum = 0;
	res = 0;
	resf = "";
	
	nums = this.replace("-","");
	
	for(i = 0; i <= 7; i++){
		sum += nums.charAt(i)*(i + 2);
	}
	
	for(i = 8; i <= 11; i++){
		sum += nums.charAt(i)*(i - 6);
	}
	
	b = sum%11;
	c = 11-b;
	
	if(0 <= c || c <= 9) res = c;
	else if(c == 10) res = 0;
	else if(c == 11) res = 1;
	
	if(res == nums.charAt(12)) return true;
	else return false;
};

String.prototype.validationBIR = function(){
	return /^(19[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/.test(this);
};

String.prototype.validationHOMETEL = function(){
	return /^0\d{1,2}-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationCOMTEL = function(){
	return /^0\d{1,2}-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationHP = function(){
	return /^01(0|1|6|7|8|9)-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationMAIL = function(){
	return /^\w+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};

String.prototype.validationDONG = function(){
	return /^[가-힣]{2,20}$/.test(this);
};