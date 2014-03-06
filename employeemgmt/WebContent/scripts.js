function validateForm(){
  var fields = ["firstName", "lastName", "gender", "age", "country", "zone", "district","vdcMnc","dept"]

  var i, l = fields.length;
  var fieldname;
  for (i = 0; i < l; i++) {
    fieldname = fields[i];
    if (!document.forms["addEmployee"][fieldname].value.match(/^[A-Za-z]/)) {
      alert(fieldname + " Cant be other than alphabets.");
      return false;
    }
    else if(document.forms["addEmployee"]["age"].value.match(/^[0-9]/)){
    	alert("age can't be alphabetic");
    	return false;
    }
  }
  return true;
}
function clearThis(target){
    target.value= "";
}