public class DynamicHtml {
    public String Response(){
        String responseMessage = "HTTP/1.1 200 OK";
        String responseBody = "<!DOCTYPE html>"+"<html lang=\"en\">"+"<head>"+"<meta charset=\"UTF-8\">"
                +"<title>Title</title>"+"</head>"+"<body>"+"<div class=\"dowebok\">\n" +
                "\n" +
                "         <div class=\"logo\"></div>\n" +
                "\n" +
                "         <div class=\"form-item\">\n" +
                "\n" +
                "             <input id=\"username\" type=\"text\" autocomplete=\"off\" placeholder=\"邮箱\">\n" +
                "\n" +
                "         </div>\n" +
                "\n" +
                "         <div class=\"form-item\">\n" +
                "\n" +
                "             <input id=\"password\" type=\"password\" autocomplete=\"off\" placeholder=\"登录密码\">\n" +
                "\n" +
                "         </div>\n" +
                "\n" +
                "         <div class=\"form-item\"><button id=\"submit\">登 录</button></div>\n" +
                "\n" +
                "         <div class=\"reg-bar\">\n" +
                "\n" +
                "             <a class=\"reg\" href=\"javascript:\">立即注册</a>\n" +
                "\n" +
                "             <a class=\"forget\" href=\"javascript:\">忘记密码</a>\n" +
                "\n" +
                "         </div>\n" +
                "\n" +
                "     </div>"+"</body>"+"</html>";
        return  responseMessage + "\n\n" + responseBody;
    }
}
