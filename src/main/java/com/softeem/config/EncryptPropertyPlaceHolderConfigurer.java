package com.softeem.config;

import com.softeem.utils.DESUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * @project_name: com.softeem.config
 * @description: 自定义IOC容器读取外部配置文件的类
 * @author: Nicholas Chen
 * @time: 7/02/2021 3:32 PM
 * @version: v1.0
 */
public class EncryptPropertyPlaceHolderConfigurer extends PropertySourcesPlaceholderConfigurer {

    //已加密的字段
    private String[] encryptPropertyNames ={"jdbc_username","jdbc_password"};

    /*
     * @Description 对关键字段做转化 (老版本)
     * @Date 3:51 PM 7/02/2021
     * @Param [propertyName, propertyValue]
     * @return java.lang.String
     */
//    @Override
//    protected String convertProperty(String propertyName, String propertyValue) {
//        //1. 判断该字段是否已被加密
//        //2. 如果已经被加密，则进行一个解密。如果没有被加密就鸳鸯返回
//        if(isEncryptedProperty(propertyName)){
//            //解密
//            return DESUtils.getDecryptedString(propertyValue);
//        }
//        return propertyValue;
//    }

    /**
     * 对已加密属性做覆盖 (新版本)
     * @param props 整个属性
     * @throws IOException
     */
    @Override
    protected void loadProperties(Properties props) throws IOException {
        super.loadProperties(props);
        //遍历属性中的所有字段
        for (String key:encryptPropertyNames) {
            //对已加密的字段进行解密
            if(isEncryptedProperty(key)){
                //解密
                String decryptedString = DESUtils.getDecryptedString(props.getProperty(key));
                //在IOC中覆盖覆盖
                props.setProperty(key,decryptedString);
            }
        }
    }

    /**
     * 判断该属性是否已经被加密（或者说判断该属性需不需要解密）
     * @param propertyName
     * @return
     */
    private boolean isEncryptedProperty(String propertyName){
        for (String encryptPropertyName: encryptPropertyNames) {
            if(encryptPropertyName.equals(propertyName)){
                return true;
            }
        }
        return false;
    }
}
