function validateForm(){
  var fields = ["firstName", "lastName", "compname", "mail", "compphone", "adres", "zip"]

  var i, l = fields.length;
  var fieldname;
  for (i = 0; i < l; i++) {
    fieldname = fields[i];
    if (document.forms["addEmployee"][fieldname].value === "") {
      alert(fieldname + " can not be empty");
      return false;
    }
    else if(document.forms["addEmployee"]["age"].value<=18){
    	alert("age can't be less than 18");
    	return false;
    }
  }
  return true;
}
function clearThis(target){
    target.value= "";
}