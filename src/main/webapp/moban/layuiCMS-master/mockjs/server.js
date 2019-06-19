//调用mock方法模拟数据
Mock.mock(
    'http://mockjs', {
        "data|1-10": [

                 {
                    "orderId":  /\d{5,10}/,
                    "roomId":  /\d{5,10}/,
                    "memId": /\d{5,10}/,
                    "orderstate|1": true,
                    "Deposit": /\d{5,10}/,
                    "price": /\d{5,10}/,
                    "ordertime": Mock.mock('@date'),
                    "inTime": Mock.mock('@date'),
                    "outTime": Mock.mock('@date'),
                    "remark": /\d{5,10}/,
                }

        ]
    }

);
