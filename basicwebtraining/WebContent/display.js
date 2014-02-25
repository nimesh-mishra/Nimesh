function getCookie(){
	document.getElementById("Firstname").innerHtml=getCookie("firstname").String;
	document.getElementById("Lastname").innerHtml=getCookie("lastname");
	document.getElementById("Age").innerHtml=getCookie("age");
	if (age<14){
		maturity="Child";
	}
		else if (age>=14 && age<=19){
			maturity="Teen";
		}
		else if (age>19 && age<45){
			maturity="Youth";
		}
		else if(age>=45){
			maturity="Old";
		}
	document.getElementById("Maturity").innerHtml=maturity;
}