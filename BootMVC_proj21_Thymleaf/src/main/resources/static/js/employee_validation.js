/**
 * 
 */
function validate_emp(emp) {
	let empname = emp.ename.value;
	let empjob = emp.job.value;
	let empsal = emp.sal.value;
	let empdeptno = emp.deptno.value;
	let vflag =true;
	if (empname == "") {
		document.getElementById("enameErr").innerHtml = "(cs)ename is required";
		vflag=false;
	}else if(empname.length()<6||empname.length()>20)
	{
		document.getElementById("enameErr").innerHTML="(cs) ename length in between 6 and 20";
		vflag=false;
	}
	if(empjob=="")
	{ 
		document.getElementById("jobErr").innerHTML="(cs) emp job required";
		vflag=false;
	}
	else if(empjob.length()<6||empjob.length()>20)
	{
		document.getElementById("jobErr").innerHTML="(cs) job name length in between 6 and 20";
		vflag=false;
	}
	if(empsal=="")
	{
		document.getElementById("salErr").innerHTML="(cs)sal is required";
		vflag=false;
		}
	else if(isNaN(empsal))
	{
		document.getElementById("salErr").innerHTML="(cs) salary must be numeric";
		vflag=false;
	}
	else if(empsal<10000||empsal>50000)
	{
		document.getElementById("salErr").innerHTML="(cs) sal must be in a range between 10000 and 50000";
		vflag=false;
	}
	if(empdeptno=="")
	{
		document.getElementById("deptnoErr").innerHTML="(cs) deptno is required";
		vflag=false;
	}
   else if(isNaN(empdeptno))
   {
	   document.getElementById("deptnoErr").innerHTML="(cs) deptno must be numeric";
	   vflag=false;
   }
   else if(empdeptno<10||empdeptno>100)
   {
	   document.getElementById("deptnoErr").innerHTML="(cs) deptno range in between 10 and 100";
	   vflag=false;
	}
	emp.activate.value="yes";
	return vflag;

}
