function validateForm() {
	
//	alert("running js");
	var alphaRule = /^[a-zA-Z]*$/;
	var numericRule = /^[0-9]*$/;
	var firstName = document.addEmployee.firstName;
	var lastName = document.addEmployee.lastName;
	var middleName = document.addEmployee.middleName;
	var gender = document.addEmployee.gender;
	var age = document.addEmployee.age;
	var country = document.addEmployee.country;
	var zone = document.addEmployee.zone;
	var district = document.addEmployee.district;
	var vdcMnc = document.addEmployee.vdcMnc;
	var dept = document.addEmployee.dept;
	var alphabetFields = [ firstName, lastName, gender, country,
	                       zone, district, vdcMnc, dept ];
	var i;
	var length = alphabetFields.length;
	var fieldName;

	for (i = 0; i < length; i++) {
		fieldName = alphabetFields[i];
		if (fieldName.value == "") {
			alert(getFieldsName(i) + " can't be empty");
			return false;
		}
	}
	if (age.value == "" || age.value.contains("Enter")) {
		alert(" Age can't be empty");
		return false;
	}
	for (i = 0; i < length; i++) {
		fieldName = alphabetFields[i];
		if (!alphaRule.test(fieldName.value)) {
			alert(getFieldsName(i)+" can't contain digits or special characters");
			return false;
		}
	}
	if(middleName.contains("Enter")){
		document.addEmployee.middleName="";
	}
	if (!numericRule.test(age.value)) {
		alert("age can't contain alphabets");
		return false;
	}
//	
//	var submitButton=document.getElementById("submit");
//	submitButton.onclick=handleSubmitButton();
//	var submitAndAddButton=document.getElementById("submit-and-add");
//	submitAndAddButton.onclick=handleSubmitAndAddButton();
	return true;
}

function getFieldsName(i){
	if(i==0){
		return "First Name";
	}
	if(i==1){
		return "Middle Name";
	}
	if(i==2){
		return "Last Name";
	}
	if(i==3){
		return "Gender";
	}
	if(i==4){
		return "Age";
	}
	if(i==5){
		return "Country";
	}
	if(i==6){
		return "Zone";
	}
	if(i==7){
		return "District";
	}
	if(i==8){
		return "VDC/MNC";
	}
	if(i==9){
		return "Department";
	}
}

function clearThis(target) {
	target.value = "";
}

function deleteRecord(id){
	my_form=document.createElement('FORM');
	my_form.name='deleteForm';
	my_form.method='POST';
	my_form.action='EmployeeControllerServlet';

	my_tb=document.createElement('INPUT');
	my_tb.type='HIDDEN';
	my_tb.name='deleteButtonId';
	my_tb.value=id;
	my_form.appendChild(my_tb);
	document.body.appendChild(my_form);
	my_form.submit();
}
function editRecord(id){
	my_form=document.createElement('FORM');
	my_form.name='editForm';
	my_form.method='POST';
	my_form.action='EmployeeControllerServlet';

	my_tb=document.createElement('INPUT');
	my_tb.type='HIDDEN';
	my_tb.name='editButtonId';
	my_tb.value=id;
	my_form.appendChild(my_tb);
	document.body.appendChild(my_form);
	my_form.submit();
}
/*
function submitForm(event){
	var whichButton=event.target.name;
	alert(whichButton);
	if(whichButton.matches("submit")){
		handleSubmitButton(event);
	}
	else{
		handleSubmitAndAddButton(event);
	}
}
function handleSubmitButton(e){
	alert("in handleSubmitButton");
	var form=document.getElementById("addEmployee");
	form.action="com/lftechnology/employee/controller/AddEmployeeController";
	form.method="post";
	form.submit();
}

function handleSubmitAndAddButton(e){
	alert("in handleSubmitAndAddButton");
	var form=document.getElementById("addEmployee");
	form.action="com/lftechnology/employee/controller/AddMoreEmployeeController";
	form.method="post";
	form.submit();
	
} 
*/