package kr.re.kitri.springpost.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration  // 이것도 컴포넌트기 때문에 was가 시작될때 같이 생성 등록 즉 db에 접속된다.
@PropertySource("classpath:/application.properties") // 이 파일을 참고해서 하겠다.
public class DatasourceConfiguration {

    @Bean // 자바 컴포넌트이고 스프링컴포넌트보다 우선 만들어진다.
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource);
        return dataSource;
    }
}
