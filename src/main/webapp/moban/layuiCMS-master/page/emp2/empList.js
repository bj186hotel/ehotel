
/**
 * @Description: 编辑
 * @author lxy
 * @date 2019/06/21 02:36:59
*/

let allData = '' ;
let newIndex = 0 ;
let zhuangtai = 0; //判断全选框状态
let body = $('body');

//渲染数据

$.ajax({
    type:'post',
    url:'./app.json',
    data:'',
    success: (data)=> {
        allData = data;
        addThis();
    },
    error:(xhr, state,errorThrown)=>{
        console.log('a');
        console.log(errorThrown);
    }
});

//点击编辑

body.on("click",".links_edit",function(){
	newIndex = $(this).data('id');
    $('#model').toggle();
	$('#depId').val(allData[newIndex].roomId);
    $('#empName').val(allData[newIndex].memId);
    $('#empSex').val(1);
    $('#empAge').val(allData[newIndex].price);
    $('#empPhone').val(allData[newIndex].ordertime);
    $('#empEmail').val(allData[newIndex].inTime);
    $('#empPay').val(allData[newIndex].outTime);
    $('#beizhu').val(allData[newIndex].remark);
});

//编辑下的确认修改

body.on('click','#sureA',function () {

    let newInformation = {} ;

    newInformation.roomId = $('#depId').val();
    newInformation.memId = $('#empName').val();
    if ($('#empSex').val() === '1') {
        newInformation.Deposit = '男'
    }
    else newInformation.Deposit = '女';
    newInformation.price = $('#empAge').val();
    newInformation.ordertime = $('#empPhone').val();
    newInformation.inTime = $('#empEmail').val();
    newInformation.outTime = $('#empPay').val();
    newInformation.remark = $('#beizhu').val();
    newInformation.orderId = allData[newIndex].orderId;
    newInformation.orderstate = allData[newIndex].orderstate;
    newInformation.personNum = allData[newIndex].personNum;
    console.log(newInformation);
    if( (newInformation.roomId === '')|| (newInformation.memId === '' )|| (newInformation.Deposit === '')
		||(newInformation.price === '')||( newInformation.ordertime === '')||(newInformation.inTime ===  '')
		||(newInformation.remark ===  '')){
        layer.msg('所有内容均需输入，且不能为空');
    }else {
        allData[newIndex] = newInformation;
        addThis();
        cloaseThis();
        layer.msg('修改成功')
	}
});

//关闭蒙层
function cloaseThis(){
    $('#model').toggle();
}

function cloaseThat(){
    $('#tianjiaA').toggle();
}

body.on("click",".closeA",function(){
    $('#model').hide();
    $('#tianjiaA').hide();
});

body.on('click','#closeA',function () {
    cloaseThis();
});

body.on('click','#quxiao',function () {
    cloaseThat();
});

/**
 * @Description: 数据渲染
 * @author lxy
 * @date 2019/06/24 23:54:18
*/

function addThis() {
    $('.links_content').html('');
	for(let i = 0 ; i < allData.length ; i ++ ){
        $('.links_content').append(
            `
    		<tr>
			    	<td><input type="checkbox" name="checked" style="width: 16px;height: 16px; display: block; border: 1px #D2D2D2 solid ;border-radius: 2px" lay-skin="primary" lay-filter="choose" ></td>
			    	<td align="left">${allData[i].orderId}</td>
			    	<td>${allData[i].roomId}</a></td>
			    	<td>${allData[i].memId}</td>
			    	<td>${allData[i].Deposit}</td>
                    <td>${allData[i].price}</td>
                    <td>${allData[i].ordertime}</td>
                    <td>${allData[i].personNum}</td>
                    <td>${allData[i].inTime}</td>
                    <td>${allData[i].outTime}</td>
					<td>${allData[i].remark}</td>
			    	<td>
					<a class="layui-btn layui-btn-mini links_edit" data-id='${i}'><i class="iconfont icon-edit"> </i>编辑</a>
					<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id='${i}'><i class="layui-icon">&#xe640;</i> 取消</a>
			       </td>
			    	</tr>;
    	`
        )
	}

}

/**
 * @Description: 全选
 * @author lxy
 * @date 2019/06/25 16:26:29
*/

