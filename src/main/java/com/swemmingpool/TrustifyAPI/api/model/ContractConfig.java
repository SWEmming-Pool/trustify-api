package com.swemmingpool.TrustifyAPI.api.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ReadonlyTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

@Configuration
public class ContractConfig {

  private final String ACCOUNT_ADDRESS = "0xe35d534EBe71555191CB3ce09D7accEE8663444E";
  private final String CONTRACT_ADDRESS = "0x748E332b507968EdBfFE429F95BBF7D621a9a835";
  private final String INFURA_NODE = "https://sepolia.infura.io/v3/2309bf77660544a0b78cef8a85d33a1f";

  @Bean
  public HttpService httpService() {
    return new HttpService(INFURA_NODE);
  }

  @Bean
  public Web3j web3j() {
    return Web3j.build(httpService());
  }

  @Bean
  public ReadonlyTransactionManager transactionManager() {
    return new ReadonlyTransactionManager(web3j(), ACCOUNT_ADDRESS);
  }

  @Bean
  public DefaultGasProvider gasProvider() {
    return new DefaultGasProvider();
  }

  @Bean
  public ReviewSystem reviewSystem() {
    return ReviewSystem.load(CONTRACT_ADDRESS, web3j(), transactionManager(), gasProvider());
  }


}
