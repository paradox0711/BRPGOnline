package servlets;
/**
 * servlet基类，利用反射实现方法
 */

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            Class clazz=this.getClass();
            String methodName=req.getParameter("method");
            Method method=clazz.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,res);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
