package hello.spring_mvc_study.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request")
public class RequestParamServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // http://localhost:8080/request

        // json데이터를 String으로 받아오기
        ServletInputStream inputStream = request.getInputStream();
        String result = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("result : " + result);                               // result : {"name": "servlet", "phone": "iphone"}

        // json데이터를 객체에 담아서 가져오기
        JsonDto jsonDto = objectMapper.readValue(result, JsonDto.class);
        System.out.println("jsonDto.getName = " + jsonDto.getName());           // jsonDto.getName = servlet
        System.out.println("jsonDto.getPhone = " + jsonDto.getPhone());         // jsonDto.getPhone = iphone
    }
}
