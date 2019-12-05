/**
 * "a001".validationID()
 * 정규식 패턴 작성 : http://ryanswanson.com/regexp/#start
 */
String.prototype.validationID = function(){
	return /^\d{3}-\d{2}-\d{5}$/.test(this);
};

String.prototype.validationPWD = function(){
	return /^[a-z0-9]{8,20}$/.test(this);
};

String.prototype.validationNM = function(){
	return /^[가-힣]{2,4}$/.test(this);
};

String.prototype.validationBIR = function(){
	return /^(19[0-9][0-9]|20\d{2})-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/.test(this);
};

String.prototype.validationHP = function(){
	return /^01(0|1|6|7|8|9)-\d{3,4}-\d{4}$/.test(this);
};

String.prototype.validationMAIL = function(){
	return /^\w+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};

String.prototype.validationNN = function(){
	return /^[가-힣a-zA-Z]{2,8}$/.test(this);
};