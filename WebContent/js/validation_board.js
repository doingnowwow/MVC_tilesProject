/**
 * 
 */
String.prototype.validationTITLE = function(){
	return /^[가-힣a-zA-Z0-9\s]{1,33}$/.test(this);
};

String.prototype.validationPW = function(){
	return /^[a-z0-9]{4,20}$/.test(this);
};

String.prototype.validationNN = function(){
	return /^[가-힣a-zA-Z0-9]{1,33}$/.test(this);
};

String.prototype.validationMAIL = function(){
	return /^\w+@[a-z]+(\.[a-z]+){1,2}$/.test(this);
};

String.prototype.validationCONTENT = function(){
	return /^[가-힣a-zA-Z0-9]+$/.test(this);
};
