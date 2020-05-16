var rules = {
    color: /^#[0-9A-F]{6}$/i,
    email: /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i,
    isoDate: /^(\d{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/,
    number: /^-?\d*\.?\d*$/,
    time: /^([01][0-9]|2[0-3])(:([0-5][0-9])){2}$/,
    url: /^\s*https?:\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?\s*$/,
    username: /^[0-9a-z_A-Z]{4,30}$/,
    password: /^.{6,30}$/
}

$(function() {
	$("#signinform").submit(function(){return validateSignin($(this))});
	$("#signupform").submit(function(){return validateSignup($(this))});
	
	$("#signinform input").keypress(function(event){
		switch(event.keyCode) {
			case 13: 
				$("#signinform").submit();
				break;
		}
	});
	
	$("input[name=username]").focus();
});

function signup(obj, formid) {
	var form = $("#"+formid);
	
	//if(validateSignup(form)) {
	if(!$(obj).hasClass("reg_but2-disable")) {
		$(obj).addClass("reg_but2-disable");
		//alert($("div.reg_regmsg_table *").add($("div.reg_m2_tabcontent > div:visible").find("*")).serialize());
		form.submit();
		$(obj).removeClass("reg_but2-disable");
	}
}

function validateSignup(form) {
	var type = form.find("input[name='type']").val();
	
	var username = form.find("input[name=userName]");
	if ($.trim(username.val()) == "") {
		alert("帐号不能为空jjjjj！");
		username.focus();
		return false;
	} else if (!rules.username.test(username.val())) {
		alert("帐号格式不正确，请输入4~30个字符（可使用字母、数字、下划线）！");
		username.focus();
		return false;
	}
	
	var password = form.find("input[name=password]");
	if ($.trim(password.val()) == "") {
		alert("密码不能为空！");
		password.focus();
		return false;
	} else if (!rules.password.test(password.val())) {
		alert("密码格式不正确，请输入6~30个字符！");
		password.focus();
		return false;
	}
	
	var password2 = form.find("input[name=password2]");
	if ($.trim(password2.val()) == "") {
		alert("确认密码不能为空！");
		password2.focus();
		return false;
	}
	
	if (password.val() != password2.val()) {
		alert("2次输入的密码不匹配！");
		password2.focus();
		return false;
	}
	
	var email = form.find("input[name=email]");
	if ($.trim(email.val()) == "") {
		alert("电子邮件不能为空！");
		email.focus();
		return false;
	} else if (!rules.email.test(email.val())) {
		alert("电子邮件格式不正确！");
		email.focus();
		return false;
	}
	
	var regionname = form.find("input[name=regionname]");
	if ($.trim(regionname.val()) == "") {
		alert("所在城市不能为空！");
		regionname.focus();
		return false;
	}
	
	var grade = form.find("input[name=grade]:checked");
	if (grade.size() < 1) {
		alert("年龄级别至少选择一个！");
		form.find("input[name=grade]").focus();
		return false;
	}
	
	var terms = form.find("input[name=terms]:checked");
	if (terms.size() < 1) {
		alert("你必须同意本网站的使用条款！");
		form.find("input[name=terms]").focus();
		return false;
	}
	
	if (type == 2 || type == 3) {
		var teacherName = form.find("input[name=teacherName]");
		if ($.trim(teacherName.val()) == "") {
			alert("中文姓不能为空！");
			teacherName.focus();
			return false;
		}
	}
	
	return true;
}

function signin(obj, formid) {
	var form = $("#"+formid);
	
	//if(validateSignin(form)) {
	if(!$(obj).hasClass("reg_but2-disable")) {
		$(obj).addClass("reg_but2-disable");
		form.submit();
		$(obj).removeClass("reg_but2-disable");
	}
}

function validateSignin(form) {
	var username = form.find("input[name=username]");
	if ($.trim(username.val()) == "") {
		alert("帐号不能为空！");
		username.focus();
		return false;
	}
	
	var password = form.find("input[name=password]");
	if ($.trim(password.val()) == "") {
		alert("密码不能为空！");
		password.focus();
		return false;
	}
	
	return true;
}