//全选
$("#selectAll").on("click",function(){
    if( zhuangtai === 0 ){
        //把所有复选框选中
        $("#tbd td :checkbox").prop("checked", true);
        zhuangtai = 1;
    }else{
        $("#tbd td :checkbox").prop("checked", false);
        zhuangtai = 0;
    }
});

/**
 * @Description: 查询
 * @author lxy
 * @date 2019/06/25 16:39:29
*/

$(".search_btn").click(function() {
    let newChange  = $('#inputAll').val() ;
    $('#inputAll').val('');
    $.ajax({
            type: 'post',
            url: './app.json',
            data: 'this_Change='+newChange,
            success: (data) => {
                allData = data ;
                if(allData.length === 0 ){
                    layer.msg('暂无数据')
                }else{
                    addThis();
                }
            },
            error: (xhr, state, errorThrown) => {
                console.log('出错');
                console.log(errorThrown);
            }
        }
    )

});

/**
 * @Description: 批量删除
 * @author lxy
 * @date 2019/06/26 18:21:52
*/

body.on('click','#shanchu',function () {
    var checkedNum = $("input[name='checked']:checked").length;
    if(checkedNum === 0){
        alert("请至少选择一项!");
    return false;
    }
    if(confirm("确定删除所选项目?")){
        var checkedList = [];
        $("input[name='subcheck']:checked").each(function(){ checkedList.push($(this).val()); });
        $.ajax({
            type:"POST",
            url:"./app.json",
            data:'',
            success:function(data){
                allData = data;
                addThis();
            }, error:function(data){
                art.dialog.tips('删除失败!');
            }
        });
    }
});

/**
 * @Description: 添加员工
 * @author lxy
 * @date 2019/06/26 18:38:57
*/

body.on('click','#tianjia',function (){

    $('#tianjiaA').show();
});

//添加下的确认

body.on('click','#queren',function () {

    let xinIfromtion = {} ;
    let xinindex = allData.length;

    xinIfromtion.roomId = $('#bumen').val();
    xinIfromtion.memId = $('#xingming').val();
    if ($('#xingbie').val() === '1') {
        xinIfromtion.Deposit = '男'
    }
    else xinIfromtion.Deposit = '女';
    xinIfromtion.price = $('#nianlin').val();
    xinIfromtion.ordertime = $('#dianhua').val();
    xinIfromtion.inTime = $('#youxiang').val();
    xinIfromtion.outTime = $('#gongzi').val();
    xinIfromtion.remark = $('#zhushi').val();
    xinIfromtion.orderId = xinindex;
    xinIfromtion.orderstate = true;
    xinIfromtion.personNum = $('#gonlin').val();
    console.log(xinIfromtion);
    if( (xinIfromtion.roomId === '')|| (xinIfromtion.memId === '' )|| (xinIfromtion.Deposit === '')
        ||(xinIfromtion.price === '')||( xinIfromtion.ordertime === '')||(xinIfromtion.inTime ===  '')
        ||(xinIfromtion.remark ===  '')){
        layer.msg('所有内容均需输入，且不能为空');
    }else {
        allData[xinindex] = xinIfromtion;
        addThis();
        cloaseThat();
        layer.msg('添加成功')
    }

});



