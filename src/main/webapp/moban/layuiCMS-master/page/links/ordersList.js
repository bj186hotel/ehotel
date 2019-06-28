layui.config({
    base: "js/"
}).use(['form', 'layer', 'jquery', 'laypage'], function () {
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;


    //加载页面数据
    var linksData;
    var linksData2 = '';
    $.ajax({
        url: "/order/getAllOrder",
        dataType: "json",
        contentType: "application/json",
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: {},    //参数值
        type: "post",   //请求方式
        success: function (data) {
            linksData = data.data;
            linksList(linksData);
        }
    })

    //查询
    $("#submit").click(function () {
        var order;
        order = '{"menNum":"' + $("#memId2").val() + '",';
        order += '"ordertime":"' + $("#ordertime").val() + '",';
        order += '"orderstate":"' + $("#orderstate option:selected").val() + '",';
        order += '"roomNum":"' + $("#roomNum").val() + '"}';
        var parse = JSON.parse(order);
        console.log(JSON.stringify(parse));
        $.ajax({
            url: "/order/getOrdersByConditions",
            dataType: "json",
            contentType: "application/json",
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: JSON.stringify(parse),    //参数值
            type: "post",   //请求方式
            success: function (data) {
                linksData = data.data;
                linksList(linksData);
            }
        })
    })

    //添加订单
    $(".linksAdd_btn").click(function () {
        var index = layui.layer.open({
            title: "添加定单",
            type: 2,
            content: "linksAdd.html",
            success: function (layero, index) {
                setTimeout(function () {
                    layui.layer.tips('点击此处返回友链列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                }, 500)
            }
        })
        //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
        $(window).resize(function () {
            layui.layer.full(index);
        })
        layui.layer.full(index);
    })

    //批量取消
    $(".batchDel").click(function () {
        var $checkbox = $('.links_list tbody input[type="checkbox"][name="checked"]');
        var $checked = $('.links_list tbody input[type="checkbox"][name="checked"]:checked');
        if ($checkbox.is(":checked")) {
            layer.confirm('确定取消选中的订单？', {icon: 3, title: '提示信息'}, function (index) {
                var index = layer.msg('取消中，请稍候', {icon: 16, time: false, shade: 0.8});
                setTimeout(function () {
                    //删除数据
                    for (var j = 0; j < $checked.length; j++) {
                        var a = $checked.eq(j).parents("tr").find(".links_del").attr("data-id");
                        linksData.splice(a, 1);
                        linksList(linksData);
                    }
                    $('.links_list thead input[type="checkbox"]').prop("checked", false);
                    form.render();
                    layer.close(index);
                    layer.msg("取消成功");
                }, 2000);
            })
        } else {
            layer.msg("请选择需要删除的文章");
        }
    })

    //全选
    form.on('checkbox(allChoose)', function (data) {
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
        child.each(function (index, item) {
            item.checked = data.elem.checked;
        });
        form.render('checkbox');
    });

    //通过判断文章是否全部选中来确定全选按钮是否选中
    form.on("checkbox(choose)", function (data) {
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
        var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
        data.elem.checked;
        if (childChecked.length == child.length) {
            $(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
        } else {
            $(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
        }
        form.render('checkbox');
    })

    //操作
    $("body").on("click", ".links_edit", function () {  //编辑
        var _this = $(this);
        console.log(_this.attr("data-id"));
        var order = linksData[_this.attr("data-id")];
        layer.open({
            //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
            type: 1,
            title: "修改订单",
            area: ['50%', '80%'],
            content: $("#popSearchRoleTest").html(),
            success: function (layero, index) {
                /*给弹出层赋初始值*/
                layero.find("#orderId").val(order.orderid);
                roomId
                layero.find("#roomId").val(order.room.roomnum);
            }
        });
        lay('.test-item').each(function () {
            laydate.render({
                elem: this
            });
        });
        form.render();
        setFormValue(linksData2, order);

    })

    //监听弹出框表单提交，massage是修改界面的表单数据'submit(demo11),是修改按钮的绑定
    function setFormValue(obj, data) {
        console.log("修改按钮" + data.orderId)
        form.on('submit(demo11)', function (massage) {
            $.ajax({
                url: "http://mockjs",
                dataType: "json",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                data: {},    //参数值
                type: "GET",   //请求方式
                success: function (msg) {
                    var returnCode = msg.code;//取得返回数据（Sting类型的字符串）的信息进行取值判断
                    if (returnCode == 0) {
                        layer.closeAll('loading');
                        layer.load(2);
                        layer.msg("修改成功", {icon: 6});
                        setTimeout(function () {
                            obj.update({
                                orderId: massage.field.orderId,
                            });//修改成功修改表格数据不进行跳转
                            layer.closeAll();//关闭所有的弹出层
                        }, 1000);
                        //加载层-风格
                    } else {
                        layer.msg("修改失败", {icon: 5});
                    }
                }
            })
        })

    }


    $(function () {//动态添加option
        $.ajax({
            url: 'http://mockjs2',
            dataType: "json",
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: {},    //参数值
            type: "GET",   //请求方式
            success: function (backData) {
                var data = backData.data;
                for (var i = 0; i < data.length; i++) {
                    $("#rtypeId").append("<option value='" + data[i].rtypeId + "'>" + data[i].rtypeName + "</option>");
                    console.log("cheng" + data);
                }
                form.render();


            },
            error: function (e) {
                console.log(e)
            }
        })
    })


    $("body").on("click", ".links_del", function () {  //取消订单
        var _this = $(this);
        var or = {"orderstate":"3","orderid":_this.attr("name")};
        layer.confirm('确定取消该订单？', {icon: 3, title: '提示信息'}, function (index) {
            $.ajax({
                url: "/order/updataOrder",
                dataType: "json",
                contentType: "application/json",
                async: true, //请求是否异步，默认为异步，这也是ajax重要特性
                data: JSON.stringify(or),    //参数值
                type: "post",   //请求方式
                success: function (data) {
                    if(data.code == 200){
                        var i =  _this.attr("data-id")
                        console.log(linksData[i]);
                        linksData[i]["orderstate"] = (3);
                        linksList(linksData);
                    }
                }
            })
            layer.close(index);
        });
    })

    function linksList(that) {
        //渲染数据
        function renderDate(data, curr) {
            var dataHtml = '';
            if (!that) {
                currData = linksData.concat().splice(curr * nums - nums, nums);
            } else {
                currData = that.concat().splice(curr * nums - nums, nums);
            }
            console.log(currData);
            if (currData.length != 0) {
                for (var i = 0; i < currData.length; i++) {
                    var html2 = '';
                    var html33 = '';
                    if (currData[i].orderstate == 2) {
                        html2 = '<td style="color:#ff14aa;">预订中</td>'
                        html33 = '<td><a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="' + i + '" name="' + currData[i].orderid + '"><i class="layui-icon">&#xe640;</i>取消预订</a>' + '<a class="layui-btn layui-btn-danger layui-btn-mini" href="liveAdd.html?' + currData[i].orderid + "&" + currData[i].room.roomType.livenum + '">办理入驻</a></td>'
                    } else if (currData[i].orderstate == 4) {
                        html2 = '<td style="color:#20ff1f;">入住中</td>'
                        html33 = '<td><a class="layui-btn layui-btn-danger layui-btn-mini" data-id="' + i + '" href ="liveAdd.html?' + currData[i].orderid + '"><i class="layui-icon">&#xe61f;</i> 查看入住</a>'
                            + '<a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="' + i + '"><i class="layui-icon">&#xe640;</i>结账</a></td>'
                    } else if (currData[i].orderstate == 3) {
                        html2 = '<td style="color:#ff2013;">已取消</td>'
                    } else if (currData[i].orderstate == 5) {
                        html2 = '<td style="color:#fffb17;">已完成</td>'
                        html33 = '<td><a class="layui-btn layui-btn-danger layui-btn-mini" data-id="' + i + '" href ="liveAdd.html?' + currData[i].orderid + '"><i class="layui-icon">&#xe61f;</i> 查看入住</a></td>'
                    } else if (currData[i].orderstate == 1) {
                        html2 = '<td style="color:#1215ff;">未付款</td>'
                        html33 = '<td><a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="' + currData[i].orderid + '"><i class="layui-icon">&#xe640;</i>去支付</a> <a class="layui-btn layui-btn-danger layui-btn-mini links_del" data-id="' + i + '" name="' + currData[i].orderid + '"><i class="layui-icon">&#xe640;</i>取消</a></td>'
                    }
                    dataHtml += '<tr>'
                        + '<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
                        + '<td align="left" class="orderid">' + currData[i].orderid + '</td>'
                        + '<td>' + currData[i].room.roomnum + '</a></td>'
                        + '<td>' + currData[i].member.mennum + '</td>'
                        + html2
                        + '<td>' + currData[i].oldprice + '</td>'
                        + '<td>' + currData[i].newprice + '</td>'
                        + '<td>' + currData[i].otherprice + '</td>'
                        + '<td>' + doTime(currData[i].ordertime) + '</td>'
                        + '<td>' + doTime(currData[i].intime) + '</td>'
                        + '<td>' + doTime(currData[i].outtime) + '</td>'
                        + '<td>' + currData[i].remark + '</td>'
                        + html33
                        + '</tr>';
                }
            } else {
                dataHtml = '<tr><td colspan="14">暂无数据</td></tr>';
            }
            return dataHtml;
        }

        //分页
        var nums = 10; //每页出现的数据量
        if (that) {
            linksData = that;
        }
        laypage({
            cont: "page",
            pages: Math.ceil(linksData.length / nums),
            jump: function (obj) {
                $(".links_content").html(renderDate(linksData, obj.curr));
                $('.links_list thead input[type="checkbox"]').prop("checked", false);
                form.render();
            }
        })
    }

    function doTime(time) {
        var mystime = new Date(time)
        var addstime = mystime.getFullYear() + '-'
            + ((mystime.getMonth()) + 1)
            + '-' + (mystime.getDate()) + ' '
            + (mystime.getHours()) + ":"
            + (mystime.getMinutes()) + ":" + (mystime.getSeconds());
        return addstime;
    }
})
