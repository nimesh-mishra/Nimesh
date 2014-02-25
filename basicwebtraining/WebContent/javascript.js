function setCookie(){
	var fname = document.getElementById("firstname").value;
	var lname = document.getElementById("lastname").value;
	var age = document.getElementById("age").value;

	var maturity = "";
	if (age < 14) {
		maturity = "Child";
	} else if (age >= 14 && age <= 19) {
		maturity = "Teen";
	} else if (age > 19 && age < 45) {
		maturity = "Youth";
	} else if (age >= 45) {
		maturity = "Old";
	}
	/*document.getElementById('my-name').innerHTML="Your First name is:"+fname+" "+lname;
	document.getElementById("AGE").innerHTML="Your Age is : "+age;
	document.getElementById("mature").innerHTML="You are  : "+maturity;
	document.getElementById("formdiv").style.visibility="hidden";*/
	
	document.cookie="FirstName="+fname+";";
	document.cookie="LastName="+lname+";";
	document.cookie="Age="+age+";";
	document.cookie="Maturity="+maturity+";";
	
	document.getElementById('my-name').innerHTML="Your First name is:"+getCookie('FirstName')+" "+getCookie('LastName').String;
	document.getElementById("AGE").innerHTML="Your Age is : "+getCookie('Age');
	document.getElementById("mature").innerHTML="You are  : "+getCookie('Maturity');
	document.getElementById("formdiv").style.visibility="hidden";
			
	
	}

function getCookie(cookieName){
	var allcookies = document.cookie;
	var Map={};
	   cookiearray  = allcookies.split(';');
	   for(var i=0;i<cookiearray.length;i++){
		   Map[cookiearray[i].split('=')[0]]=cookiearray[i].split("=")[1];
		   alert(Map[cookiearray[i].split('=')[0]]);
	   }
	   /*for(var i=0;i<nameValue.length;i++){
		  
		   alert(Map[nameValue[i][0]]);
	   }*/
	   if(cookieName in Map){
		   return Map[cookieName];
	   }
	   
	   /*for(var i=0;i<nameValue.length;i++){
		   alert(nameValue[i][0]+":"+nameValue[i][1]);
		   var name=nameValue[i][0];
		   var value=nameValue[i][1];
		   if(cookieName==name){
			   return value;
		   }
	   }*/
	  /* for(var i=0; i<cookiearray.length; i++){
	      name = cookiearray[i].split('=')[0];
	      if(name==cookieName){
	    	  value = cookiearray[i].split('=')[1];
	    	  break;
	      }
	   }*/
	   return "";
}
