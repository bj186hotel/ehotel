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
		url :"http://mockjs",
		dataType : "json",
        async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
        data       : {},    //参数值
        type       : "GET",   //请求方式
		success : function(data){
            linksData2 = data;
			linksData = data.data;
            //console.log(linksData);
			if(window.sessionStorage.getItem("addLinks")){
				var addLinks = window.sessionStorage.getItem("addLinks");
				linksData = JSON.parse(addLinks).concat(linksData);
			}
			//执行加载数据的方法
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





    $(function (){//动态添加option
        $.ajax({
            url: 'http://mockjs2',
            dataType : "json",
            async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
            data       : {},    //参数值
            type       : "GET",   //请求方式
            success:function (backData) {
                var data = backData.data;
                for (var i = 0;i < data.length;i++){
                    $("#rtypeId").append("<option value='"+data[i].rtypeId+"'>"+data[i].rtypeName+"</option>");
                    console.log("cheng"+data);
                }
                form.render();


            },
            error:function (e){
                console.log(e)
            }
        })
    })




	$("body").on("click",".links_del",function(){  //修改进货单状态为审核失败
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
            linksData.splice(_this.attr("data-id"),1);//删除当前数据
            linksList(linksData);
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
					 console.log(typeof currData[i].orderstate);
                    var html2;
					if(currData[i].orderstate == true){
						html2 = '<td><a style="color:#1E9FFF;" target="_blank" href="liveAdd.html">'+'预订中'+'</a></td>'
					}else {
                        html2 = '<td>已入住</td>'
					}
					dataHtml += '<tr>'
			    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td align="left">'+currData[i].orderId+'</td>'
			    	+'<td>'+currData[i].roomId+'</a></td>'
			    	+'<td>'+currData[i].memId+'</td>'
			    	+html2
			    	+'<td>'+currData[i].Deposit+'</td>'
                        +'<td>'+currData[i].price+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini links_edit" data-id="'+i+'" href ="enterAdd.html?'+currData[i].enter_order_ID+"&"+i+'"><i class="iconfont icon-edit"></i>编辑</a>'
                        +  '<a class="layui-btn layui-btn-danger layui-btn-mini" data-id="'+i+'" ><i class="layui-icon">&#xe61f;</i>通过</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+i+'"><i class="layui-icon">&#xe640;</i> 驳回</a>'
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
