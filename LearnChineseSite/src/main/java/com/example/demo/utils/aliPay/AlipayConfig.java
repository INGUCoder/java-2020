package com.example.demo.utils.aliPay;

public class AlipayConfig {
    // 作为身份标识的应用ID
    public static String app_id = "2016102300744604";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key  = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4gFTPBWCHXuytrobI1vR3wnbHMcDZuWLU3ODX9HMx8Y7QeWHlDhXANyJfP0ijdWiWgbwOHeW51uI+T9gminV0JP4ytnFBob1w8R2UILxetqrQiiEUaC0yN7hyjWsQ9+N9Wa+RbcMwx8l4k/T/Wucri4h9dYQKo9kRXSA+F3NmMep/LO9icAaBntSuNQ/vGU0QLvjAZfkEjU0L4fZyXiHiFDb89PcBML/7JfspIryZpj4U7rzydLJame7427lL2iRWYfAF6mcdk70ReKSpjkWVvfAsn9IpaAON6F6KCPLYP6x/2unFl+280fJrFry8SqtecY4n+MQpFDd5i8lbAr47AgMBAAECggEBAIlVDMukBvv8jlOhizZHumTCXUNcJ15o/cXQO5TDolNUqKdJErM6zrnq0CzxoBH7vMP7AY3Id0zjRDh5mjzl5xNyzbvVzWu7BpXhA9FUpKIjefYMOx9DhBDTJPovhbh1q+GMNoEboKTYsYCNMVo5wcTJ8ejg5k49M8AW/374Wa+AxyI7LHkEhrrDAl3LwG9jIbjridlSMXDwujEyrJsmfDBR2M+Gk6TiLU3Nqx7AMp6E8JIJ5YbcHcB8IViyhI/PyE/JKWIQCOdRA+WZq+1RyAY/PzLFrU+NmSZmDsq9fFJZXFAcgoajmHtE6PaMVJiQXqdGVhquiLmTSFXwMavbQOECgYEA76ykkVONqMrEPOqU7J5p5pmxP3u1HxbKPFsCZZnUWfljfJm5U2pgZdsxiqJilVzRl/LOMm4tt1LC7Y/Lyt+n/ca3N4rDM3VKcycF++vTpeskd5rmX8/wsih4ZpKoKizUxgETpEzdQIX7QBL5kVn3D/2DhZxu959gHAIkFcaIl4kCgYEAxRGZfh8Vlhccb9A67/w/7ivxt8X/UB1WhgMPdWaMqQFloCbYFNccf0eU1xEhECoTw6Ra4Nmj9WQrwkuqII8KLAVuXUcY/v5Ui1JWGldTANswE4mrbIymEo8D0J/VCfQcvwC15c7Yd8wUcQWfJFOIek8CLYbHx2+6Ca4rMisFsqMCgYEAmSPzxxPfGPHub4nn/ETAH+MmOQz/Ts0ODYCNSIQBBjhuVAgZPW5kB9EFl7JoUU2Mco1nKRvzRAaynH5b1dYQjfuxx+B3F2MjXe6aSTyG8KYNmAq2lpPUFNH9FHUy1DfvAFFhzoJ6gKbbQjadlj0ouuPebLnmwXvpOhw4GF3RmxkCgYBjdwyX4ayNgsCxltIIirLhzYBFF0RT9VrUbPsCcG4SZ0gZ20E405HolAKFwnmDpRkwp+XOk0rz8kk72eDWahviOCOKJPZyzX9yim43AVg9mGPdmKDTOvIfb9unEuT+Dx3rMbqdcRdE79ZpbULznM3HndUlkV+IQ9YMSMI4ogpQLQKBgFLuZ/1LslpLUCRHPRnAhKNUx/gu6d7qcDx/YnliUPAomhUCIqC6kfBbZUh+NbL8HAojqEsXJID7Tqcq2xNi4zrS5RcwVC/CdngBBVKRbDckhWdjPfhJwzGVDJi74650uWngcpFBmFMbcPku8C1b5PcpL67XCteZ/6T1OCvTzbtU";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs41gfdLIq2IA6UOLsq94MNOjTlfY9zhlAxuDy3AJf9Y/D+15YPeT9ujDKPayUqW9JAEaLU+af3Ea8WaGICrjO4wPX9w5FsKD+YrrMD0o3MVhD2MsQXJEUaRGGyQkO1ZhbzsUOXcSGH2z6eiaSd0i6TVxSWE7YB4un2DAXm4gMy4QsB7aZ2Qm70fm6LMbIDHRdvw4n2j/6h4rOI9ZxR8X+AZHUq/9XnWySkO6ekncN2ZhG42K3DSIto0alX5hyU7sVxQPvEyBkdZm0loocUQkj1EMh22xCTNZYf9fyIQQPg6qE3sgcvLF/DoXTApre2BgG+Tbj/aVbcIRxvVXWwgFswIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://47.93.87.124";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
