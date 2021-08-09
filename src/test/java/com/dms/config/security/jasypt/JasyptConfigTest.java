package com.dms.config.security.jasypt;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JasyptConfigTest {

  @Test
  public void JasyptConfigTest() {
    String strForEncryptText = "sa";
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword("NseDmsApiServerJasyptKey");
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);

    String encryptText = encryptor.encrypt(strForEncryptText);
    System.out.println(encryptText);

    String decryptText = encryptor.decrypt(encryptText);
    System.out.println(decryptText);

    assertThat(strForEncryptText).isEqualTo(decryptText);

  }

}
