package com.apex;



import com.alibaba.fastjson.JSONArray;
import com.apex.presistence.mapper.TstProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
@Slf4j
public class AppTest {
    @Test
    public void shouldAnswerWithTrue()
    {
        //1.加上classpath:前缀（这个时候xml要放在当前目录也就是src下）
        ApplicationContext context=new FileSystemXmlApplicationContext("F:/work/BIZProject/src/main/Resources/spring/applicationContext.xml");
        // 2.加上file:把路径写全(用这个方法xml可以放任意地方)
        //F:\webApp\HomeBlogNew\blog-core\src\main\resources\spring\applicationContext.xml
        // ApplicationContext context=new ClassPathXmlApplicationContext("file:F:/webApp/HomeBlogNew/blog-core/src/main/resources/spring/applicationContext.xml");
        log.info(JSONArray.toJSONString(context.getBeanDefinitionNames()));
        TstProductMapper tstProductMapper=(TstProductMapper)context.getBean("tstProductMapper");
        System.out.println(tstProductMapper.selectAll());
    }


}
