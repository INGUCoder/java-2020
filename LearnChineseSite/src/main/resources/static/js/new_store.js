// JavaScript Document
//首页大图展示
$(document).ready(function(){
	var index = 0;
	//$('<div id="flow"></div>').appendTo("#myjQuery");

	//滑动导航改变内容	
	$("#myjQueryNav li").hover(function(){
		if(MyTime){
			clearInterval(MyTime);
		}
		index  =  $("#myjQueryNav li").index(this);
		MyTime = setTimeout(function(){
		ShowjQueryFlash(index);
		$('#myjQueryContent').stop();
		} , 400);

	}, function(){
		clearInterval(MyTime);
		MyTime = setInterval(function(){
		ShowjQueryFlash(index);
		index++;
		if(index==5){index=0;}
		} , 5000);
	});
	//滑入 停止动画，滑出开始动画.
	 $('#myjQueryContent').hover(function(){
			  if(MyTime){
				 clearInterval(MyTime);
			  }
	 },function(){
				MyTime = setInterval(function(){
				ShowjQueryFlash(index);
				index++;
				if(index==5){index=0;}
			  } , 5000);
	 });
	//自动播放
	var MyTime = setInterval(function(){
		ShowjQueryFlash(index);
		index++;
		if(index==5){index=0;}
	} , 5000);
});
function ShowjQueryFlash(i) {
$("#myjQueryContent div").eq(i).animate({opacity: 1},400).css({"z-index": "1"}).siblings().animate({opacity: 0},400).css({"z-index": "0"});
//$("#flow").animate({ left: i*122+5 +"px"}, 300 ); //滑块滑动
$("#myjQueryNav li").eq(i).addClass("current").siblings().removeClass("current");
}

/*购买商品数量加减*/
function subtration(number){
	var num = $(number).parent("td").parent("tr").find("input.s_gd_input2");
	var num_ = parseInt(num.val());
	if(num_==1){
		return num_;
	}else{
		num_ = num_ - 1;
	}
	num.val(num_);
}
function addNum(number){
	var num = $(number).parent("td").parent("tr").find("input.s_gd_input2");
	var num_ = parseInt(num.val());
	num_ = num_ +1;
	num.val(num_);
}

