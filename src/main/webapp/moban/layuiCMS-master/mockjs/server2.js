//调用mock方法模拟数据
Mock.mock(

    'http://mockjs2', {
        "data|1-10": [

            {
                "rtypeId":  /\d{5,10}/,
                "rtypeName|1-10": "★"

            }

        ]
    }
);
