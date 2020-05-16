// JavaScript Document
$(document).ready(function(){
	//首页登录层的处理
	/*$("#index_nav").find("#unlogin").find("a").click(function(){
		$("#login").show();
		return false;
	})
	$("#login").find(".loginClose>img").click(function(){
		$("#login").hide();
	})
	$("#login").find(".loginTips").find("a").toggle(
		function(){
			$("#login").find(".sign").show();
		},
		function(){
			$("#login").find(".sign").hide();
		}
	);*/
	//个性教室登录层
	//登录层的处理
	$("#state").find(".login").find("a").click(function(){
		$("#login").show();
		return false;
	})
	$("#login").find(".loginClose>img").click(function(){
		$("#login").hide();
	})
	$("#login").find(".loginTips").find("a").toggle(
		function(){
			$("#login").find(".sign").show();
		},
		function(){
			$("#login").find(".sign").hide();
		}
	);
	//用户登录二级下拉菜单
	$("#logined,#logined_submenu").hover(
		function(){
			$("#logined_submenu").show();
			$("#logined").find("a").addClass("selected");
			return false;
		},
		function(){
			$("#logined_submenu").hide();
			$("#logined").find("a").removeClass("selected");
			return false;
		}
	)
	$("#logined,.Loginedlist").click(
		function(){
			$(".Loginedlist").toggle();
			return true;
		}
	)
	//等级点击后显示
	$("#user-role1 input").click(
		function(){
			$("#user-step1").show();
		});
	$("#user-role2 input").click(
		function(){
			$("#user-step2").show();
		});
	//我的课程下拉菜单
	$(".mycourse,#mycourse_submenu").hover(
		function(){
			$("#mycourse_submenu").show();
			return false;
		},
		function(){
			$("#mycourse_submenu").hide();
			return false;
		}
	)
	$(".mycourse,#mycourse_submenu").click(
		function(){
			$("#mycourse_submenu").toggle();
			return true;
		}
	)
	//课程下拉菜单
	$("#course,#dlist_submenu").hover(
		function(){
			$("#dlist_submenu").show();
			$("#course").find("a").addClass("selected");
			return false;
		},
		function(){
			$("#dlist_submenu").hide();
			$("#course").find("a").removeClass("selected");
			return false;
		}
	)
	$("#course,#dlist_submenu").click(
		function(){
			$("#dlist_submenu").toggle();
			return true;
		}
	)
	//教学工具
	$("#teaching-tool,#tool_submenu").hover(
		function(){
			$("#tool_submenu").show();
			$("#teaching-tool").find("a").addClass("selected");
			return false;
		},
		function(){
			$("#tool_submenu").hide();
			$("#teaching-tool").find("a").removeClass("selected");
			return false;
		}
	)
	$("#teaching-tool,#tool_submenu").click(
		function(){
			$("#tool_submenu").toggle();
			return true;
		}
	);
	//了解更多弹窗
	$(".pop2_close").click(function(){
		$("#win_pop2").hide();
		});
	$(".login-reg_close1").click(function(){
		$("#login-reg_tips1").hide();
		});
	$(".login-reg_close1-1").click(function(){
		$("#login-reg_tips1-1").hide();
		});
	$(".login-reg_close2").click(function(){
		$("#login-reg_tips2").hide();
		});
	$(".login-reg_close2-1").click(function(){
		$("#login-reg_tips2-1").hide();
		});
	//没有语言弹窗
	$(".no_lan_pop_close").click(function(){
		$("#no_lan_pop").hide();
		});
	
	//翻页
	$(".switch").find(".swcon").find("a").click(function(){
		var ulName=$(this).text();
		$(".courseware").find("ul").hide();
		$(".courseware").find("ul#"+ulName).show();
		
		$(this).siblings("a.selected").removeClass("selected");
		$(this).addClass("selected");
		return false;
	})
});
function popWindow(id){
	$(id).show();
};
//switch水平居中方法
function centerSwitch(){
	var switchWidth=$(".switch").find(".swleft").width()+$(".switch").find(".swright").width();
	$(".switch").find(".swcon").find("a").each(function(i){
		switchWidth+=$(this).width();
	})
	var parentWidth=$(".switch").parent().width();
	var switchLeft=(parentWidth-switchWidth)/2;
	$(".switch").css("margin-left",switchLeft+"px");
}
//快速进入----弹出层
function alertTip(tipWords){
	$(tipWords).css("display","block");
}

function closeTip(tip){
	$(tip).css("display","none");
}
//登录输入框切换
$(document).ready(function(){
	$('#idInput1').bind("propertychange", function(){
	  if($(this).val()=="") {
		  $("#idInputLine1").addClass("showPlaceholder1");
	  } else {
		  $("#idInputLine1").removeClass("showPlaceholder1");
	  }
	});
	
	$('#idInput1').bind("input", function(){
	  if($(this).val()=="") {
		  $("#idInputLine1").addClass("showPlaceholder1");
	  } else {
		  $("#idInputLine1").removeClass("showPlaceholder1");
	  }
	});
	$("#pwdPlaceholder1").click(function(){
		  	$("#idInput1").focus();	
	});
	
	$('#idInput2').bind("propertychange", function(){
	  if($(this).val()=="") {
		  $("#idInputLine2").addClass("showPlaceholder1");
	  } else {
		  $("#idInputLine2").removeClass("showPlaceholder1");
	  }
	});
	
	$('#idInput2').bind("input", function(){
	  if($(this).val()=="") {
		  $("#idInputLine2").addClass("showPlaceholder1");
	  } else {
		  $("#idInputLine2").removeClass("showPlaceholder1");
	  }
	});
	$("#pwdPlaceholder2").click(function(){
		  	$("#idInput2").focus();	
	});
})
