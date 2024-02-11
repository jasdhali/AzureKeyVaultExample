package com.example.azure.keyvault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.security.keyvault.secrets.SecretClient;

@SpringBootApplication
public class SimpleSpringBootAzureKeyVaultUsageExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootAzureKeyVaultUsageExampleApplication.class, args);
	}
	// Spring Cloud Azure will automatically inject SecretClient in your ApplicationContext.
    private final SecretClient secretClient;

    public SimpleSpringBootAzureKeyVaultUsageExampleApplication(SecretClient secretClient) {
        this.secretClient = secretClient;
    }


    @Override
    public void run(String... args) {
        System.out.println("h2url: " + secretClient.getSecret("h2url").getValue());
    }

}
