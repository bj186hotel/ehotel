layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

    var data = decodeURI(location.search);//获取从列表页传过来的订单id和可住人数
    console.log("111111"+typeof data);
    var now = data.split('&');//切割
    console.log("2222222"+now[0]);
    var enter_order_ID = now[0];//获取进货单id

	/*新增按钮*/
    $("#add").click(function(){
        console.log($("#del"));
        add();
        addDel();
        form.render('select');
    })

    /*保存按钮*/
    $("#sub").click(function(){
        var enterOrders = [] ;
        for(var i = 0;i<$("[name='enterOrder']").length;i++){
            var enterOrder ;
            enterOrder = '{"Goods_id":"'+$("[name='enterOrder']").eq(i).find("[name='goods_id'] option:selected").val() +'",';
            enterOrder += '"pron_number":"'+$("[name='enterOrder']").eq(i).find("[name='pron_number']").val() +'",';
            enterOrder += '"enter_order_ID":"'+1001 +'",';
            enterOrder += '"remark":"'+$("[name='enterOrder']").eq(i).find("[name='remark']").val() +'"}';
            var parse = JSON.parse(enterOrder);
            enterOrders.unshift(parse);
        }
        $.ajax({
            url: "/enterOrderList/addEnterOrderList",
            dataType: "json",
            contentType: "application/json",
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: JSON.stringify(enterOrders),    //参数值
            type: "post",   //请求方式
            success: function (data) {

            }
        })
    })


    /*页面初始化加载，通过进货单id加载进货单明细*/
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
                    add();
                }
                addDel();
                form.render();


            },
            error:function (e){
                console.log(e)
            }
        })
    })

    /*删除*/
    function addDel() {
        $(".del").click(function(){
            $(this).parent().parent().remove();
            form.render('select');
        })
    }

    /*动态生成添加入住人员表单*/
    function add() {  //动态展示商品的方法
        $("#liveform").append(`
               
                        <div class="">
                        <br>
                        <div class="layui-inline">
			<a class="layui-btn linksAdd_btn del" style="background-color:#5FB878">删除</a>
		</div>
		<div class="layui-form-item" name="enterOrder" style="border: #1E9FFF ;border-style: solid;
  border-width: 2px;">
			<br>
			<label class="layui-form-label">商品类型：</label>
			<div class="layui-input-inline">
				<select >
					<option value="">请选择商品类型</option>
				</select>
			</div>
			<label class="layui-form-label">商品：</label>
			<div class="layui-input-inline">
				<select name="goods_id">
					<option value="1">请选择商品</option>
					<option value="2">请选择商品2</option>
				</select>
			</div>
			<label class="layui-form-label">商品数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="商品数量">
			</div>
			<br><br><br>
			<div class="layui-form-item">
			<label class="layui-form-label">库存数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number2" class="layui-input" placeholder="库存数量" >
				</div>
				<label class="layui-form-label">待发数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number3" class="layui-input" placeholder="待发数量">
			</div>
			<label class="layui-form-label">审计数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number4" class="layui-input" placeholder="审计数量">
			</div>
			<br><br><br>
			<div class="layui-form-item">
				<label class="layui-form-label">单价：</label>
				<div class="layui-input-inline">
					<input type="text" name="price" class="layui-input" placeholder="单价">
				</div>
				<label class="layui-form-label">总价：</label>
				<div class="layui-input-inline">
					<input type="text" name="price2" class="layui-input" placeholder="总价">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">备注：</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea" name="remark" ></textarea>
				</div>
			</div>
		</div>
		</div>
                    `);
    }

})