//
// layui.config({
// 	base : "js/"
// }).use(['form','layer','jquery','laypage'],function(){
// 	var form = layui.form(),
// 		layer = parent.layer === undefined ? layui.layer : parent.layer,
// 		laypage = layui.laypage,
// 		$ = layui.jquery;
//
// 	//加载页面数据
// 	var linksData = '';
//     var linksData2 = '';
//
// 	$.ajax({
// 		url :"./app.json",
// 		dataType : "json",
//         async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
//         data       : {},    //参数值
//         type       : "GET",   //请求方式
// 		success : function(data){
//             linksData2 = data;
// 			linksData = data;
//             // console.log(linksData);
// 			if(window.sessionStorage.getItem("addLinks")){
// 				var addLinks = window.sessionStorage.getItem("addLinks");
// 				linksData = JSON.parse(addLinks).concat(linksData);
// 			}
// 			//执行加载数据的方法
// 			linksList(linksData);
// 		}
// 	});
//
// 	//查询
// 	$(".search_btn").click(function(){
// 		var newArray = [];
// 		if($(".search_input").val() !== ''){
// 			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
//             setTimeout(function(){
//             	$.ajax({
// 					url : "http://mockjs",
// 					type : "get",
// 					dataType : "json",
// 					success : function(data){
// 						if(window.sessionStorage.getItem("addLinks")){
// 							var addLinks = window.sessionStorage.getItem("addLinks");
// 							linksData = JSON.parse(addLinks).concat(data);
// 						}else{
// 							// console.log("data"+data.data);
// 							linksData = data.data;
// 						}
// 						for(var i=0;i<linksData.length;i++){
// 							var linksStr = linksData[i];
// 							var selectStr = $(".search_input").val();
// 		            		function changeStr(data){
// 		            			var dataStr = '';
//                                 // console.log(typeof a);
// 		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
// 		            			if(showNum > 1){
// 									for (var j=0;j<showNum;j++) {
// 		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
// 		            				}
// 		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
// 		            				return dataStr;
// 		            			}else{
// 		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
// 		            				return dataStr;
// 		            			}
// 		            		}
// 		            		//网站名称
// 							// console.log(linksStr.orderstate);
// 		            		if(selectStr.indexOf(linksStr.orderId) > -1){
// 			            		linksStr["orderId"] = changeStr(linksStr.orderId);
// 		            		}
//                             if(linksStr.orderId.indexOf(selectStr)>-1){
//                                 newArray.push(linksStr);
//                             }
//
// 		            	}
// 		            	linksData = newArray;
// 						// console.log(linksData);
// 		            	linksList(linksData);
// 					}
// 				});
//
//                 layer.close(index);
//             },2000);
// 		}else{
// 			layer.msg("请输入需要查询的内容");
// 		}
// 	});
//
// 	//添加订单
// 	$(".linksAdd_btn").click(function(){
//
// 		var index = layui.layer.open({
// 			title : "添加员工",
// 			type : 2,
// 			content : "empAdd.html",
// 			success : function(layero, index){
// 				setTimeout(function(){
// 					layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
// 						tips: 3
// 					});
// 				},500)
//
// 			}
// 		});
// 		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
// 		$(window).resize(function(){
// 			layui.layer.full(index);
// 		});
// 		layui.layer.full(index);
// 	});
//
// 	//批量删除
// 	$(".batchDel").click(function(){
// 		var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
// 		var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
// 		if($checkbox.is(":checked")){
// 			layer.confirm('确定删除选中的信息？',{icon:3, title:'提示信息'},function(index){
// 				var index = layer.msg('删除中，请稍候',{icon: 16,time:false,shade:0.8});
// 	            setTimeout(function(){
// 	            	//删除数据
// 	            	for(var j=0;j<$checked.length;j++){
// 	            		for(var i=0;i<linksData.length;i++){
// 							if(linksData[i].linksId == $checked.eq(j).parents("tr").find(".links_del").attr("data-id")){
// 								linksData.splice(i,1);
// 								linksList(linksData);
// 							}
// 						}
// 	            	}
// 	            	$('.links_list thead input[type="checkbox"]').prop("checked",false);
// 	            	form.render();
// 	                layer.close(index);
// 					layer.msg("删除成功");
// 	            },2000);
// 	        })
// 		}else{
// 			layer.msg("请选择需要删除的文章");
// 		}
// 	});
//
// 	//全选
// 	form.on('checkbox(allChoose)', function(data){
// 		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
// 		child.each(function(index, item){
// 			item.checked = data.elem.checked;
// 		});
// 		form.render('checkbox');
// 	});
//
// 	//通过判断文章是否全部选中来确定全选按钮是否选中
// 	form.on("checkbox(choose)",function(data){
// 		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
// 		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked');
// 		data.elem.checked;
// 		if(childChecked.length === child.length){
// 			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
// 		}else{
// 			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
// 		}
// 		form.render('checkbox');
// 	});
//
//     //监听弹出框表单提交，massage是修改界面的表单数据'submit(demo11),是修改按钮的绑定
//     function setFormValue(obj,data){
//         // console.log("修改按钮"+data.orderId);
//         form.on('submit(demo11)', function(massage) {
//             $.ajax({
//                 url :"http://mockjs",
//                 dataType : "json",
//                 async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
//                 data       : {},    //参数值
//                 type       : "GET",   //请求方式
//                 success:function (msg) {
//                     var returnCode = msg.code;//取得返回数据（Sting类型的字符串）的信息进行取值判断
//                     if(returnCode===0){
//                         layer.closeAll('loading');
//                         layer.load(2);
//                         layer.msg("修改成功", {icon: 6});
//                         setTimeout(function(){
//                             obj.update({
//                                 orderId:massage.field.orderId,
//                             });//修改成功修改表格数据不进行跳转
//                             layer.closeAll();//关闭所有的弹出层
//                         }, 1000);
//                         //加载层-风格
//                     }else{
//                         layer.msg("修改失败", {icon: 5});
//                     }
//                 }
//             })
//         })
//
//     }
//
//
//     // $(function (){//动态添加option
//     //     $.ajax({
//     //         url: 'http://mockjs2',
//     //         dataType : "json",
//     //         async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
//     //         data       : {},    //参数值
//     //         type       : "GET",   //请求方式
//     //         success:function (backData) {
//     //             var data = backData.data;
//     //             for (var i = 0;i < data.length;i++){
//     //                 $("#rtypeId").append("<option value='"+data[i].rtypeId+"'>"+data[i].rtypeName+"</option>");
//     //                 // console.log("cheng"+data);
//     //             }
//     //             form.render();
//     //         },
//     //         error:function (e){
//     //             // console.log(e)
//     //         }
//     //     })
//     // });
//
//
//
// //删除
// 	$("body").on("click",".links_del",function(){  //删除
// 		var _this = $(this);
// 		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
// 			//_this.parents("tr").remove();
// 			for(var i=0;i<linksData.length;i++){
// 				if(linksData[i].linksId === _this.attr("data-id")){
// 					linksData.splice(i,1);
// 					linksList(linksData);
// 				}
// 			}
// 			layer.close(index);
// 		});
// 	});
//
// 	//查询渲染
//
// 	function linksList(that){
//         //渲染数据
// 		function renderDate(data,curr){
//             console.log(allData);
//             var dataHtml = '';
// 			if(!that){
// 				currData = linksData.concat().splice(curr*nums-nums, nums);
// 			}else{
// 				currData = that.concat().splice(curr*nums-nums, nums);
// 			}
// 			if(currData.length !== 0){
// 				for(var i=0;i<currData.length;i++){
// 					 // console.log(typeof currData[i].orderstate);
//                     var html2;
// /*					if(currData[i].orderstate == true){
// 						html2 = '<td><a style="color:#1E9FFF;" target="_blank" href="#">'+'预订中'+'</a></td>'
// 					}else {
//                         html2 = '<td>已入住</td>'
// 					}*/
// 					dataHtml += '<tr>'
// 			    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
// 			    	+'<td align="left">'+currData[i].orderId+'</td>'
// 			    	+'<td>'+currData[i].roomId+'</a></td>'
// 			    	+'<td>'+currData[i].memId+'</td>'
// 			    	+html2
// 			    	+'<td>'+currData[i].Deposit+'</td>'
//                         +'<td>'+currData[i].price+'</td>'
//                         +'<td>'+currData[i].ordertime+'</td>'
//                         +'<td>'+currData[i].personNum+'</td>'
//                         +'<td>'+currData[i].inTime+'</td>'
//                         +'<td>'+currData[i].outTime+'</td>'
// 					+'<td>'+currData[i].remark+'</td>'
// 			    	+'<td>'
// 					+  '<a class="layui-btn layui-btn-mini links_edit" data-id="'+i+'"><i class="iconfont icon-edit"></i>编辑</a>'
// 					+  '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="'+i+'"><i class="layui-icon">&#xe640;</i> 取消</a>'
// 			        +'</td>'
// 			    	+'</tr>';
// 				}
// 			}else{
// 				dataHtml = '<tr><td colspan="7">暂无数据</td></tr>';
// 			}
// 		    return dataHtml;
// 		}
//
// 		//分页
// 		var nums = 13; //每页出现的数据量
// 		if(that){
// 			linksData = that;
// 		}
// 		laypage({
// 			cont : "page",
// 			pages : Math.ceil(linksData.length/nums),
// 			jump : function(obj){
// 				$(".links_content").html(renderDate(linksData,obj.curr));
// 				$('.links_list thead input[type="checkbox"]').prop("checked",false);
// 		    	form.render();
// 			}
// 		})
// 	}
// });
