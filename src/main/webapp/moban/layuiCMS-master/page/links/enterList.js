layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;


	//加载页面数据
	var linksData = '';
    var linksData2 = '';
	$.ajax({
		url :"/enterOrder/getEnterOrders",
		dataType : "json",
        async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
        data       : {},    //参数值
        contentType: "application/json",
        type       : "post",   //请求方式
		success : function(data){
            linksData2 = data;
			linksData = data.data;
            console.log(data);
			linksList(linksData);
		}
	})

	//查询
	$(".search_btn").click(function(){
		var newArray = [];
		if($(".search_input").val() != ''){
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
            	$.ajax({
					url : "http://mockjs",
					type : "get",
					dataType : "json",
					success : function(data){
						if(window.sessionStorage.getItem("addLinks")){
							var addLinks = window.sessionStorage.getItem("addLinks");
							linksData = JSON.parse(addLinks).concat(data);
						}else{
							console.log("data"+data.data);
							linksData = data.data;
						}
						for(var i=0;i<linksData.length;i++){
							var linksStr = linksData[i];
							var selectStr = $(".search_input").val();
		            		function changeStr(data){
		            			var dataStr = '';
                                // console.log(typeof a);
		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
		            			if(showNum > 1){
									for (var j=0;j<showNum;j++) {
		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
		            				}
		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
		            				return dataStr;
		            			}else{
		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
		            				return dataStr;
		            			}
		            		}
		            		//网站名称
							// console.log(linksStr.orderstate);
		            		if(selectStr.indexOf(linksStr.orderId) > -1){
			            		linksStr["orderId"] = changeStr(linksStr.orderId);
		            		}
                            if(linksStr.orderId.indexOf(selectStr)>-1){
                                newArray.push(linksStr);
                            }

		            	}
		            	linksData = newArray;
						console.log(linksData);
		            	linksList(linksData);
					}
				})
            	
                layer.close(index);
            },2000);
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})

	//添加订单
	$(".linksAdd_btn").click(function(){
		var enterOrder = {"usersId":"1001","status":"1"};
        $.ajax({
            url: "/enterOrder/addEnterOrder",
            dataType: "json",
            contentType: "application/json",
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: JSON.stringify(enterOrder),    //参数值
            type: "post",   //请求方式
            success: function (data) {
                if(data.code == 200){
                	alert(data.data);
                    var index = layui.layer.open({
                        title : "添加进货定单",
                        type : 2,
                        content : "enterAdd.html?"+data.data,
                        success : function(layero, index){
                            setTimeout(function(){
                                layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
                                    tips: 3
                                });
                            },500)
                        }
                    })
                    //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                    $(window).resize(function(){
                        layui.layer.full(index);
                    })
                    layui.layer.full(index);
                }
            }
        })
	})

	//批量删除
	$(".batchDel").click(function(){
		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
		if($checkbox.is(":checked")){
			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
	            setTimeout(function(){
	            	//删除数据
	            	for(var j=0;j<$checked.length;j++){
	            		for(var i=0;i<linksData.length;i++){
							if(linksData[i].linksId == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
								linksData.splice(i,1);
								linksList(linksData);
							}
						}
	            	}
	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
	            	form.render();
	                layer.close(index);
					layer.msg("删除成功");
	            },2000);
	        })
		}else{
			layer.msg("请选择需要删除的文章");
		}
	})

	//全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		data.elem.checked;
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})









	$("body").on("click",".links_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<linksData.length;i++){
				if(linksData[i].linksId == _this.attr("data-id")){
					linksData.splice(i,1);
					linksList(linksData);
				}
			}
			layer.close(index);
		});
	})

	function linksList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = linksData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
                    var html2;
					if(currData[i].status == 1){
						html2 = '<td>未审核</td>'
					}else if(currData[i].status == 2){
                        html2 = '<td>审核中</td>'
					}else if(currData[i].status == 3){
                        html2 = '<td>审核通过</td>'
                    }else if(currData[i].status == 4){
                        html2 = '<td>审核失败</td>'
                    }else if(currData[i].status == 5){
                        html2 = '<td>已取消</td>'
                    }else if(currData[i].status == 6){
                        html2 = '<td>已下单</td>'
                    }else if(currData[i].status == 7){
                        html2 = '<td>盘点中</td>'
                    }else if(currData[i].status == 8){
                        html2 = '<td>完成</td>'
                    }
					dataHtml += '<tr>'
			    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td align="left">'+currData[i].enterOrderId+'</td>'
			    	+'<td>'+currData[i].user+'</a></td>'
			    	+'<td>'+currData[i].costMoney+'</td>'
			    	+html2
			    	+'<td>'+currData[i].modifiedTime2+'</td>'
                        +'<td>'+currData[i].price+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini links_edit" data-id="'+i+'" href ="enterAdd.html?'+currData[i].enterOrderId+"&"+i+'"><i class="iconfont icon-edit"></i>编辑</a>'
                        +  '<a class="layui-btn layui-btn-danger layui-btn-mini" data-id="'+i+'" href ="liveAdd.html?'+currData[i].enterOrderId+"&"+i+'"><i class="layui-icon">&#xe61f;</i> 发起审核</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+i+'"><i class="layui-icon">&#xe640;</i> 取消</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="7">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 2; //每页出现的数据量
		if(that){
			linksData = that;
		}
		laypage({
			cont : "page",
			pages : Math.ceil(linksData.length/nums),
			jump : function(obj){
				$(".links_content").html(renderDate(linksData,obj.curr));
				$('.links_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
})
