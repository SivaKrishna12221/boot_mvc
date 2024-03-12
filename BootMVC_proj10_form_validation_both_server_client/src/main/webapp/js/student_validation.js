/*Student form validation for both edit form and add form */

function studValidate(frm) {
	document.getElementById("name_err").innerHTML="";
	document.getElementById("course_err").innerHTML="";
	document.getElementById("age_err").innerHTML="";
	document.getElementById("mobile_err").innerHTML="";
	document.getElementById("fees_err").innerHTML="";

	let sname = frm.name.value;
	let scourse = frm.course.value;
	let sage = frm.age.value;
	let smobile = frm.mobile.value;
	let sfees = frm.fees.value;

	let validationFlag = true;
	if (sname == "") {
		document.getElementById('name_err').innerHTML = "name is required(cs)";
		validationFlag = false;
	}
	else if (sname.length() < 6 || sname.length() > 20) {
		document.getElementById('name_err').innerHTML = "name must be in range b/t 6 to 20 chars(cs)";
		validationFlag = false;
	}
	else
	{
		frm.validateFlag.value='yes';
		}
	if (scourse == "" || scourse == null) {
		document.getElementById('course_err').innerHTML = "course is required(cs)";
		validationFlag = false;
	}
	else if (scourse.length() < 6 || scourse.length() > 20) {
		document.getElementById('course_err').innerHTML = "course name must be in range b/t 6 to 20 chars(cs)";
		validationFlag = false;
	}

	if (sage == "" || sage == null) {
		document.getElementById('age_err').innerHTML = "age is required(cs)";
		validationFlag = false;
	}
	else if (isNaN(sage)) {
		document.getElementById('age_err').innerHTML = "age must be numeric(cs)";
		validationFlag = false;
	}
	

	else if (sage < 20 || sage > 30) {
		document.getElementById('age_err').innerHTML = "age must be in range (cs)";
		validationFlag = false;
	}
	
	if (smobile == "" || smobile == null) {
		document.getElementById('mobile_err').innerHTML = "mobile number is required(cs)";
		validationFlag = false;
	}
	else if (smobile.length() != 10) {
		document.getElementById('mobile_err').innerHTML = "mobile number contain 10 numbers(cs)";
		validationFlag = false;
	}
   
	if (sfees == "") {
		document.getElementById('fees_err').innerHTML = "fees is required(cs)";
		validationFlag = false;
	}
	else if (isNaN(sfees)) {
		document.getElementById('fees_err').innerHTML = "fees must be numeric(cs)";
		validationFlag = false;
	}
	else if (sfees < 10000 || sfees > 50000) {
		document.getElementById('fees_err').innerHTML = "fees must be in range b/t 10000 and 50000 required(cs)";
		validationFlag = false;
	}
	
	return validationFlag;
}