$(document).ready(function(){ 
	//商品展示tab					   
	var wweya_li =$("#s_show_tab li");
	wweya_li.click(function(){
	$(this).addClass("selected")    
	 .siblings().removeClass("selected");  
		var index =  wweya_li.index(this); 
	$("#s_show_tabcon > div")   	
	.eq(index).show()   
		.siblings().hide(); 
	});
	//商品列表点击选中
	$(".s_list_t2_list li a").click(function(){
			if($(this).attr("class")=="selected") {
				$(this).removeClass("selected");
			} else {
				$(this).parent("li").parent("ul").find("a.selected").removeClass("selected");
				$(this).addClass("selected");
			}
	 });
	//商品列表经过效果
	$(".s_list_bot_lb li").hover(function(){
			$(this).toggleClass("hover");
			return false;
	 });
	//我的购物车下拉菜单
	$("#s_cart_btn,#s_cart_sublist").hover(
		function(){
			$("#s_cart_sublist").show();
			return false;
		},
		function(){
			$("#s_cart_sublist").hide();
			return false;
		});
	//top导航点击伸缩
		$(".s_bar_l li").each(function(){
		  $(this).find("a").eq(0).click(function(){
					$(this).toggleClass("topbar_selected1");
					$("#"+$(this).attr("show_id")).toggle();
			  //$("#s_jxgj").toggleClass("topbar_selected1");
			  //$("#s_bar_jxgj").toggle();
			  //$("#s_jckc").toggleClass("topbar_selected1");
			 // $("#s_bar_jckc").toggle();
			 // $("#s_tslm").toggleClass("topbar_selected1");
			  //$("#s_bar_tslm").toggle();
		  })
		})
		/*教学工具*/
		/*$(".s_bar_l li").find("a").first().click(
			function(){
				$("#s_jxgj").toggleClass("topbar_selected1");
				$("#s_bar_jxgj").toggle();
			});*/
		/*教材/课程*/
		/*$("#jckc_link").click(
			function(){
				$("#s_jckc").toggleClass("topbar_selected1");
				$("#s_bar_jckc").toggle();
			});*/
		/*特色栏目*/
		/*$("#tslm_link").click(
			function(){
				$("#s_tslm").toggleClass("topbar_selected1");
				$("#s_bar_tslm").toggle();
			});*/
	//教学工具下拉菜单
	$("#s_jxgj,#s_bar_jxgj").hover(
		function(){
			$("#s_bar_jxgj").show();
			$("#s_jxgj").addClass("topbar_selected1");
			return false;
		},
		function(){
			$("#s_bar_jxgj").hide();
			$("#s_jxgj").removeClass("topbar_selected1");
			return false;
		});
	$("#s_jxgj").click(function(){
		$("#s_bar_jxgj").show();							
	})
	
	//教材/课程下拉菜单
	$("#s_jckc,#s_bar_jckc").hover(
		function(){
			$("#s_bar_jckc").show();
			$("#s_jckc").addClass("topbar_selected1");
			return false;
		},
		function(){
			$("#s_bar_jckc").hide();
			$("#s_jckc").removeClass("topbar_selected1");
			return false;
		});
		
	$("#s_jckc").click(function(){
		$("#s_bar_jckc").show();							
	})
	//特色栏目下拉菜单
	$("#s_tslm,#s_bar_tslm").hover(
		function(){
			$("#s_bar_tslm").show();
			$("#s_tslm").addClass("topbar_selected1");
			return false;
		},
		function(){
			$("#s_bar_tslm").hide();
			$("#s_tslm").removeClass("topbar_selected1");
			return false;
		});
	
		$("#s_tslm").click(function(){
		$("#s_bar_tslm").show();							
	})
	//登录后用户名下拉菜单
	$("#s_yhm_span,#s_bar_logined").hover(
		function(){
			$("#s_bar_logined").show();
			$("#s_yhm_span").addClass("topbar_selected2");
			return false;
		},
		function(){
			$("#s_bar_logined").hide();
			$("#s_yhm_span").removeClass("topbar_selected2");
			return false;
		});
	//登录后我的教学工具下拉菜单
	$("#s_wdjxgj,#s_bar_mytools").hover(
		function(){
			$("#s_bar_mytools").show();
			$("#s_wdjxgj").addClass("topbar_selected2");
			return false;
		},
		function(){
			$("#s_bar_mytools").hide();
			$("#s_wdjxgj").removeClass("topbar_selected2");
			return false;
		});
	//登录后我的课程下拉菜单
	$("#s_wdkc,#s_bar_mycourses").hover(
		function(){
			$("#s_bar_mycourses").show();
			$("#s_wdkc").addClass("topbar_selected2");
			return false;
		},
		function(){
			$("#s_bar_mycourses").hide();
			$("#s_wdkc").removeClass("topbar_selected2");
			return false;
		});
	//登录后我的班级下拉菜单
	$("#s_wdbj,#s_bar_myclass").hover(
		function(){
			$("#s_bar_myclass").show();
			$("#s_wdbj").addClass("topbar_selected2");
			return false;
		},
		function(){
			$("#s_bar_myclass").hide();
			$("#s_wdbj").removeClass("topbar_selected2");
			return false;
		});
	//登录后我的特色栏目下拉菜单
	$("#s_wdtslm,#s_bar_mytitle").hover(
		function(){
			$("#s_bar_mytitle").show();
			$("#s_wdtslm").addClass("topbar_selected2");
			return false;
		},
		function(){
			$("#s_bar_mytitle").hide();
			$("#s_wdtslm").removeClass("topbar_selected2");
			return false;
		});
	//商品分类下拉
	$(".s_nav_l,.s_menulist_spe").hover(
		function(){
			if($(".s_menulist_spe").size()>0){
			$(".s_menulist_spe").show();
			$(".s_nav_l").addClass("s_nav_l_spe");
			}},
		function(){
			$(".s_menulist_spe").hide();
			$(".s_nav_l").removeClass("s_nav_l_spe");
			return false;	
		});
	//商品分类点击选中
	/*$(".s_b-fl_r li").click(function(){
			if($(this).attr("class")=="selected") {
				$(this).removeClass("selected");
			} else {
				$(this).parent("ul").find("li.selected").removeClass("selected");
				$(this).addClass("selected");
			}
	 });*/
	//邮寄方式点击后显示
	/*var lastRadio = null;
	$(".s_co_yjfs_con2 input").click(function(){
		var nr = $("#canada_mail_mode").clone().show();
		$(this).parent("label").next("br").after(nr);

		if(lastRadio != null){
			lastRadio.parent("label").next("br").next("div").remove();
		}
		lastRadio = $(this);
	});*/
	//付款方式点击后显示
	$(".s_co_fkfs_con input").click(function(){
		$("#canada_payment_mode").hide();	
	});
	$(".s_co_fkfs_con input").eq(0).click(function(){
		$("#canada_payment_mode").show();	
	});
	//优惠信息input点击
		//1
	$('#s_co_Input1').bind("propertychange", function(){
	  if($(this).val()=="") {
		  $("#s_co_InputLine1").addClass("s_co_showPlaceholder");
	  } else {
		  $("#s_co_InputLine1").removeClass("s_co_showPlaceholder");
	  }
	});
	
	$('#s_co_Input1').bind("input", function(){
	  if($(this).val()=="") {
		  $("#s_co_InputLine1").addClass("s_co_showPlaceholder");
	  } else {
		  $("#s_co_InputLine1").removeClass("s_co_showPlaceholder");
	  }
	});
	$("#s_co_Placeholder1").click(function(){
		  	$("#s_co_Input1").focus();	
	});
		//千校优惠码输入
	$('#s_gd_Input').bind("propertychange", function(){
	  if($(this).val()=="") {
		  $("#s_gd_InputLine").addClass("s_gd_showPlaceholder");
	  } else {
		  $("#s_gd_InputLine").removeClass("s_gd_showPlaceholder");
	  }
	});
	
	$('#s_gd_Input').bind("input", function(){
	  if($(this).val()=="") {
		  $("#s_gd_InputLine").addClass("s_gd_showPlaceholder");
	  } else {
		  $("#s_gd_InputLine").removeClass("s_gd_showPlaceholder");
	  }
	});
	$("#s_gd_Placeholder").click(function(){
		  	$("#s_gd_Input").focus();	
	});
		//搜索
	$('#s_search_Input').bind("propertychange", function(){
	  if($(this).val()=="") {
		  $("#s_search_InputLine").addClass("s_search_showPlaceholder");
	  } else {
		  $("#s_search_InputLine").removeClass("s_search_showPlaceholder");
	  }
	});
	
	$('#s_search_Input').bind("input", function(){
	  if($(this).val()=="") {
		  $("#s_search_InputLine").addClass("s_search_showPlaceholder");
	  } else {
		  $("#s_search_InputLine").removeClass("s_search_showPlaceholder");
	  }
	});
	$("#s_search_Placeholder").click(function(){
		  	$("#s_search_Input").focus();	
	});
	//3
	$('#s_co_Input3').bind("propertychange", function(){
	  if($(this).val()=="") {
		  $("#s_co_InputLine3").addClass("s_co_showPlaceholder");
	  } else {
		  $("#s_co_InputLine3").removeClass("s_co_showPlaceholder");
	  }
	});
	
	$('#s_co_Input3').bind("input", function(){
	  if($(this).val()=="") {
		  $("#s_co_InputLine3").addClass("s_co_showPlaceholder");
	  } else {
		  $("#s_co_InputLine3").removeClass("s_co_showPlaceholder");
	  }
	});
	$("#s_co_Placeholder3").click(function(){
		  	$("#s_co_Input3").focus();	
	});
	//更多搜索条件
	$("#more_query").click(function(){
		$("#more_query_but").toggleClass("s_order_link1_selected");
		$("#order_search").toggle();
	});
	//帮助中心下拉菜单
	var cli = null;
	$('#menu ul').hide();
	//$('#menu ul').eq(0).show();
	$('#menu li a').click(
	  function() {
		  if(cli!=null)
		  	cli.removeClass();
		var checkElement = $(this).next();
		if((checkElement.is('ul')) && (checkElement.is(':visible'))) {	
		  return false;
		  }
		if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
		  $('#menu ul:visible').slideUp('normal');
		  checkElement.slideDown('narmal');
		  cli = $(this);
		  cli.addClass('s_hm_link1');
		  return false;
		  }
		  	
		}
	  );
	
});