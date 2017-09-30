package com.jusheng.jeeboot.Sys;


import com.jusheng.jeeboot.system.RetObject;
import com.jusheng.jeeboot.system.SysCode;
import com.jusheng.jeeboot.utils.JsonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTester {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private List<String> cookies;

    @Before
    public void init(){
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("username", "admin");
        params.add("password", "123456");

        ResponseEntity<RetObject> response=testRestTemplate.postForEntity("/api/sys/login",params, RetObject.class);
        cookies=response.getHeaders().get("Set-Cookie");

        System.out.println(JsonUtils.toJson(response));

        if(response.getBody().getRetCode().equals(SysCode.RET_Succ)){
            System.out.println("login success");
        }else{
            System.out.println("login fail");
        }
    }

    @Test
    public void list() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Cookie",cookies.get(0));

        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("page", "1");
        params.add("rows", "5");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        //  执行HTTP请求
        ResponseEntity<RetObject> response = testRestTemplate.exchange("/api/role/list", HttpMethod.GET, requestEntity, RetObject.class);

        //  输出结果
        System.out.println(JsonUtils.toJson(response.getBody()));

    }

    @Test
    public void add() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Cookie",cookies.get(0));

        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("name", "555");
        params.add("useable", "1");
        params.add("officeId", "1");
        params.add("opFlag", "add");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        //  执行HTTP请求
        ResponseEntity<RetObject> response = testRestTemplate.exchange("/api/role/save", HttpMethod.POST, requestEntity, RetObject.class);

        //  输出结果
        System.out.println(JsonUtils.toJson(response.getBody()));

    }


    @Test
    public void update() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Cookie",cookies.get(0));

        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
        params.add("name", "54545454");
        params.add("userable", "1");
        params.add("officeId", "1");
        params.add("opFlag", "update");
        params.add("id", "06e4fd63c2ae4e15adce0de67f625c26");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        //  执行HTTP请求
        ResponseEntity<RetObject> response = testRestTemplate.exchange("/api/role/save", HttpMethod.POST, requestEntity, RetObject.class);

        //  输出结果
        System.out.println(JsonUtils.toJson(response.getBody()));

    }


    @Test
    public void delete() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Cookie",cookies.get(0));

        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        //  执行HTTP请求
        ResponseEntity<RetObject> response = testRestTemplate.exchange("/api/role/delete/06e4fd63c2ae4e15adce0de67f625c26", HttpMethod.GET, requestEntity, RetObject.class);

        //  输出结果
        System.out.println(JsonUtils.toJson(response.getBody()));
    }


}