package com.kuark.tool.advance.advance20191228;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author rock
 * @detail RestTemplate�������ӳ�
 * @date 2022/3/8 17:39
 */
public class RestTemplateUtil {

    public RestTemplate create(){
        return new RestTemplate(httpRequestFactory());
    }

    public ClientHttpRequestFactory httpRequestFactory(){
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    public HttpClient httpClient(){
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http" , PlainConnectionSocketFactory.getSocketFactory())
                .register( "https" , SSLConnectionSocketFactory.getSocketFactory()).build();
        //����һ��client���ӣ��൱�����ӳص�����--MultiThreadedHttpConnectionManager��3.x�汾�е��������̳߳صõ�������
//        MultiThreadedHttpConnectionManager manager=new MultiThreadedHttpConnectionManager();
        PoolingHttpClientConnectionManager connectionManager =new PoolingHttpClientConnectionManager(registry);
        // ����������ӳص�����
        connectionManager.setMaxTotal(1000);
        // ÿ����������󲢷��� ��ָ������--��MaxTotal��ϸ��
        connectionManager.setDefaultMaxPerRoute(300);

        RequestConfig requestConfig =RequestConfig.custom()
                // ���ݷ��س�ʱʱ��
                .setSocketTimeout(10*60*1000)
                // ���ӳ�ʱʱ��
                .setConnectTimeout(10*60*1000)
                // �����ӳ��л�ȡ���ӵĳ�ʱʱ��
                .setConnectionRequestTimeout(1*10*1000)
                .build();

        CloseableHttpClient closeableHttpClient=HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .disableAutomaticRetries()
                .build();

        return closeableHttpClient;
    }
}
