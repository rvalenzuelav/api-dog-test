package cl.mobdev.pruebatecnicabackend;

import cl.mobdev.pruebatecnicabackend.service.ApiDogClientService;
import cl.mobdev.pruebatecnicabackend.service.beans.ApiDogResponse;
import cl.mobdev.pruebatecnicabackend.web.beans.TestResponse;
import cl.mobdev.pruebatecnicabackend.web.mapper.ResponseMapper;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebatecnicaBackendApplicationTests {

    @Autowired
    private ApiDogClientService apiDogClientService;

    @Value("${api.dog.breeds.list}")
    private String urlOverHttps;

	@Test
	public void contextLoads() {
	}

    @Test
    public void givenAcceptingAllCertificatesUsing4_4_whenUsingRestTemplate_thenCorrect()
            throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        ResponseEntity<String> response
                = new RestTemplate(requestFactory).exchange(
                urlOverHttps, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode().value(), equalTo(200));
    }

    @Test
    public void givenNullValueTestResponseMappper() {
        TestResponse testResponse = ResponseMapper.buildResponse(null);
        assertNotNull(testResponse);
    }

    @Test
    public void givenNotNullValueTestResponseMappper() {
        TestResponse testResponse = ResponseMapper.buildResponse("boxer");
        assertNotNull(testResponse);
    }

    @Test
    public void getAllBreedListNotNullTest(){
        Assert.assertNotNull(apiDogClientService.getAllBreedList());
    }

}
